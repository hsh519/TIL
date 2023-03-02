package hello.itemservice.web.basic;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

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
    public String addForm() {
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
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) {
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