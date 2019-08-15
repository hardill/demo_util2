package com.test.stream;

import com.demo.bean.Person;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: demo_util
 * @description: 测试
 * @author: Mr.Huang
 * @create: 2019-04-16 15:40
 **/
public class TestStream {

    private List<Person> buildList() {
        Person a = new Person("A", 18);
        Person b = new Person("B", 22);
        Person c = new Person("C", 30);
        Person d = new Person("D", 15);
        Person e = new Person("E", 13);
        return Arrays.asList(a, b, c, d, e);
    }

    @Test
    public void sort(){
        List<Person> list = buildList();
        List<Person> collect = list.stream().filter(person -> 20 < person.getAge()).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testTry(){
        int i = tryTest();
        System.out.println(i);
    }

    private int tryTest() {
        int i =0;
        try {
            i=1;
            int i2=1/0;
            return i;
        }catch (Exception e){
            i=2;
            return i;
        }finally {
            i=3;
        }
    }
}
