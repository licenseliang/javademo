/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: StringDemo
 * Author:   license
 * Date:     18-12-3 上午9:34
 * Description: 字符串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

/**
 * 〈一句话功能简述〉<br>
 * 〈字符串〉
 * 1、String 不能修改值，只会另外创建一个
 * 2、StringBuffer 线程安全
 * 3、StringBuilder 非线程安全，但速度最快
 *
 * @author license
 * @create 18-12-3
 * @since 1.0.0
 */
public class StringDemo {

    public static void main(String[] args) {
        stringAdd();
        stringBuffer();
        stringBuilder();
    }

    /**
     * stringbuilder 相加
     */
    private static void stringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50000; i ++) {
            sb.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("str======" + sb.toString());
        System.out.println("cost time=========" + (end - start));
    }

    /**
     * stringbuffer 相加
     */
    private static void stringBuffer() {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 50000; i ++) {
            sb.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("str ==========" + sb.toString());
        System.out.println("cost time =========" + (end - start));

    }


    /**
     * String 相加
     */
    private static void stringAdd() {
        long start = System.currentTimeMillis();
        String str = "";

        for (int i = 0; i < 50000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("str=============" + str);
        System.out.println("cost time ===========" + (end - start));
    }
}
