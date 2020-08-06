package com.demo.controller;/**
 * Created by Administrator on 2018/12/21.
 */

import com.demo.base.BaseController;
import com.demo.base.Result;
import com.demo.bean.ValidParam;
import com.demo.forest.MyClient;
import com.demo.mq.HelloSender;
import com.demo.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo_util
 * @description: 测试
 * @author: Mr.Huangmvn install -Dmaven.test.skip=true
 * @create: 2018-12-21 11:49
 **/
@RestController
@Slf4j
public class TestController extends BaseController {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private MyClient myClient;

    @GetMapping("hi")
    public Result testHi(){
        return successResult(Result.MSG_SUCCESS,"hello");
    }

    @GetMapping("/mq/test")
    public Result testMq(){
        helloSender.send();
        return successResult(Result.MSG_SUCCESS,null);
    }

    @GetMapping("hello2")
    public Result testForest() {
        String s = myClient.simpleRequest();
        Result result = JsonUtils.decode(s, Result.class);
        return successResult(Result.MSG_SUCCESS,result.getData());
    }

    @PostMapping("check")
    public Result testCheck(@RequestBody @Validated  ValidParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("参数异常:{}",bindingResult.getFieldError().getDefaultMessage());
            throw new RuntimeException("参数异常:"+bindingResult.getFieldError().getDefaultMessage());
        }

        return successResult(Result.MSG_SUCCESS,"check success");
    }


}
