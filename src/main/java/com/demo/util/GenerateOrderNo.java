package com.demo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by shining on 2018/9/15.
 */
public class GenerateOrderNo {

    /**
     * 生成销售订单号
     *
     * @return
     */
    public static String generateOrderNumber() {
        StringBuffer sb = new StringBuffer();
        // 固定格式
        sb.append("PPP");

        String currDateStr = getOrderNum();
        // 当前时间
        sb.append(currDateStr);

        // 生成三位随机数
        sb.append(gennerteRandomStr(3));
        return sb.toString();
    }

    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(date);
    }
    /**
     * 生成随机数
     *
     * 			需要生成多少位
     * @param count
     * @return
     */
    public static String gennerteRandomStr(int count){
        StringBuffer sb = new StringBuffer();

        Random rd = new Random();
        for (int i = 0; i < count; i++) {
            sb.append(rd.nextInt(10));
        }
        return sb.toString();
    }


}