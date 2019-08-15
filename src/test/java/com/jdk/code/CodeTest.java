package com.jdk.code;/**
 * Created by Administrator on 2018/12/3.
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
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
    public void concurrentHashMap() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        log.info("map初始化,size:{}", map.size());

    }

    @Test
    public void hashMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", 1);
        log.info("map初始化,size:{}", map.size());

    }

    @Test
    public void testSpring() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object course = context.getBean("course");

    }

    @Test
    public void testSubList() {
        String[] ids = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List<String> list = Arrays.asList(ids);
        List<List<Object>> lists = splitResult(list, 3);
        lists.stream().forEach(System.err::println);

    }

    public static List<List<Object>> splitResult(List result, int count) {
        // 如果集合为空或者等分数小于1，则直接返回null
        if (result == null || result.size() < 1 || count < 1) {
            return null;
        }
        List<List<Object>> list = new ArrayList<>();
        if (result.size() <= count) {
            list.add(result);
            return list;
        }
        // 使用list的subList的方法进行分割
        // 获得等分个数
        int size = result.size() / count;
        // 等分之后，还剩余多少个
        int remain = result.size() % count;
        for (int i = 0; i < size; i++) {
            int from = i * count;
            int to = (i + 1) * count;
            list.add(result.subList(from, to));
        }
        // 如果有余数，则额外处理
        if (remain > 0) {
            list.add(result.subList((result.size() - remain), result.size()));
        }
        return list;
    }

}
