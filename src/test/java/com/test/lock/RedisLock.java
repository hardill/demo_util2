package com.test.lock;

import com.distributed.lock.Callback;
import com.distributed.lock.redis.RedisDistributedLockTemplate;
import com.distributed.lock.redis.RedisReentrantLock;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * @program: demo_util
 * @description:
 * @author: Mr.Huang
 * @create: 2020-07-24 10:51
 **/
public class RedisLock {
    public static void main(String[] args){

        JedisPool jedisPool=new JedisPool(new GenericObjectPoolConfig(),"47.94.45.117",6379,60000,"remuszpj");
        //实际应用时可通过spring注入
        final RedisDistributedLockTemplate template=new RedisDistributedLockTemplate(jedisPool);//本类线程安全,可通过spring注入
        template.execute("lock_order_test", 5000, new Callback() {//获取锁超时时间为5秒
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
        });
    }

    public static void testLock() throws Exception {
        JedisPool jedisPool=new JedisPool(new GenericObjectPoolConfig(),"47.94.45.117",6379,60000,"remuszpj");
        //实际应用时可通过spring注入
        RedisReentrantLock lock=new RedisReentrantLock(jedisPool,"订单流水号");
        try {
            if (lock.tryLock(5000L, TimeUnit.MILLISECONDS)) {//获取锁超时时间为5秒
                //TODO 获得锁后要做的事
            }else{
                //TODO 获得锁超时后要做的事
            }
        }finally {
            lock.unlock();
        }
    }
}
