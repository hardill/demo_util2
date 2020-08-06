package com.demo.timingWheel;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2020-07-14 16:01
 **/
public class TestTimer implements TimerTask{

    final static Timer timer = new TimerWheel();
    public static void main(String[] args) {
        TimerTask timerTask = new TestTimer();
        for (int i = 0; i < 10; i++) {
            timer.newTimeout(timerTask, 5, TimeUnit.SECONDS, "" + i );
        }

    }

    @Override
    public void run(Timeout timeout, String argv) throws Exception {
        System.out.println("timeout, argv = " + argv );
    }
}
