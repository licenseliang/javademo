/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: TaskWithLock
 * Author:   license
 * Date:     18-12-22 下午7:34
 * Description: 显示锁任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈显示锁任务〉
 *
 * @author license
 * @create 18-12-22
 * @since 1.0.0
 */
public class TaskWithLock extends Task implements Runnable {

    // 声明显示锁
    // 这里的锁起不到互斥作用
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            //开始锁定
            lock.lock();
            doSomething();
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
}
