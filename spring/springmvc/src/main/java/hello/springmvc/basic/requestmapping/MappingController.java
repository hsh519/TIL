package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {
    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }
    // RequestMapping 어노테이션의 method를 사용해 HTTP 메서드를 지정할 수 있다
    // mapping-get-v1 경로로 POST 요청을 한다면 405 에러 발생
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }
    // HTTP 메서드를 축약한 어노테이션 (RequestMapping 어노테이션 + method)
    // GetMapping, PostMapping, PutMapping, DeleteMapping, PatchMapping
    // 해당 어노테이션의 구조를 보면 @RequestMapping(..., method=해당 HTTP 메서드) 가 작성돼있다
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }
    // API 경우 리소스 경로에 식별자를 넣는 방법을 선호. ex) 회원 조회, 수정, 삭제..
    // 이 식별자를 @PathVariable 어노테이션을 통해 가져올 수 있다
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    // 식별자가 여러개여도 다 가져올 수 있다
    // 식별자명과 파라미터 명이 동일하면 생략 가능
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}", userId);
        log.info("mappingPath orderId={}", orderId);
        return "ok";
    }
    // 해당 URL로 요청할 때 쿼리 파라미터 값이 params 값이랑 동일하면 매핑
    // 즉, /mapping/param?mode=debug 일때만 매핑. 잘 사용하지 않는다
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    // 해당 URL로 요청할 때 헤더에 headers 값이 들어있다면 매핑
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
    // 해당 URL로 POST 요청 할 때, 본문 타입이 consumes 면 매핑
    // 즉, /mapping/consume은 application/json 타입의 요청 메시지만 받는다
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    }
    // 해당 URL로 POST 요청 할 때, Accept 가 produces 면 매핑
    // Accept 는 클라이언트가 반환받았음 하는 것들(본문 타입, 언어 ...)
    // 즉, /mapping/consume은 Accept 가 text/html 인 요청 메시지만 받는다
    // 만약 클라이언트는 /mapping/consume 로 요청해서 application/json을 받길 원하는데 produces 가 text/html 이라면 맞지 않기 때문에 406 에러 발생
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }
}
