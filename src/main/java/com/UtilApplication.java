package com;

import com.demo.bean.TestParam;
import com.demo.word.WordEvaluation;
import com.thebeastshop.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.BeanParam;
import java.util.List;

@SpringBootApplication
@RestController
@ForestScan(basePackages ="com.demo.forest")
public class UtilApplication {

  public static void main(String[] args) {
    SpringApplication.run(UtilApplication.class, args);
  }

  @GetMapping("seg")
  public void segString(String test) {
	  long l = System.currentTimeMillis();
	  List<String> result = WordEvaluation.segByWord(test);
	  System.out.println(result+"/n 耗时:=====>"+(System.currentTimeMillis()-l));
  }

    @GetMapping("test2")
    public void test2(@BeanParam TestParam test) {
        System.out.println(test.toString());
    }


}
