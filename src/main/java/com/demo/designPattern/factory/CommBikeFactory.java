package com.demo.designPattern.factory;

import org.springframework.util.StringUtils;

/**
 * @program: demo_util
 * @description: 普通工厂
 * @author: Mr.Huang
 * @create: 2019-03-05 16:41
 */
public class CommBikeFactory {
  public Bike getBikeTybe(String type) {
    if (StringUtils.isEmpty(type)) {
      return null;
    }

    if (type.equalsIgnoreCase("mBike")) {
      return new MBike();
    } else if (type.equalsIgnoreCase("rBike")) {
      return new RBike();
    }

    return null;
  }
}
