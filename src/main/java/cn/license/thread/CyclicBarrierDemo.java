/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: CycleBarrierDemo
 * Author:   license
 * Date:     18-12-23 下午6:29
 * Description: 多线程齐步走
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 〈一句话功能简述〉<br>
 * 〈多线程齐步走〉
 *
 * @author license
 * @create 18-12-23
 * @since 1.0.0
 */
public class CyclicBarrierDemo {
    static class Worker implements Runnable {
        // 关卡
        private CyclicBarrier cb;

        public Worker(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "到达汇合点");
                // 到达汇合点
                cb.await();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        // 设置汇聚数量，以及汇聚完成后的任务
        CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("隧道已经打通！");
            }
        });
        // 人工1挖隧道
        new Thread(new Worker(cb), "工人1").start();
        // 工人2挖隧道
        new Thread(new Worker(cb), "工人2").start();
    }
}
