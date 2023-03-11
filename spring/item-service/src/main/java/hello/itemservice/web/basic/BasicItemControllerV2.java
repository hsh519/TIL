package hello.itemservice.web.basic;

import hello.itemservice.domain.DeliveryCode;
import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import hello.itemservice.domain.ItemType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/v2/items")
@RequiredArgsConstructor
public class BasicItemControllerV2 {

    private final ItemRepository itemRepository;

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
        return "v2/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "v2/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "v2/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        if(item.getPrice() != null && item.getQuantity() != null) {
            if(item.getPrice() * item.getQuantity() < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000}, null);
            }
        }

        log.info("errors={}", bindingResult);
        if(bindingResult.hasErrors()) {
            return "/v2/addForm";
        }

        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/v2/items/{itemId}";
    }

    @GetMapping("/{userId}/edit")
    public String editForm(@PathVariable long userId, Model model) {
        Item item = itemRepository.findById(userId);
        model.addAttribute("item", item);

        return "v2/editForm";
    }

    @PostMapping("/{userId}/edit")
    public String editItem(@Validated @ModelAttribute Item item, BindingResult bindingResult, @PathVariable long userId) {
        if(item.getPrice() != null && item.getQuantity() != null) {
            if(item.getPrice() * item.getQuantity() < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000}, null);
            }
        }

        if(bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "/v2/editForm";
        }

        itemRepository.update(userId, item);
        return "redirect:/v2/items/{userId}";
    }

    // 테스트 아이템
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }


}
