package com.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
public class DemoUtilApplicationTests {

  public static void main(String[] args) {
	  //
	  int length = "中a国".length();
      System.out.println(length);
  }

	@Test
	public void contextLoads() {
		log.info("hello boot");
	}

}
