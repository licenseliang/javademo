/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: Client2
 * Author:   license
 * Date:     18-11-7 下午10:50
 * Description: 随机
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈随机〉
 *
 * @author license
 * @create 18-11-7
 * @since 1.0.0
 */
public class Client2 {

    public static void main(String[] args) {
        // 如非必要，不要设置随机数种子
        Random r = new Random(1000);
        for (int i = 1; i < 4; i++) {
            System.out.println("times:" + i + "," + r.nextInt());

        }
    }
}
