package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// urlPatterns 에서 * -> 하위에 들어오면 일단 이 서블릿 먼저 호출. 여기서는 v1 하위로 들어올 경우 이 서블릿 먼저 호출
@WebServlet(name="frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI
        String requestURI = request.getRequestURI();
        // 요청 URI를 가지고 값을 꺼낸다. 그 값이 Controller. 즉 프론트 컨트롤러가 요청 URI에 맞는 컨트롤러를 실행
        ControllerV2 controller = controllerMap.get(requestURI);
        // 요청 URI가 컨트롤러모음(controllerMap)에 없다면 Not Found
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // JSP 페이지를 여는 코드 중복
        // -> JSP 페이지를 여는 메서드를 가진 MyView 클래스를 만들고 요청 URI에 맞는 컨트롤러가 jsp의 경로를 가지고 있는 MyView 객체를 생성.
        // -> 컨트롤러가 리턴한 MyView 객체에 따라 다른 JSP 페이지가 열린다
        MyView view = controller.process(request, response);
        view.render(request, response);
    }
}
