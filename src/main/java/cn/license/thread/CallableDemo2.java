/**
 * Copyright (C), 2017-2019, 珠海联创工场技术有限公司
 * FileName: CallableDemo2
 * Author:   license
 * Date:     19-1-11 上午10:25
 * Description: callabledemo2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈callabledemo2〉
 *
 * @author license
 * @create 19-1-11
 * @since 1.0.0
 */
public class CallableDemo2 implements Callable<Integer> {

    private CountDownLatch begin;

    private CountDownLatch end;

    public CallableDemo2(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int num = new Random().nextInt(100);
        System.out.println("begin await");
        begin.await();
        System.out.println("begin countdown");
        Thread.sleep(num);
        end.countDown();
        return num;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int beginNum = 1;
        int endNum = 10;
        CountDownLatch begin = new CountDownLatch(beginNum);
        CountDownLatch end = new CountDownLatch(endNum);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>(10);

        for (int i = 0; i < endNum; i++) {
            futures.add(executorService.submit(new CallableDemo2(begin, end)));
        }

        System.out.println("before begin countDown");
        begin.countDown();
        System.out.println("after begin countDown");
        end.await();
        executorService.shutdown();
        int total = 0;
        for (int i = 0; i < endNum; i++) {
            total += futures.get(i).get();
        }
        System.out.println("coverage======" + (total / endNum));

    }
}
