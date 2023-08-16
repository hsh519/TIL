package study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String username;
    private int age;

    @QueryProjection // Querydsl에 의존적이라는 단점 존재
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
