/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: DeadThreadDemo
 * Author:   license
 * Date:     18-12-23 下午1:03
 * Description: 线程死锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈线程死锁〉
 *
 * @author license
 * @create 18-12-23
 * @since 1.0.0
 */
public class DeadThreadDemo {
    static class A {

        public synchronized void a1(B b) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "进入A.a1");
            try {
                // 休眠1秒， 仍然持有锁
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "试图访问B.b2()");
            b.b2();
        }

        public synchronized void a2() {
            System.out.println("进入a.a2()");
        }
    }


    // 资源B
    static class B {
        public synchronized void b1(A a) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "进入B.b1()");
            try {
                // 休眠1秒，仍然持有锁
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "试图访问A.a2()");
            a.a2();
        }

        public synchronized void b2() {
            System.out.println("进入B.b2()");
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();
        // 线程A
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.a1(b);
            }
        }, "线程A").start();
        // 线程B
        new Thread(new Runnable() {
            @Override
            public void run() {
                b.b1(a);
            }
        }, "线程B").start();
    }


}

