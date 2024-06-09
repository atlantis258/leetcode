package com.atlantis;

import java.util.Arrays;

// 283. 移动零
// https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
public class Test4 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        //两个指针i和j（i指向非0，j指向0）
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp; // j指向最左的0
            }
        }

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        int[] nums = {0,1,0,3,12};
        test4.moveZeroes(nums);
    }

//    public void moveZeroesFailed(int[] nums) {
//        int index0 = 0;
//        int indexNot0 = 0;
//        if (nums.length == 0 || nums.length == 1) {
//            System.out.println(nums);
//        }
//
//        while (indexNot0 < nums.length - 1) {
//            while (nums[index0] != 0) {
//                index0++;
//            }
//            while (nums[indexNot0] == 0) {
//                indexNot0++;
//            }
//            int temp = nums[index0];
//            nums[index0] = nums[indexNot0];
//            nums[indexNot0] = temp;
//        }
//
//        Arrays.stream(nums).forEach(System.out::println);
//    }
}
