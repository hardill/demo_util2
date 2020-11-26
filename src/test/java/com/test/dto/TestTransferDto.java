package com.test.dto;

import com.demo.bean.Address;
import com.demo.bean.Course;
import com.demo.bean.Student;
import com.demo.bean.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo_util
 * @description: DTO测试类
 * @author: Mr.Huang
 * @create: 2019-07-03 10:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestTransferDto {

    @Autowired
    @Qualifier("myDozerMapper")
    private Mapper dozerMapper;

    private Student buildStudent(){
        Address address = new Address("上海市","上海","嘉定区","德园路");
        Course course = new Course("001",1,"数学","Lily");
        Course course2 = new Course("002",2,"语文","贝贝");
        List<Course> list = new ArrayList<>();
        list.add(course);
        list.add(course2);
        return new Student(1l, "Lucy", 18, "18965432145",address,list,"2019-07-03");
    }

    @Test
    public void test1(){
        Student lucy = buildStudent();
        long s = System.currentTimeMillis();
        int i=0;
        while (i<100){
            i++;
            StudentDTO dto = dozerMapper.map(lucy, StudentDTO.class);
            System.err.println("执行次数:"+i);
        }

        System.err.println(System.currentTimeMillis()-s);
        //System.err.println(dto);
    }




}
