package com.demo.designPattern.builder;

import com.demo.designPattern.factory.MBike;
import com.demo.designPattern.factory.RBike;

/**
 * @program: demo_util
 * @description: test
 * @author: Mr.Huang
 * @create: 2019-03-05 17:32
 */
public class BuildTest {
  public static void main(String[] args) {
    //
    BuildFactory buildFactory = new BuildFactory();
    MBike mBike = buildFactory.buildMBike();
    mBike.ride();
    RBike rBike = buildFactory.buildRBike();
    rBike.ride();
  }
}
