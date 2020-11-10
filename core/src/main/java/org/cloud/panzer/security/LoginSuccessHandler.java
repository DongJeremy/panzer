package org.cloud.panzer.security;

import org.cloud.panzer.domain.Token;
import org.cloud.panzer.dto.LoginUser;
import org.cloud.panzer.service.TokenService;
import org.cloud.panzer.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private TokenService tokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        Token token = tokenService.saveToken(loginUser);
        ResponseUtil.responseJson(response, HttpStatus.OK.value(), token);
    }
}
