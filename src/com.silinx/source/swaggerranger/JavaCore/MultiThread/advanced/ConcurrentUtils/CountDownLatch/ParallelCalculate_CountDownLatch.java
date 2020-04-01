package com.silinx.source.swaggerranger.JavaCore.MultiThread.advanced.ConcurrentUtils.CountDownLatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/*******************************************************************************
 * @Copyright (C), 2018-2019,github:Swagger-Ranger 
 * @FileName: ParallelCalculate
 * @Author: liufei32@outlook.com
 * @Date: 2019/3/12 10:22
 * @Description: 不使用CountDownLatch的并行计数，将文本中每行的数字并行求和然后等每一行都得出结果后再汇总求和
 * @Aha-eureka:
 *******************************************************************************/

public class ParallelCalculate_CountDownLatch {

    //数组用来保存每一行的值
    private int[] nums;

    //构造函数初始化要求和的长度
    public ParallelCalculate_CountDownLatch( int line ) {
        nums = new int[line];
    }

    /**
     * 单独计算每一行的和
     * @param line
     * @param index
     */
    public void calc( String line, int index , CountDownLatch latch ) {
        //将每一行的数字切分出来
        String[] nus = line.split(",");

        int total = 0;
        for (String num : nus) {
            total += Integer.parseInt(num);
        }

        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + " 正在执行计算任务..." + line + "  结果为：" + total);

        latch.countDown();
    }


    public void sum() {
        System.out.println("线程汇总开始执行...");

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        System.out.println("最终结果为：" + total);
    }

    /**
     * 文件读取工具方法
     * @return
     */
    private static List<String> readFile() {
        return getList();
    }

    static List<String> getList() {
        List<String> contents = new ArrayList<>();
        String line = null;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/JavaCore/MultiThread/advanced/ThreadCorrespondence/CountDownLatch/data"));
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return contents;
    }


    public static void main( String[] args ) {
        List<String> contents = readFile();
        int lineCount = contents.size();

        ParallelCalculate_CountDownLatch pc = new ParallelCalculate_CountDownLatch(lineCount);

        //新建CountDownLatch，来统筹等待
        CountDownLatch latch = new CountDownLatch(lineCount);

        for (int i = 0; i < lineCount; i++) {
            final int j = i;
            new Thread(() -> pc.calc(contents.get(j), j, latch)).start();
        }

        System.out.println(Thread.activeCount());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pc.sum();

    }
}
