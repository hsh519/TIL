package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // Model과 View의 논리적 이름을 반환
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");

        return mav;
    }

    // Model은 파라미터로 전달받고 View의 논리적 이름만 반환
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello");
        return "response/hello";
    }

    // View의 논리적 이름을 URL 경로로 사용하면서 View의 논리적 이름 반환을 제거
    // 즉, localhost:8080/response/hello 로 요청하면 templates/response/hello.html 이 실행
    // 명시성이 너무 떨어져 권장하지 않는다
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello");
    }
}
