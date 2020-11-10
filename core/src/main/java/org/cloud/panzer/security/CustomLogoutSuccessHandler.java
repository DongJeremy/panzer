package org.cloud.panzer.security;

import org.cloud.panzer.bean.ResponseBean;
import org.cloud.panzer.constant.Constants;
import org.cloud.panzer.security.filter.TokenFilter;
import org.cloud.panzer.service.TokenService;
import org.cloud.panzer.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Resource
    private TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        ResponseBean info = new ResponseBean(HttpStatus.OK.value(), Constants.LOGOUTSUCCESS_MESSAGE);

        String token = TokenFilter.getToken(request);
        tokenService.deleteToken(token);

        ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);

    }

}
