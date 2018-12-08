/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: Client
 * Author:   license
 * Date:     18-11-7 下午10:39
 * Description: 优选选择基本类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈优选选择基本类型〉
 *
 * @author license
 * @create 18-11-7
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        int i = 140;
        long l = (long)140;
        // 分别传递int类型和Integer类型
        client.f(l);
    }

//    public void f(long a) {
//        System.out.println("基本类型的方法被调用");
//    }

    public void f(Long a) {
        System.out.println("包装类型的方法被调用");
    }
}
