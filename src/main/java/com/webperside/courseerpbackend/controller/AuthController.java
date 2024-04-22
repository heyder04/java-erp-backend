package com.webperside.courseerpbackend.controller;

import com.webperside.courseerpbackend.models.base.BaseResponse;
import com.webperside.courseerpbackend.models.mybatis.user.User;
import com.webperside.courseerpbackend.models.response.auth.LoginResponse;
import com.webperside.courseerpbackend.services.security.AccessTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    public final AccessTokenManager accessTokenManager;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(){
        User user=User.builder().email("haydarmuxtar26").build();
        user.setId(1L);
        return BaseResponse.success(LoginResponse.builder()
                .accessToken(accessTokenManager.generate(user))
                .refreshToken(accessTokenManager.generate(user))
                .build());

    }
}
