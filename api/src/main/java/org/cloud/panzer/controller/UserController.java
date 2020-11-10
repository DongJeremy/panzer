package org.cloud.panzer.controller;

import org.cloud.panzer.bean.ResultBean;
import org.cloud.panzer.domain.SysUser;
import org.cloud.panzer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/v2/list")
    public ResultBean<List<SysUser>> users() {
        List<SysUser> userList = userService.list();
        return new ResultBean<>(userList);
    }
}
