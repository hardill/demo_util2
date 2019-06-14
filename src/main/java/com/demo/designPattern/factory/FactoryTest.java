package com.demo.designPattern.factory;

/**
 * @program: demo_util
 * @description: test
 * @author: Mr.Huang
 * @create: 2019-03-05 17:19
 **/
public class FactoryTest {
  public static void main(String[] args) {
    //
  }

  private void test1(){
      CommBikeFactory commBikeFactory = new CommBikeFactory();
      Bike mBike = commBikeFactory.getBikeTybe("mBike");
      mBike.ride();
      Bike rBike = commBikeFactory.getBikeTybe("rBike");
      rBike.ride();
  }

    private void test2(){
        Produce produce=new AbsMBikeFactory();
        Bike bike = produce.produce();
        bike.ride();
    }
}
