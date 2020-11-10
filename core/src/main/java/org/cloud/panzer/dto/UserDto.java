package org.cloud.panzer.dto;

import org.cloud.panzer.domain.SysUser;

import java.util.List;

public class UserDto extends SysUser {

    private List<Long> roleIds;

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

}
