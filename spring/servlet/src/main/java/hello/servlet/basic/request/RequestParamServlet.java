package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
1. 파라미터 전송기능
http://localhost:8080/request-param?username=hello&age=20

2. HTML form 을 통해 전송
Content-type에서 x-www-form-urlencoded를 사용하면 form에서 작성한 데이터를 마치 쿼리 파라미터처럼 만들어 HTTP 요청 메시지 본문에 넣어주기 때문에 HTML form으로 요청온 데이터도 파라미터와 똑같이 처리하면 된디
1번과 차이점은 1번은 쿼리 파라미터로 보내고 본문에 내용이 없기 때문에 Content-type 없고 2번은 데이터를 쿼리 파라미터형태로 본문에 넣기 때문에 Content-type(본문 데이터 형식)이 있다
 */
@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");
        // getParameterNames() -> 모든 파라미터 이름(=키)을 조회 username, age
        // request.getParameter(파라미터명) -> 파라미터 이름(=키)에 해당하는 값 hello, 20
        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName -> System.out.println(parameterName + " = " + request.getParameter(parameterName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        // 이름이 같은 복수 파라미터일 경우 getParameterValues(파라미터명) 메서드 사용
        // -> 파라미터명의 모든 값을 다 가져옴
        // 만약 복수 파라미터인데 getParameter 메서드를 사용하면 파라미터의 첫 값을 가져옴
        // 복수 파라미터가 아니어도 사용할 수 있지만 굳이...그때는 단일 파라미터 조회 방법을 사용
        String[] usernames = request.getParameterValues("username");
        for(String name: usernames) {
            System.out.println("name = " + name);
        }

        response.getWriter().write("OK");
    }
}
