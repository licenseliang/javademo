/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: Client3
 * Author:   license
 * Date:     18-11-7 下午10:59
 * Description: 接口中的实现代码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

/**
 * 〈一句话功能简述〉<br>
 * 〈接口中的实现代码〉
 * 注意：虽然可以这样做，但是不应该这样做
 *
 * @author license
 * @create 18-11-7
 * @since 1.0.0
 */
public class Client3 {

    public static void main(String[] args) {
        // 调用接口的实现
        B.s.doSomething();
    }

    // 在接口中存在实现代码
    interface B {
        public static final S s = new S() {
            public void doSomething() {
                System.out.println("在接口中实现");
            }
        };
    }

    // 被实现的接口
    interface S {
        public void doSomething();
    }
}
