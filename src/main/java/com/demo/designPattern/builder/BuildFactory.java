package com.demo.designPattern.builder;

import com.demo.designPattern.factory.MBike;
import com.demo.designPattern.factory.RBike;

/**
 * @program: demo_util
 * @description: build factory
 * @author: Mr.Huang
 * @create: 2019-03-05 17:30
 */
public class BuildFactory implements Builder {

    @Override
    public MBike buildMBike() {
        return new MBike();
    }

    @Override
    public RBike buildRBike() {
        return new RBike();
    }
}
