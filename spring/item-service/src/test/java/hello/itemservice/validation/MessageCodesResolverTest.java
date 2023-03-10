package hello.itemservice.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    // reject(), rejectValue()가 내부에서 MessageCodesResolver를 호출
    // 검증 오류 코드로 메시지 코드를 생성
    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodeResolverObject() {
        // 객체 오류. MessageCodesResolver가 생성하는 객체 오류 메시지 코드는 두가지
        // 에러코드 + 객체명, 에러코드
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        // 필드 오류. MessageCodesResolver가 생성하는 객체 오류 메시지 코드는 네가지
        // 에러코드+객체명+필드명, 에러코드+객체명, 에러코드+필드타입, 에러코드
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        assertThat(messageCodes).containsExactly("required.item.itemName", "required.itemName", "required.java.lang.String", "required");
    }
}
