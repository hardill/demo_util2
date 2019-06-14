package com.demo.designPattern.factory;

/**
 * @program: demo_util
 * @description: 抽象工厂
 * @author: Mr.Huang
 * @create: 2019-03-05 17:17
 */
public class AbsRBikeFactory implements Produce {
  @Override
  public Bike produce() {
    return new RBike();
  }
}
