package org.cloud.panzer.service;

import org.cloud.panzer.domain.Token;
import org.cloud.panzer.dto.LoginUser;

import java.util.Set;

public interface TokenService {

    Token saveToken(LoginUser loginUser);

    boolean deleteToken(String token);

    LoginUser getLoginUser(String token);

    void refresh(LoginUser loginUser);

    Set<String> getAllTokenList(String pattern);

    boolean deleteUUIDToken(String sessionId);
}
