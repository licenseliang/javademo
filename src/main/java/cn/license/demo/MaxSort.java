/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: MaxSort
 * Author:   license
 * Date:     18-12-5 下午10:49
 * Description: 最大值
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * 〈一句话功能简述〉<br>
 * 〈最大值〉
 *
 * @author license
 * @create 18-12-5
 * @since 1.0.0
 */
public class MaxSort {

    public static void main(String[] args) {
        findMax();

        findMaxByClone();

        getSecondMax();
    }

    private static void findMax() {
        int[] nums = new int[50000];
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            nums[i] = random.nextInt(50000);
        }
        int max = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i ++ ) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("method1=======>>>>>max=" + max +
                ",cost=" + (end - start));

    }

    private static void getSecondMax() {
        Integer[] nums = new Integer[50000];
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            nums[i] = random.nextInt(50000);
        }

        List<Integer> list = Arrays.asList(nums);

        TreeSet<Integer> ts = new TreeSet<Integer>(list);

        System.out.println("======>>>>" + ts.lower(ts.last()));
    }

    private static void findMaxByClone() {
        int[] nums = new int[50000];
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            nums[i] = random.nextInt(50000);
        }
        int max = 0;
        long start = System.currentTimeMillis();
        Arrays.sort(nums.clone());
        max = nums[nums.length - 1];
        long end = System.currentTimeMillis();
        System.out.println("method2=======>>>>>max=" + max +
                ",cost=" + (end - start));
    }
}
