package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // @Slf4j 어노테이션을 쓰면 롬복이 자동으로 로그 생성(주석 처리한 코드를 작성하는 것과 같은 효과)
@RestController // 반환 값으로 뷰를 찾지 않고(=@Controller) 바로 응답 메시지 본문에 입력
public class LogTestController {


//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        // 로그 레벨 trace -> debug -> info -> warn -> error
        // 보통 개발 서버에선 debug, 운영 서버에선 info부터 출력
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
