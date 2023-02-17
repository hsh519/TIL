package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// urlPatterns 에서 * -> 하위에 들어오면 일단 이 서블릿 먼저 호출. 여기서는 v1 하위로 들어올 경우 이 서블릿 먼저 호출
@WebServlet(name="frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI
        String requestURI = request.getRequestURI();
        // 요청 URI를 가지고 값을 꺼낸다. 그 값이 Controller. 즉 프론트 컨트롤러가 요청 URI에 맞는 컨트롤러를 실행
        ControllerV4 controller = controllerMap.get(requestURI);
        // 요청 URI가 컨트롤러모음(controllerMap)에 없다면 Not Found
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // createParamMap 메서드를 실행해 Map 반환받고 controller에 Map을 넘겨주면서 로직 실행
        // controller는 ModelView를 반환하기 때문에 ModelView타입 변수 선언
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);
        MyView view = viewResolver(viewName);
        view.render(model, request, response);
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
