package hello.itemservice.web.basic;

import hello.itemservice.domain.DeliveryCode;
import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import hello.itemservice.domain.ItemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;
//    private final ItemValidator itemValidator;
//
//    // WebDataBinder는 스프링의 파라미터 바인딩과 검증을 해준다
//    @InitBinder // 해당 컨트롤러에만 영향을 준다는 뜻을 가진 어노테이션
//    public void init(WebDataBinder dataBinder) {
//        // WebDataBinder에 검증기 추가. 컨트롤러에서 검증기 자동 적용
//        dataBinder.addValidators(itemValidator);
//    }

    // 상품 조회, 상품 수정등에도 같은 코드가 계속 사용
    // ModelAttribute("이름") 어노테이션 메서드에 사용하면 해당 메서드를 실행해 리턴되는 결과값을
    // 해당 컨트롤러가 호출될 때 자동으로 model.addAttribute("이름", 결과값) 코드를 수행해 model에 담긴다
    @ModelAttribute("regions")
    public Map<String, String> regions() {
        // 순서 보장을 위해 LinkedHashMap 사용
        Map<String, String> regions = new LinkedHashMap<>();
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");

       return regions;
    }

    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values();
    }

    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes() {
        List<DeliveryCode> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
        deliveryCodes.add(new DeliveryCode("NORMAL", "보통 배송"));
        deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));

        return deliveryCodes;
    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "basic/addForm";
    }

//    @PostMapping("/add")
//    @RequestParam 어노테이션 사용
    public String addItemV1(
            @RequestParam String itemName,
            @RequestParam int price,
            @RequestParam int quantity, Model model) {
        Item item = new Item(itemName, price, quantity);
        itemRepository.save(item);
        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
//    @ModelAttribute 사용. @ModelAttribute("이름") 형식으로 작성하면 model.addAttribute("이름", ... ) 코드 자동 실행
    public String addItemV2(@ModelAttribute("item") Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

//    @PostMapping("/add")
//    이름을 생략하면 객체 타입의 첫문자를 소문자로 바꿔 model.addAttribute 에서 이름으로 사용
//    Item -> 첫글자만 소문자로(item) -> 이게 키
    public String addItemV3(@ModelAttribute Item item) {

        itemRepository.save(item);
        return "basic/item";
    }

//    @PostMapping("/add")
//    @ModelAttribute 어노테이션 생략 가능
//    어노테이션 생략시 String, int, double 같은 단순 타입 -> @RequestParam, 일반 객체(argument resolver에 선언된 객체 제외) -> @ModelAttribute
    public String addItemV4(Item item) {
        itemRepository.save(item);
        return "basic/item";
    }

//    @PostMapping("/add")
//    V4처럼 POST 요청으로 끝낼 경우 새로고침하면 마지막 요청이 POST 이기 때문에 상품을 계속 생성
//    따라서 Redirect를 통해 마지막 요청을 GET으로 끝내 새로고침해도 상품을 계속 생성하지 않도록 해야 한다
//    PRG -> Post, Redirect, Get
    public String addItemV5(Item item) {
        itemRepository.save(item);
        return "redirect:/basic/items/" + item.getId();
    }

    // + item.getId() 처럼 URL에 변수를 더해 사용하는 것은 인코딩이 안돼 위험
    // 만약 item.getId()가 한글이라면 원하는 URL로 이동 불가. 따라서 RedirectAttributes 사용
    @PostMapping("/add")
    // BindingResult의 위치는 @ModelAttribute 어노테이션이 있는 객체 뒤에 배치
    // 컨트롤러를 호출하기 전 Item 객체에 바인딩 할 때 타입 오류가 발생하면 FieldError 객체(거부된 값이 포함된 생성자 사용)를 생성해 bindingResult 에 담고 컨트롤러를 호출
    // 검증기를 사용하기 위해서 @Validated 어노테이션 추가. WebDataBinder에 추가한 여러 검증기중 supports() 의 반환값으로 true를 얻은 검증기의 validate() 실행
    public String addItemV6(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        // v5 -> itemValidator를 주입받아 사용
        // if(itemValidator.supports(item.getClass())) {
        //     itemValidator.validate(item, bindingResult);
        // }

        log.info("errors={}", bindingResult);
        if(bindingResult.hasErrors()) {
            return "/basic/addForm";
        }

        itemRepository.save(item);
        // 사용하지 않은 redirectAttributes 속성은 쿼리 파라미터로 넘어간다
        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("status", true);
        // @PathVariable 값을 리다이렉트 할 때 사용할 수 있다
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{userId}/edit")
    public String editForm(@PathVariable long userId, Model model) {
        Item item = itemRepository.findById(userId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    @PostMapping("/{userId}/edit")
    public String editItem(@PathVariable long userId, @ModelAttribute Item item, Model model) {
        itemRepository.update(userId, item);
        return "redirect:/basic/items/{userId}";
    }

    // 테스트 아이템
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }


}
