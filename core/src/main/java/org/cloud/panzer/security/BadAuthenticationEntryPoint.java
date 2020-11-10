package org.cloud.panzer.security;

import org.cloud.panzer.bean.ResponseBean;
import org.cloud.panzer.constant.Constants;
import org.cloud.panzer.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BadAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) {
        ResponseBean info = new ResponseBean(HttpStatus.UNAUTHORIZED.value(), Constants.UNAUTHORIZED_MESSAGE);
        ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), info);
    }

}
