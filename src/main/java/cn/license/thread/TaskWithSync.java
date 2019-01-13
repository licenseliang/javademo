/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: TaskWithSync
 * Author:   license
 * Date:     18-12-22 下午7:37
 * Description: 内部锁
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈内部锁〉
 *
 * @author license
 * @create 18-12-22
 * @since 1.0.0
 */
public class TaskWithSync extends Task implements Runnable {

    @Override
    public void run() {
        // 内部锁
        synchronized ("A") {
            doSomething();
        }
    }
}
