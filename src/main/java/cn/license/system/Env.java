/**
 * Copyright (C), 2017-2019, 珠海联创工场技术有限公司
 * FileName: Env
 * Author:   license
 * Date:     19-1-8 下午2:12
 * Description: 系统变量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.system;

import java.util.Iterator;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈系统变量〉
 *
 * @author license
 * @create 19-1-8
 * @since 1.0.0
 */
public class Env {
    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + "=========" + map.get(key));
        }
    }
}
