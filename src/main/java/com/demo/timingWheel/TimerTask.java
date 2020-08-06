package com.demo.timingWheel;

public interface TimerTask {
    void run(Timeout timeout, String argv) throws Exception;
}