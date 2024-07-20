package com.atlantis.substring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 239.滑动窗口最大值
// https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
public class MaxSlidingWindow {

    // todo 没完全理解
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) { // todo 没看明白这一行
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    // 自己写的，超时了
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] cur = new int[k];
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length + 1 - k; i++) {
            int pr = 0;
            for (int j = i; j < i + k; j++) {
                cur[pr++] = nums[j];
            }
            res[i] = Arrays.stream(cur).max().getAsInt();
        }
        return res;
    }
}
