/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: TaskWithLock3
 * Author:   license
 * Date:     18-12-23 上午10:21
 * Description: 读写分离的显示锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈读写分离的显示锁〉
 *
 * @author license
 * @create 18-12-23
 * @since 1.0.0
 */
public class TaskWithLock3 {
    // 可重入的读写锁
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    // 读锁
    private final Lock rl = rwl.readLock();

    // 写锁
    private final Lock wl = rwl.writeLock();

    // 多操作，可并发执行
    public void read() {
        try{
            rl.lock();
            Thread.sleep(1000);
            System.out.println("read-----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rl.unlock();
        }
    }

    // 写操作，同时只允许一个写操作
    public void write(Object obj) {
        try {
            wl.lock();
            Thread.sleep(1000);
            System.out.println("writing ----");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            wl.unlock();
        }
    }
}
