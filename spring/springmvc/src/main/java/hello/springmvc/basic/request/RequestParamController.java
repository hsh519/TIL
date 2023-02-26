package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }
    @ResponseBody // @RestController 어노테이션과 같은 기능. 반환값을 바로 응답 메시지 본문에 저장
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username={}, age={}", memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            // 쿼리 파라이터 명과 파라미터 명이 동일하면 ("쿼리 파라미터명") 생략 가능
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    // int, String, Integer 와 같은 단순 타입이면 @RequestParam 어노테이션도 생략 가능
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            // 요청할 때 필수로 작성해야 하는 쿼리 파라미터일 경우 request = true
            // 필수로 작성하지 않아도 되는 쿼리 파라미터일 경우 request = false
            // required 기본값 -> true
            // 빈문자 입력시 값을 입력했다고 인식해 'username=' 만 입력해도 에러가 발생하지 않는다
            @RequestParam String username,
            @RequestParam(required = false) Integer age) {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            // 쿼리 파라미터 값이 없을 경우 defaultValue 를 지정해 기본값을 정할 수 있다
            // 빈문자 입력시 defaultValue 값으로 치환
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    // 요청의 모든 쿼리 파라미터를 Map 으로 받을 수 있다
    // 쿼리 파라미터별로 값이 하나임이 보장될 경우 Map, 그렇지 않을 경우 MultiValueMap
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    // @ModelAttribute -> 쿼리 파라미터 값을 받아 객체에 저장하는 기능을 하는 어노테이션
    // 쿼리 파라미터 명과 일치하는 프로퍼티를 HelloData 객체에서 찾고, 있으면 setter 를 통해 바인딩
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    // @ModelAttribute 어노테이션을 생략할 수 있다
    // Integer, int, String 처럼 단순 타입이 아니기 떄문에 생략하면 @ModelAttribute 어노테이션이 적용되야함을 안다
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
