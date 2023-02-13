package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// /hello가 호출되면 서블릿 컨테이너가 매핑된 서블릿의 서비스 메서드를 호출한다
@WebServlet(name="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // HTTP 요청 메시지를 기반으로 request 객체 생성, HTTP 응답 메시지를 구성할 내용(헤더, 본문)을 저장할 response 객체 생성
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        // username 파라미터 값 가져오기
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 표현 헤더 Content-type에 들어갈 내용
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        // HTTP 응답 메시지 바디에 들어갈 내용
        response.getWriter().write("hello " + username);

        // 서블릿이 끝나면 response 객체에 저장한 내용을 기반으로 HTTP 응답 메시지를 생성
    }
}
