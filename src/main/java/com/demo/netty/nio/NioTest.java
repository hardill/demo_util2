package com.demo.netty.nio;/**
 * Created by Administrator on 2018/12/21.
 */

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: demo_util
 * @description: Nio测试
 * @author: Mr.Huang
 * @create: 2018-12-21 15:27
 **/
@Slf4j
public class NioTest {

    static private final byte message[] = { 83, 111, 109, 101, 32,
            98, 121, 116, 101, 115, 46 };

    public static void main(String[] args) throws Exception {
        //readNio();
        writeNio();
    }


    public static void readNio() throws IOException {
        FileInputStream fin = new FileInputStream("E://data/test.txt");
        FileChannel channel = fin.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        channel.read(buf);
        buf.flip();

        while (buf.remaining()>0){
            byte b = buf.get();
            System.out.println((char)b);
        }

        fin.close();

    }

    public static void writeNio() throws IOException {
        FileOutputStream fin = new FileOutputStream("E://data/test2.txt");
        FileChannel channel = fin.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);

        for (int i=0; i<message.length; ++i) {
            buf.put( message[i] );
        }

        buf.flip();
        channel.write( buf );
        fin.close();

    }
}
