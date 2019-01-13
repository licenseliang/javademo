/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: RandomDemo
 * Author:   license
 * Date:     18-12-9 下午1:17
 * Description: 乱序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈乱序〉
 *
 * @author license
 * @create 18-12-9
 * @since 1.0.0
 */
public class RandomDemo {
    public static void main(String[] args) {
        int tagCloudNum = 10;
        List<String> tagClouds = new ArrayList<String>(tagCloudNum);
        // 初始化标签云， 一般是从数据库读入，省略
        for (int i = 0; i < tagCloudNum; i++) {
            tagClouds.add(String.valueOf(i));
        }

        // 方法1
//        Random random = new Random();
//        for (int i = 0; i < tagCloudNum; i++) {
//            // 取得随机位置
//            int randomPosition = random.nextInt(tagCloudNum);
//            // 当前元素与随机元素交换
//            String temp = tagClouds.get(i);
//            tagClouds.set(i, tagClouds.get(randomPosition));
//            tagClouds.set(randomPosition, temp);
//        }


        // 方法2
        /*Random rand = new Random();
        for (int i = 0; i < tagCloudNum; i++) {
            // 取得随机位置
            int randomPosition = rand.nextInt(tagCloudNum);
            // 当前元素与随机元素交换
            Collections.swap(tagClouds, i, randomPosition);
        }*/

        // 方法3
        Collections.shuffle(tagClouds);
        System.out.println("=====>>>>" + JSON.toJSONString(tagClouds));
    }
}
