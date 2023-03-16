package hello.itemservice.web.basic.form;

import hello.itemservice.domain.ItemType;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ItemSaveForm {
    @NotBlank
    private String itemName;
    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;
    @NotNull
    @Max(9999)
    private Integer quantity;
    private Boolean open; // 판매 여부
    private List<String> regions; // 등록 지역
    private ItemType itemtype; // 상품 종류
    private String deliveryCode; // 배송 방식
}
