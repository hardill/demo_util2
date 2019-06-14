package com.demo.designPattern.builder;

import com.demo.designPattern.factory.MBike;
import com.demo.designPattern.factory.RBike;

public interface Builder {
    MBike buildMBike();
    RBike buildRBike();
}
