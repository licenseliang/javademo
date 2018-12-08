/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: EqualsOverride
 * Author:   license
 * Date:     18-12-2 上午10:02
 * Description: 覆写equals
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈覆写equals〉
 *
 * @author license
 * @create 18-12-2
 * @since 1.0.0
 */
public class EqualsOverride {
    public static void main(String[] args) {
        // Person 类的实例作为Map的key
        Map<Person, Object> map = new HashMap<Person, Object>() {
            {
                put(new Person("张三"), new Object());
            }
        };

        // Person 类的实例作为List 的元素
        List<Person> list = new ArrayList<Person>() {
            {
                add(new Person("张三"));
            }
        };

        // 列表中是否包含
        boolean b1 = list.contains(new Person("张三"));
        // Map 中是否包含
        boolean b2 = map.containsKey(new Person("张三"));

        System.out.println("b1====" + b1 + "\nb2============" + b2);
    }

    static class Person implements Serializable {

        private String name;

        private String sex;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public boolean equals(Object obj) {
            // 这里使用getClass
            // 不要使用 instanceof, 考虑到继承，继承不是同一个类
            if (obj != null && obj.getClass() == this.getClass()) {
                Person p = (Person) obj;
                if (p.getName() == null || name == null) {
                    return false;
                } else {
                    return name.equalsIgnoreCase(p.getName());
                }
            }
            return false;
        }

        /**
         * 覆写equals,一定要覆写hashcode
         * 否则hashmap不会相等
         * @return
         */
        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(name).toHashCode();
        }
    }
}
