package com.jdk.code;/**
 * Created by Administrator on 2018/12/3.
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: demo_util
 * @description: 源码查看
 * @author: Mr.Huang
 * @create: 2018-12-03 10:35
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class CodeTest {

    @Test
    public void concurrentHashMap() throws Exception {
        Map<String, Object> map = new ConcurrentHashMap<>();
        log.info("map初始化,size:{}",map.size());

    }

    @Test
    public void hashMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("key1",1);
        log.info("map初始化,size:{}",map.size());

    }

}
