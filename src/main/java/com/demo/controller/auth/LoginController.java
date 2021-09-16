package com.demo.controller.auth;/**
 * Created by Administrator on 2018/12/21.
 */

import cn.dev33.satoken.stp.StpUtil;
import com.demo.base.BaseController;
import com.demo.base.Result;
import com.demo.bean.User;
import com.demo.dao.TxDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo_util
 * @description: 权限
 * @author: Mr.Huang
 * @create: 2020-12-21 11:49
 **/
@RestController("/auth")
@Slf4j
public class LoginController extends BaseController {
    @Autowired
    private TxDao txDao;


    @GetMapping("/login")
    public Result login() {
        User user = new User();
        StpUtil.setLoginId(user.getId());
        return successResult(Result.MSG_SUCCESS, user);
    }

    @GetMapping("/logout")
    public Result logout() {
        StpUtil.logout();
        return successResult(Result.MSG_SUCCESS, null);
    }

    @GetMapping("/testLogin")
    public Result testLogin() {
        StpUtil.checkLogin();
        return successResult(Result.MSG_SUCCESS, "");
    }







}
