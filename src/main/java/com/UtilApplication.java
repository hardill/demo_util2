package com;

import com.demo.word.WordEvaluation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
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


}
