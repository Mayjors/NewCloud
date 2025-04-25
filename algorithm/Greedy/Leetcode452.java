package demo.eu.algorithm.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        System.out.println(Arrays.deepToString(points));
        int n = points.length;
        int cnt = 1;
        int end = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > end){
                cnt++;
                end = points[i][1];
            }
            else{
                end = Math.min(end, points[i][1]);
            }
        }
        return cnt;
    }
}
