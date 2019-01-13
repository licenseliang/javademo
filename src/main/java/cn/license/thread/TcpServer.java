/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: TcpServer
 * Author:   license
 * Date:     18-12-22 下午5:22
 * Description: 线程异常处理器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程异常处理器〉
 *
 * @author license
 * @create 18-12-22
 * @since 1.0.0
 */
public class TcpServer implements Runnable {

    public static void main(String[] args) {
        new TcpServer();
    }

    public TcpServer() {
        // 创建后立即运行
        Thread t = new Thread(this);
        t.setUncaughtExceptionHandler(new TcpServerExceptionHandler());
        t.start();
    }

    @Override
    public void run() {
        // 正常业务运行，运行3秒
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("系统正常运行：" + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 抛出异常
        throw new RuntimeException();
    }

    // 异常处理器
    private class TcpServerExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            // 记录线程异常信息
            System.out.println("线程" + t.getName() + "出现异常，自行重启，请分析原因。");
            e.printStackTrace();
            // 重启线程，保证业务不中断
            new TcpServer();
        }
    }
}
