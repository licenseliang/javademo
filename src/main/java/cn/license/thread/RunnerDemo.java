/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: Runner
 * Author:   license
 * Date:     18-12-23 下午5:08
 * Description: countDownLatch协调子线程
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
 * 〈countDownLatch协调子线程〉
 *
 * @author license
 * @create 18-12-23
 * @since 1.0.0
 */
public class RunnerDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 参加赛跑人数
        int num = 10;
        // 发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);
        // 参与跑步有几个
        CountDownLatch end = new CountDownLatch(num);
        // 每个参与跑步者一个跑道
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        // 记录比赛成绩
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

        // 跑步者就位，所有线程处于等待状态
        for (int i = 0; i < num; i++) {
            futures.add(executorService.submit(new Runner(begin, end)));
        }
        // 发令枪响， 跑步者开始跑步
        begin.countDown();
        // 等待所有跑步者跑完全程
        end.await();
        executorService.shutdown();
        int count = 0;
        // 统计总分
        for (Future<Integer> f : futures) {
            System.out.println(f.isDone());
            count += f.get();
        }
        System.out.println("count======" + count + ", num======" + num);
        System.out.println("平均分数为：" + count / num);
    }

    static class Runner implements Callable<Integer> {
        // 开始信号
        private CountDownLatch begin;
        // 结束信号
        private CountDownLatch end;

        public Runner(CountDownLatch begin, CountDownLatch end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            // 跑步的成绩
            int score = new Random().nextInt(25);
            begin.await();
            // 跑步中...
            TimeUnit.MILLISECONDS.sleep(score);
            // 跑步者已经跑完全程
            end.countDown();
            System.out.println(Thread.currentThread().getName() + "," + System.currentTimeMillis());
            return score;
        }
    }
}
