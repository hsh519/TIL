package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodySpringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 본문 데이터를 바이트 코드로 변환후 복사한 뒤 복사값을 UTF-8 문자셋으로 디코딩(문자열 변환)
        ServletInputStream inputStream = request.getInputStream();
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", s);
        // Writer 객체 생성후 write 메서드로 응답 메시지 작성
        response.getWriter().write("ok");
    }

    // 스프링 MVC는 InputStream(Reader), OutputStream(Writer) 파라미터 지원
    // InputStream(Reader) 파라미터 -> 바이트 코드로 변환한 본문 데이터
    // OutputStream(Writer) 파라미터 -> Writer 객체
    @PostMapping("/request-body-string-v2")
    public void requestBodySpringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String s = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", s);
        responseWriter.write("ok");
    }

    // HttpEntity 가 메시지 컨버터를 사용해 바이트 코드를 문자열, 객체로 변환해서 HttpEntity 파라미터에 저장
    // HttpEntity 객체에서 HTTP 헤더, 바디 정보를 편리하게 조회 가능
    // HttpEntity 를 응답에도 사용 가능. 본문에 넣을 메시지, 헤더 정보 작성 등등.. 응답 또한 메시지 컨버터를 사용(문자열 객체 -> 메시지 바디)
    // View 조회 X
    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodySpringV3(HttpEntity<String> httpEntity) throws IOException {
        String messageBody = httpEntity.getBody();
        log.info("messageBody={}", messageBody);

        return new HttpEntity<>("ok");
    }

    // @RequestBody -> v3에 HttpEntity와 같은 기능을 하는 어노테이션
    // @ResponseBody -> return 문자열을 그대로 메시지 본문에 넣어주는 어노테이션. View 조회 X다
    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodySpringV4(@RequestBody String messageBody) throws IOException {
        log.info("messageBody={}", messageBody);

        return "ok";
    }
}
