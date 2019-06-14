package com.demo.designPattern.command;

/**
 * 命令模式
 */
public class MyCommand implements Command {
  
    private Receiver receiver;  
      
    public MyCommand(Receiver receiver) {  
        this.receiver = receiver;  
    }  
  
    @Override  
    public void exe() {  
        receiver.action();  
    }  
}  