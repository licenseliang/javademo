/**
 * Copyright (C), 2017-2019, 珠海联创工场技术有限公司
 * FileName: DealThreadDemo2
 * Author:   license
 * Date:     19-1-11 上午11:20
 * Description: 死锁2
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈死锁2〉
 *
 * @author license
 * @create 19-1-11
 * @since 1.0.0
 */
public class DealThreadDemo2 {
    static class ThreadA {
        public synchronized void a1(ThreadB b) {
            System.out.println("exec a1");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            b.b2();
        }

        public synchronized void a2() {
            System.out.println("exec a2");
        }
    }

    static class ThreadB {
        public synchronized void b1(ThreadA a) {
            System.out.println("exec b1");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            a.a2();
        }

        public synchronized void b2() {
            System.out.println("exec b2");
        }
    }

    public static void main(String[] args) {
        final ThreadA a = new ThreadA();
        final ThreadB b = new ThreadB();
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.a1(b);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                b.b1(a);
            }
        }).start();
    }
}
