package com.demo.service.impl;

import com.demo.service.TestInterface;
import org.springframework.stereotype.Service;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2020-08-14 11:12
 **/
@Service
public class TestInterfaceImpl  implements TestInterface {
    @Override
    public String doByOne(String key) {
        return "do 1 --->>"+key;
    }

    @Override
    public String doByTwo(String key) {
        return "do 2--->>"+key;
    }

    @Override
    public String doByThree(String key) {
        return "do 3--->>"+key;
    }
}
