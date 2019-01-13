/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: HashMapDemo
 * Author:   license
 * Date:     18-12-11 下午11:05
 * Description: 减少hashmap的元素数量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈减少hashmap的元素数量〉
 *
 * @author license
 * @create 18-12-11
 * @since 1.0.0
 */
public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        final Runtime rt = Runtime.getRuntime();
        //jvm 终止前记录内存信息
        rt.addShutdownHook(new Thread() {
            @Override
            public void run() {
                StringBuffer sb = new StringBuffer();
                long heapMaxSize = rt.maxMemory() >> 20;
                sb.append("最大可用内存：" + heapMaxSize + "M\n");
                long total = rt.totalMemory() >> 20;
                sb.append("对内存大小：" + total + "M\n");
                long free = rt.freeMemory() >> 20;
                sb.append("空闲内存：" + free + "M");
                System.out.println(sb);
            }
        });

        // 放入近40万键值对
        for (int i = 0; i < 11393217; i++) {
            map.put("key" + i, "value" + i);
        }
    }
}
