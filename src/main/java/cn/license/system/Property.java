/**
 * Copyright (C), 2017-2019, 珠海联创工场技术有限公司
 * FileName: Property
 * Author:   license
 * Date:     19-1-8 下午2:16
 * Description: java属性
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.system;

import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 * 〈java属性〉
 *
 * @author license
 * @create 19-1-8
 * @since 1.0.0
 */
public class Property {
    public static void main(String[] args) throws InterruptedException {
        Properties props = System.getProperties();
        props.list(System.out);
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(1000);
            props.setProperty("for" + i, String.valueOf(i));
        }
    }
}
