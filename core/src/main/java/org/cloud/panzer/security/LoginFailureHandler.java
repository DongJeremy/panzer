package org.cloud.panzer.security;

import org.cloud.panzer.bean.ResponseBean;
import org.cloud.panzer.constant.Constants;
import org.cloud.panzer.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) {
        String msg;
        if (exception instanceof BadCredentialsException) {
            msg = Constants.BADCREDENTIALS_MESSAGE;
        } else {
            msg = exception.getMessage();
        }
        ResponseBean info = new ResponseBean(HttpStatus.UNAUTHORIZED.value(), msg);
        ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), info);
    }

}
