package org.cloud.panzer.service;

import org.cloud.panzer.base.BaseService;
import org.cloud.panzer.domain.SysUser;
import org.cloud.panzer.dto.UserDto;

public interface UserService extends BaseService<SysUser> {

    SysUser saveUser(UserDto userDto);

    SysUser updateUser(UserDto userDto);

    SysUser getUser(String username);

    void changePassword(String username, String oldPassword, String newPassword);

    SysUser findUserInfoByUsername(String username);

    void forceLogout(String sessionId);

    void updateUserInfoByPrimaryKey(SysUser user);

    boolean updatePasswordByUserId(Long id, String original, String password);

    boolean enableUserByID(Long id);

    boolean disableUserByID(Long id);

    SysUser findUserInfo();
}
