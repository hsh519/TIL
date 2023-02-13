package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 일반 text 형식 데이터를 전달받을 경우

        // getInputStream -> 요청 매개변수의 값을 바이트 코드로 반환하고, 매개변수가 없으면 null 반환
        // 반환형이 ServletInputStream
        // HTTP 서블릿의 경우 매개변수는 쿼리 파라미터 혹은 본문 데이터
        ServletInputStream inputStream = request.getInputStream(); // ServletInputStream 타입 요청된 데이터를 바이트 코드로 리턴

        // ServletInputStream 타입을 String 타입으로 변환 필요
        // StreamUtils에 copyToString 메서드는 InputStream 타입을 문자열로 복사해서 리턴
        // ServletInputStream은 InputStream을 상속받은 자식 클래스
        // 첫번째 값은 복사할 inputStream 값, 두번째 값은 바이트 코드를 디코딩할 Charset
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("OK");
    }
}
