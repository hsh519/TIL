package hello.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
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
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {
    // JSON을 자바 객체로, 자바 객체를 JSON으로 변환해주는 객체
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("messageBody={}", messageBody);

        // JSON을 HelloData 객체로 변환해 helloData에 저장
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String messageBody) throws JsonProcessingException {
        log.info("messageBody={}", messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    // @RequestBody 어노테이션도 HttpEntity와 마찬가지로 바이트 코드를 문자열로 변환해주는 것뿐 아니라 객체로도 변환
    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) {
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    // HttpEntity를 사용해 바이트 코드를 객체로 변환
    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyJsonV4(HttpEntity<HelloData> data) {
        HelloData helloData = data.getBody();
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    // @RequestBody 어노테이션을 생략하면 @ModelAttribute 어노테이션이 자동 실행
    // 그러면 메시지 바디 정보를 가져와야 하는데 쿼리 파라미터를 가져올려고 하기 때문에 전혀 다른 결과가 나온다
    // 따라서 @RequestBody 어노테이션은 생략 불가능

    // @ResponseBody 어노테이션도 문자열 뿐 아니라 객체도 메시지 바디에 넣어줄 수 있다
    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) {
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());

        return helloData;
    }
}


