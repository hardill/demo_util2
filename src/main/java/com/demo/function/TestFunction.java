package com.demo.function;

import com.demo.service.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2020-08-14 11:13
 **/
@Component
public class TestFunction {
    @Autowired
    private TestInterface testInterface;
    private Map<String, Function<String, String>> checkResultDispatcherComX  = new HashMap<>();

    @PostConstruct
    public void checkResultDispatcherComXInit() {
        checkResultDispatcherComX.put("key_1", key -> testInterface.doByOne(key));
        checkResultDispatcherComX.put("key_2", key -> testInterface.doByTwo(key));
        checkResultDispatcherComX.put("key_3", key -> testInterface.doByThree(key));
    }

    public String getCheckResultComX(String key) {
        //写一段生成key的逻辑：
        String ley = getKey(key);

        Function<String, String> result = checkResultDispatcherComX.get(ley);
        if (result != null) {
            //执行这段表达式获得String类型的结果
            return result.apply(key);
        }
        return "不在处理的逻辑中返回业务错误";
    }

    private String getKey(String key) {
        return "key_"+key;
    }
}
