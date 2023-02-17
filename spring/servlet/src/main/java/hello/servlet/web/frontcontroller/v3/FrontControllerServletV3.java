package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// urlPatterns 에서 * -> 하위에 들어오면 일단 이 서블릿 먼저 호출. 여기서는 v1 하위로 들어올 경우 이 서블릿 먼저 호출
@WebServlet(name="frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI
        String requestURI = request.getRequestURI();
        // 요청 URI를 가지고 값을 꺼낸다. 그 값이 Controller. 즉 프론트 컨트롤러가 요청 URI에 맞는 컨트롤러를 실행
        ControllerV3 controller = controllerMap.get(requestURI);
        // 요청 URI가 컨트롤러모음(controllerMap)에 없다면 Not Found
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // createParamMap 메서드를 실행해 Map 반환받고 controller에 Map을 넘겨주면서 로직 실행
        // controller는 ModelView를 반환하기 때문에 ModelView타입 변수 선언
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        // ModelView에서 viewName을 가져와서 viewResolver 메서드 실행
        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        // render 메서드를 통해서 jsp 페이지를 연다
        // mv.getModel()도 render 메서드에 넘기는 이유
        // -> jsp는 request.getAttribute 를 통해서 데이터를 가져다 쓰기 떄문에
        // ModelView 객체의 model 필드에 저장된 데이터(Controller가 저장한 데이터들)를 request.setAttribute 해야햔다
        view.render(mv.getModel(), request, response);
    }

    // viewName(논리적인 이름)을 받아 물리적인 이름을 가진 MyView 객체 생성후 리턴
    private static MyView viewResolver(String viewName) {
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }

    // 모든 요청 파라미터를 (파라미터명, 파라미터값) 형태로 맵에 저장해 리턴
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
