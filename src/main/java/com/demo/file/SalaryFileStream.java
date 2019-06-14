package com.demo.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: demo_util
 * @description: 输入输出流
 * @author: Mr.Huang
 * @create: 2019-02-18 16:00
 */
public class SalaryFileStream {

  private static char[] chars = {
    'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
    'z', 'x', 'c', 'v', 'b', 'n', 'm'
  };

  private static String comma = ",";
  private static volatile int count = 10000000;
  private static ExecutorService pool = Executors.newCachedThreadPool();

  public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    BufferedWriter bw = new BufferedWriter(new FileWriter("C:/salary.txt"));

    for (int i = 0; i < 15; i++) {
      pool.submit(
          new Runnable() {
            @Override
            public void run() {
              while (true){
                count--;
                if (count > 0) {
                  try {
                      bw.write(getData());
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                }else {
                  break;
                }
              }

            }
          });
    }

    while (true) {
      if (count == 0) {
        break;
      }
    }

    bw.flush();
    pool.shutdown();
    boolean shutdown = pool.isShutdown();
    if(shutdown){
      bw.close();
    }

    System.out.println("输出执行完毕,时间:==>"+(System.currentTimeMillis()-start));
  }

  public static String getData() {
    Random random = new Random();
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      int index = random.nextInt(26);
      buf.append(chars[index]);
    }
    buf.append(comma).append(getSalary()).append(comma).append(getBonus()).append("\n");
    return buf.toString();
  }

  public static int getSalary() {
    Random random = new Random();
    return random.nextInt(100)+1;
  }

  public static int getBonus() {
    Random random = new Random();
    return random.nextInt(5)+1;
  }
}
