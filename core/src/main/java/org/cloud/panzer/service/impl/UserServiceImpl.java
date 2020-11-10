package org.cloud.panzer.service.impl;

import org.cloud.panzer.base.BaseServiceImpl;
import org.cloud.panzer.domain.SysUser;
import org.cloud.panzer.dto.LoginUser;
import org.cloud.panzer.dto.UserDto;
import org.cloud.panzer.mapper.UserMapper;
import org.cloud.panzer.service.TokenService;
import org.cloud.panzer.service.UserService;
import org.cloud.panzer.utils.EncryptPasswordUtils;
import org.cloud.panzer.utils.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, SysUser> implements UserService {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private TokenService tokenService;

    @Override
    @Transactional
    public SysUser saveUser(UserDto userDto) {
        SysUser user = userDto;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(SysUser.Status.VALID);
        userMapper.save(user);
        saveUserRoles(user.getId(), userDto.getRoleIds());

        log.debug("新增用户{}", user.getUsername());
        return user;
    }

    private void saveUserRoles(Long userId, List<Long> roleIds) {
        if (roleIds != null) {
            userMapper.deleteUserRole(userId);
            if (!CollectionUtils.isEmpty(roleIds)) {
                userMapper.saveUserRoles(userId, roleIds);
            }
        }
    }

    @Override
    public SysUser getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        SysUser u = userMapper.getUser(username);
        if (u == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        if (!passwordEncoder.matches(oldPassword, u.getPassword())) {
            throw new IllegalArgumentException("旧密码错误");
        }

        userMapper.changePassword(u.getId(), passwordEncoder.encode(newPassword));

        log.debug("修改{}的密码", username);
    }

    @Override
    @Transactional
    public SysUser updateUser(UserDto userDto) {
        userMapper.update(userDto);
        saveUserRoles(userDto.getId(), userDto.getRoleIds());

        return userDto;
    }

    @Override
    public SysUser findUserInfoByUsername(String username) {
        return userMapper.selectUserInfoByUsername(username);
    }

    @Override
    public void forceLogout(String sessionId) {
        LoginUser currentUser = UserUtil.getLoginUser();
        if (!currentUser.getToken().equals(sessionId)) {
            tokenService.deleteUUIDToken(sessionId);
        }
    }

    @Override
    public void updateUserInfoByPrimaryKey(SysUser user) {
        userMapper.updateUserInfoByPrimaryKey(user);

    }

    @Override
    public boolean updatePasswordByUserId(Long id, String password0, String password1) {
        SysUser u = userMapper.selectByPrimaryKey(id);
        if (u == null)
            return false;
        boolean passMatch = EncryptPasswordUtils.passwordsMatch(password0, u.getPassword());
        if (!passMatch) {
            return false;
        }
        String encryptPassword = EncryptPasswordUtils.encrypt(password1);
        userMapper.updatePasswordByUserId(id, encryptPassword);
        return true;
    }

    @Override
    public boolean enableUserByID(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean disableUserByID(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public SysUser findUserInfo() {
        LoginUser user = UserUtil.getLoginUser();
        return userMapper.selectUserInfoByUsername(user.getUsername());
    }

}
