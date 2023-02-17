package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {
    // 모든 버전의 컨트롤러를 받을 수 있도록 Object 선언
    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    // 핸들러 리스트 선언. 여기서 핸들러는 컨트롤러
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    // 핸들러 어댑터를 핸들러 리스트에 추가하는 메서드. V3 핸들러 어댑터를 추가
    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI에 맞는 핸들러(컨트롤러) 반환
        Object handler = getHandler(request);

        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // 해당 핸들러(컨트롤러)에 맞는 핸들러 어댑터 반환
        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        // 핸들러 어댑터를 사용해서 캐스팅(여기서는 V3컨트롤러기 떄문에 Object -> V3). 참고로 V3은 ModelView를 반환
        // 이후에는 V3 방식으로 jsp 페이지를 열면 된다
        ModelView mv = adapter.handle(request, response, handler);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private static MyView viewResolver(String viewName) {
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }

    // 핸들러 리스트를 반복하면서 핸들러(컨트롤러)가 해당 핸들러 어댑터로 만들어졌는지 확인해 맞으면 핸들러 어댑터 반환
    // 핸들러가 핸들러 리스트에 있는 핸들러 어댑터들로 안만들어 졌다면 예외 발생
    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if(handlerAdapter.supports(handler)) {
                return handlerAdapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler= " + handler);
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        // 값의 타입이 Object라서 리턴형이 Object
        return handlerMappingMap.get(requestURI);
    }
}
