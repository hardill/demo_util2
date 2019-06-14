package com.demo.controller;/**
 * Created by Administrator on 2018/12/21.
 */

import com.demo.base.BaseController;
import com.demo.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo_util
 * @description: 测试
 * @author: Mr.Huangmvn install -Dmaven.test.skip=true
 * @create: 2018-12-21 11:49
 **/
@RestController
public class TestController extends BaseController {

    @GetMapping("hi")
    public Result testHi(){
        return successResult(Result.MSG_SUCCESS,"hello");
    }
}
