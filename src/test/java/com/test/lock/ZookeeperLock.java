package com.test.lock;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2020-07-24 10:51
 **/
public class ZookeeperLock {
    public static void main(String[] args){
        /*RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("120.26.246.30:2181", retryPolicy);
        client.start();*/

        //final ZkDistributedLockTemplate template=new ZkDistributedLockTemplate(null);//本类多线程安全,可通过spring注入
        /*template.execute("订单流水号", 5000, new Callback() {//获取锁超时时间为5秒
            @Override
            public Object onGetLock() throws InterruptedException {
                //TODO 获得锁后要做的事
                System.out.println("-----获取锁-------");
                return null;
            }

            @Override
            public Object onTimeout() throws InterruptedException {
                //TODO 获得锁超时后要做的事
                System.out.println("获取锁超时-----------");
                return null;
            }
        });*/
    }
}
