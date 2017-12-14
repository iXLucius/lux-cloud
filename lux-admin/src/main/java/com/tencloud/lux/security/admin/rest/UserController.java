package com.tencloud.lux.security.admin.rest;

import com.tencloud.lux.security.common.rest.BaseController;
import com.tencloud.lux.security.admin.biz.UserBiz;
import com.tencloud.lux.security.admin.entity.User;
import com.tencloud.lux.security.admin.rpc.service.PermissionService;
import com.tencloud.lux.security.admin.vo.FrontUser;
import com.tencloud.lux.security.admin.vo.MenuTree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserBiz,User> {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping(value = "/front/info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUserInfo(String token) throws Exception {
        FrontUser userInfo = permissionService.getUserInfo(token);
        if(userInfo==null) {
            return ResponseEntity.status(401).body(false);
        } else {
            return ResponseEntity.ok(userInfo);
        }
    }

    @RequestMapping(value = "/front/menus", method = RequestMethod.GET)
    public @ResponseBody
    List<MenuTree> getMenusByUsername(String token) throws Exception {
        return permissionService.getMenusByUsername(token);
    }
}
