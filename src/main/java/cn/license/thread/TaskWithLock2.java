/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: TaskWithLock2
 * Author:   license
 * Date:     18-12-23 上午10:16
 * Description: 显示锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈显示锁〉
 *
 * @author license
 * @create 18-12-23
 * @since 1.0.0
 */
public class TaskWithLock2 {

    public static void main(String[] args) {
        // 多个线程共享锁
        final Lock lock = new ReentrantLock();
        // 启动三个线程
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        // 休眠2秒钟
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

            }).start();
        }
    }
}
