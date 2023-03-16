package hello.itemservice.web.basic;

import hello.itemservice.domain.*;
import hello.itemservice.web.basic.form.ItemSaveForm;
import hello.itemservice.web.basic.form.ItemUpdateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/v3/items")
@RequiredArgsConstructor
public class BasicItemControllerV3 {

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
        return "v3/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "v3/item";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("item", new Item());
        return "v3/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute("item") ItemSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if(form.getPrice() != null && form.getQuantity() != null) {
            if(form.getPrice() * form.getQuantity() < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000}, null);
            }
        }

        log.info("errors={}", bindingResult);
        if(bindingResult.hasErrors()) {
            return "/v3/addForm";
        }

        Item item = new Item();
        item.setItemName(form.getItemName());
        item.setPrice(form.getPrice());
        item.setQuantity(form.getQuantity());
        item.setOpen(form.getOpen());
        item.setRegions(form.getRegions());
        item.setItemtype(form.getItemtype());
        item.setDeliveryCode(form.getDeliveryCode());

        Item saveItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", saveItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/v3/items/{itemId}";
    }

    @GetMapping("/{userId}/edit")
    public String editForm(@PathVariable long userId, Model model) {
        Item item = itemRepository.findById(userId);
        model.addAttribute("item", item);

        return "v3/editForm";
    }

    @PostMapping("/{userId}/edit")
    public String editItem(@Validated @ModelAttribute("item") ItemUpdateForm form, BindingResult bindingResult, @PathVariable long userId) {
        if(form.getPrice() != null && form.getQuantity() != null) {
            if(form.getPrice() * form.getQuantity() < 10000) {
                bindingResult.reject("totalPriceMin", new Object[]{10000}, null);
            }
        }

        if(bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "/v3/editForm";
        }

        Item itemParam = new Item();
        itemParam.setItemName(form.getItemName());
        itemParam.setPrice(form.getPrice());
        itemParam.setQuantity(form.getQuantity());
        itemParam.setOpen(form.getOpen());
        itemParam.setRegions(form.getRegions());
        itemParam.setItemtype(form.getItemtype());
        itemParam.setDeliveryCode(form.getDeliveryCode());

        itemRepository.update(userId, itemParam);
        return "redirect:/v3/items/{userId}";
    }

    // 테스트 아이템
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }


}
