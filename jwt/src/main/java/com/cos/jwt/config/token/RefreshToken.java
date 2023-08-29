package com.cos.jwt.config.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "refreshToken", timeToLive = 60)
@Getter
@AllArgsConstructor
public class RefreshToken {

    @Id
    private String refreshToken;
    private String username;
}
