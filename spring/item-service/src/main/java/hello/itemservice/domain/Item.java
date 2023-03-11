package hello.itemservice.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
// 객체의 특정 필드로 오류 검증및 오류 메시지를 설정할 수 있는 어노테이션
// 큰 프로젝트에서 디비 접근, 여러 객체에서 값을 가져와 검증을 할 수 있기 때문에 비추천
// 따라서 필드는 어노테이션으로, 객체는 자바 코드로 검증하는 것을 추천
//@ScriptAssert(lang="javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000원이 넘지 않습니다.")
public class Item {
    // Bean Validation의 한계
    // 같은 필드로 다른 검증을 하면 충돌이 생길수 있다.
    // ex) 수정할 때 id가 필수값이라서 @NotNull 어노테이션을 붙이면 등록할 때 id를 입력하지 않아 등록이 불가
    @NotNull
    private long id;
    @NotBlank
    private String itemName;
    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;
    @NotNull
//    @Max(9999)
    private Integer quantity;

    private Boolean open; // 판매 여부
    private List<String> regions; // 등록 지역
    private ItemType itemtype; // 상품 종류
    private String deliveryCode; // 배송 방식

    public Item() {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
