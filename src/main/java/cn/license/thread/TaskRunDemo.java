/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: TaskRunDemo
 * Author:   license
 * Date:     18-12-22 下午7:38
 * Description: 任务执行
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈任务执行〉
 *
 * @author license
 * @create 18-12-22
 * @since 1.0.0
 */
public class TaskRunDemo {
    public static void runTasks(Class<? extends Runnable> clz) throws IllegalAccessException, InstantiationException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("***开始执行" + clz.getSimpleName() + "任务***");
        // 启动三个线程
        for (int i = 0; i < 3; i++) {
            executorService.submit(clz.newInstance());
        }
        // 等待足够长的时间，然后关闭执行器
        TimeUnit.SECONDS.sleep(10);
        System.out.println("----" + clz.getSimpleName() + "任务执行完毕-----");
        // 关闭执行器
        executorService.shutdown();
    }

    public static void main(String[] args) throws IllegalAccessException, InterruptedException, InstantiationException {
        // 运行显示锁任务
        runTasks(TaskWithLock.class);
        // 运行内部锁任务
        runTasks(TaskWithSync.class);
    }
}
