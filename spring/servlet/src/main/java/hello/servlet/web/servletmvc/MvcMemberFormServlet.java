package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // WEB-INF에 있는 폴더는 직접적으로 접근할 수 없다. 반드시 컨트롤러를 거치도록 WAS에 설정되어있다
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // viewPath로 재요청
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        // 실제 jsp를 호출함과 동시에 request, response도 넘겨준다
        requestDispatcher.forward(request, response);
    }
}
