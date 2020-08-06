package com.test.lock;

import com.distributed.limit.redis.AccessSpeedLimit;
import com.distributed.limit.redis.LimitRule;
import com.distributed.lock.redis.RedisDistributedLockTemplate;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessSpeedLimitTest {
    /**
     * 基于Redis实现的分布式速率限制器
     *
     * 限制的资源,可以是ip,用户id,订单id,手机号,等等.
     *
     * 例如限制一个手机号每分钟只能发1条短信.
     * 例如限制一个手机号每10秒钟只能发起1次表单提交请求.
     * 例如限制一个ip地址每秒钟只能访问10次特定的资源.
     * */
    @Test
    public void test1() throws InterruptedException {
        JedisPool jp=new JedisPool("127.0.0.1",6379);
        AccessSpeedLimit accessSpeedLimit=new AccessSpeedLimit(jp);
        SimpleDateFormat sdf=new SimpleDateFormat(" mm:ss");
        while(true){
            //10.0.0.1这个ip每1秒钟最多访问5次if块内代码
            if(accessSpeedLimit.tryAccess("10.0.0.1", 1,5)){
                System.out.println("yes"+sdf.format(new Date()));
            }else{
                System.out.println("no"+sdf.format(new Date()));
            }
            Thread.sleep(100);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        JedisPool jp=new JedisPool("127.0.0.1",6379);
        final RedisDistributedLockTemplate template=new RedisDistributedLockTemplate(jp);
        LimitRule limitRule=new LimitRule();
        limitRule.setSeconds(1);
        limitRule.setLimitCount(5);
        limitRule.setLockCount(7);
        limitRule.setLockTime(2);
        AccessSpeedLimit accessSpeedLimit=new AccessSpeedLimit(jp);
        SimpleDateFormat sdf=new SimpleDateFormat(" mm:ss");
        while(true){
            //10.0.0.1这个ip每1秒钟最多访问5次if块内代码.1秒超过10次后,锁定2秒,2秒内无法访问.
            if(accessSpeedLimit.tryAccess("10.0.0.1",limitRule)){
                System.out.println("yes"+sdf.format(new Date()));
            }else{
                System.out.println("no"+sdf.format(new Date()));
            }
            Thread.sleep(100);
        }
    }
}