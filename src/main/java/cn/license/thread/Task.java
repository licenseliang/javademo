/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: Task
 * Author:   license
 * Date:     18-12-22 下午7:29
 * Description: 任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

import java.util.Calendar;

/**
 * 〈一句话功能简述〉<br>
 * 〈任务〉
 *
 * @author license
 * @create 18-12-22
 * @since 1.0.0
 */
public class Task {

    public void doSomething() {
        try {
            // 每个线程等待2秒钟，注意将此时的线程转为WAITING状态
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();
        sb.append("线程名称：");
        sb.append(Thread.currentThread().getName());
        sb.append(",执行时间");
        sb.append(Calendar.getInstance().get(13)).append("s");
        System.out.println(sb);
    }
}
