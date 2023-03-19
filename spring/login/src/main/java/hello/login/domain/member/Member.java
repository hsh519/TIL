package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {
    private Long id; // db

    @NotEmpty
    private String loginId; // 로그인 아이디
    @NotEmpty
    private String name; // 이름
    @NotEmpty
    private String password; // 패스워드
}
