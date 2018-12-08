/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: Client4
 * Author:   license
 * Date:     18-11-8 下午8:41
 * Description: 构造代码块会放在构造函数前面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

/**
 * 〈一句话功能简述〉<br>
 * 〈构造代码块会放在构造函数前面〉
 *
 * @author license
 * @create 18-11-8
 * @since 1.0.0
 */
public class Client4 {

    public static void main(String[] args) {
        new Base();
        new Base("");
        new Base(0);
        System.out.println("实力对象数量:" + Base.getNumOfObjects());
    }
}

class Base {
    private static int numOfObjects = 0;

    {
        numOfObjects++;
    }

    public Base() {
    }

    public Base(String str) {
    }

    public Base(int i) {
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }
}
