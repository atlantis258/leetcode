package com.atlantis.matrix;

import java.util.Arrays;

// 189.旋转数组
// https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-100-liked
public class Rotate {

    // 方法一：使用额外的数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        Rotate rotate = new Rotate();
        rotate.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
