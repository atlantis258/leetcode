package com.atlantis.doublePointers;

// 11.盛最多水的容器
// https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
public class MaxArea {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            // 如果height[i] < height[j]，则移动短板（向右移动i）
            // 如果height[i] >= height[j]，则移动短板（向左移动j）
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) :
            Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea.maxArea(height));
    }

//    public int maxAreaOverTime(int[] height) {
//        int max = -1;
//        for (int i = 0; i < height.length - 1; i++) {
//            int pre = height[i];
//            for (int j = i + 1; j < height.length; j++) {
//                int cur = height[j];
//                int length = j - i;
//                int width = Math.min(pre, cur);
//                int area = length * width;
//                max = Math.max(max, area);
//            }
//        }
//        return max;
//    }
}
