/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: CallableDemo
 * Author:   license
 * Date:     18-12-22 下午5:54
 * Description: 异步运算
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈异步运算〉
 *
 * @author license
 * @create 18-12-22
 * @since 1.0.0
 */
public class CallableDemo implements Callable<Integer> {

    //本金
    private int seedMoney;

    public CallableDemo(int seedMoney) {
        this.seedMoney = seedMoney;
    }

    @Override
    public Integer call() throws Exception {
        // 复杂计算，运行一次需要10秒
        TimeUnit.MILLISECONDS.sleep(10 * 1000);
        return seedMoney / 10;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 生成一个单线程的异步执行器
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 线程执行后的预期值
        Future<Integer> future = executorService.submit(new CallableDemo(100));
        while (!future.isDone()) {
            // 还没有运算完成，等待200毫秒
            TimeUnit.MILLISECONDS.sleep(200);
            // 输出进度符号
            System.out.print("#");
        }
        System.out.println("\n计算完成，税金是：" + future.get() + " 元");
        executorService.shutdown();
    }
}
