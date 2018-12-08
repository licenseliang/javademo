/**
 * Copyright (C), 2017-2018, 珠海联创工场技术有限公司
 * FileName: ArraySort
 * Author:   license
 * Date:     18-11-8 下午8:16
 * Description: 排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.license.demo;

/**
 * 〈一句话功能简述〉<br>
 * 〈排序〉
 *
 * @author license
 * @create 18-11-8
 * @since 1.0.0
 */
public class ArraySort implements Runnable {
    private int num;

    public ArraySort(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        // 把这个数组升序排序输出
        int[] nums = {11, 3, 998, 5455, 1, 352, 990};
//        for (int i = 0; i < nums.length; i ++ ) {
//            new Thread(new ArraySort(nums[i])).start();
//        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void run() {
        try {
            Thread.sleep(num);
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
