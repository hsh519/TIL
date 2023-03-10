package hello.itemservice.web.basic;

import hello.itemservice.domain.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// 검증 로직은 컨트롤러에 작성하면 하나의 컨트롤러가 너무 많은 기능을 담당
// 따라서 검증 로직은 다른 클래스를 생성해서 작성하는 것이 좋다
@Component
public class ItemValidator implements Validator {

    // 해당 검증기를 해당 클래스가 지원하는지 여부
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    // 검증 객체과 BindingResult를 넘겨 검증 로직 실행
    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

         /* v1
        Map<String, String> errors = new HashMap<>();

        // 상품명 작성 검증
        if(!StringUtils.hasText(item.getItemName())) {
            errors.put("itemName", "상품 이름은 필수입니다.");
        }

        // 가격 검증(천원 ~ 백만원)
        if(item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            errors.put("price", "가격은 1000원 ~ 1000000원 사이 입니다.");
        }

        // 수량 검증(최대 9999개)
        if(item.getQuantity() == null || item.getQuantity() > 9999) {
            errors.put("quantity", "수량은 최대 9999개 입니다.");
        }

        // 글로벌 검증(가격 * 수량의 값이 10000 이상)
        if(item.getPrice() != null && item.getQuantity() != null) {
            if(item.getPrice() * item.getQuantity() < 10000) {
                errors.put("globalError", "가격과 수량을 곱한 값이 10000 이상이어야 합니다.");
            }
        }

        log.info("errors={}", errors);
        if(!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "/basic/addForm";
        }
        */

        // 상품명 작성 검증
        if(!StringUtils.hasText(item.getItemName())) {
            // FieldError는 ObjectError의 자식 객체

            // v2 -> 해당 코드는 에러가 생겼을 때 잘못 입력한 값을 지워 사용자가 전에 어떻게 작성했는지 모르게 한다
            // bindingResult.addError(new FieldError("item", "itemName", "상품 이름은 필수입니다."));

            // v3 -> new FieldError(오류가 발생한 객체명(@ModelAttribute 객체), 오류가 발생한 필드명, 거부된 값(사용자가 입력한 값), 바인딩 여부, 메시지 코드, 메시지에서 사용하는 인자, 디폴트 오류 메시지)
            // 이떄 메시지 코드는 국제화를 위한 메시지처럼 메시지 파일에 작성하면 된다. 배열인 이유는 내가 메인으로 사용하고자하는 메시지 코드가 에러 메시지 파일에 없을 수도 있기 때문
            // 일치하는 메시지 코드가 없으면 defaultMessage 출력, defaultMessage 도 없으면 예외 발생
            // bindingResult.addError(new FieldError("item", "itemName", item.getItemName(), false, new String[]{"required.item.itemName"}, null, null));

            // v4 -> BindingResult 객체의 rejectValue(필드명, 에러 코드) 사용
            // new FieldError 에서 타겟과 객체에 대한 정보를 없앤 것이다
            errors.rejectValue("itemName", "required");
        }

        // 가격 검증(천원 ~ 백만원)
        if(item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            // v2 -> bindingResult.addError(new FieldError("item", "price", "가격은 1000원 ~ 1000000원 사이 입니다."));
            // v3 -> bindingResult.addError(new FieldError("item", "price", item.getPrice(), false, new String[]{"range.item.price"}, new Object[]{1000, 1000000}, null));
            // v4 -> 에러 코드에 인자가 있을 경우 rejectValue(필드명, 에러 코드, 메시지 인자(Object 배열), 기본 오류 메시지) 사용
            errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
        }

        // 수량 검증(최대 9999개)
        if(item.getQuantity() == null || item.getQuantity() > 9999) {
            // v2 -> bindingResult.addError(new FieldError("item", "quantity", "수량은 최대 9999개 입니다."));
            // v3 -> bindingResult.addError(new FieldError("item", "quantity", item.getQuantity(), false, new String[]{"max.item.quantity"}, new Object[]{9999}, null));
            errors.rejectValue("quantity", "max", new Object[]{9999}, null);
        }

        // 글로벌 검증(가격 * 수량의 값이 10000 이상)
        if(item.getPrice() != null && item.getQuantity() != null) {
            if(item.getPrice() * item.getQuantity() < 10000) {
                // 이 에러는 price 필드 에러인가, quantity 필드 에러인가..
                // 해당 에러는 필드에 대한 에러가 아니기 때문에 ObjectError 객체 사용
                // v2, v3 -> bindingResult.addError(new ObjectError("item", new String[]{"totalPriceMin"}, new Object[]{10000}, null));
                // v4 -> 필드 에러가 아닐 경우 reject(에러 코드, 메시지 인자, 기본 오류 메시지) 사용
                errors.reject("totalPriceMin", new Object[]{10000}, null);
            }
        }

    }
}
