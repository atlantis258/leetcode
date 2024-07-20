package com.atlantis.ordinaryArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 56.合并区间
// https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 按照左端点值升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0]; // 数组i的左端点值
            int R = intervals[i][1]; // 数组i的右端点值

            // 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) { // 比如 merged数组(0,3)，加入(10,11)
                merged.add(new int[]{L, R});
            } else {
                // 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
                // 比如 merged数组(0,3)，加入(0,2), (1,9)
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        Merge merge = new Merge();
        int[][] res = merge.merge(intervals);

        // 遍历二维数组并输出元素
        for (int i = 0; i < res.length; i++) { // 外层循环遍历行
            for (int j = 0; j < res[i].length; j++) { // 内层循环遍历列
                System.out.print(res[i][j] + " "); // 输出当前元素
            }
            System.out.println(); // 输出完一行后换行
        }
    }
}
