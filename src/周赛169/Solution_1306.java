package 周赛169;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1306 {
//    bfs，广度优先搜索，基于queue
    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] time = new int[arr.length];
        queue.add(start);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp >= 0 && temp < arr.length) {
                if (arr[temp] == 0) return true;
                else {
                    queue.add(temp - arr[temp]);
                    queue.add(temp + arr[temp]);
                }
                time[temp]++;
                if (time[temp] > 50) break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {4,2,3,0,3,1,2};
//        int start = 5;
//        int[] arr = {4,2,3,0,3,1,2};
//        int start = 0;
        int[] arr = {3,0,2,1,2};
        int start = 2;
        System.out.println(canReach(arr, start));
    }
}
