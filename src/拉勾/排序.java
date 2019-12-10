package 拉勾;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class 排序 {
    /**
     * 交换数据
     * @param nums 数据数组
     * @param j
     * @param i
     */
    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    /**
     * 冒泡排序 Bubble Sort
     * 稳定的算法
     * 空间复杂度 O(1)
     * 直接在给定的数组里进行元素的两两交换
     * 时间复杂度 O(n^2)
     * @param nums
     */
    public static void sort1(int[] nums) {
        boolean hasChange = true;
        for (int i = 0; i < nums.length-1 && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                    hasChange = true;
                }
            }
        }
    }

    /**
     * 插入排序 Insertion Sort leetcode 147题
     * 稳定的算法
     * 空间复杂度 O(1)
     * 直接在给定的数组里进行元素的两两交换
     * 时间复杂度 O(n^2)
     *
     * @param nums
     */
    public static void sort2(int[] nums) {
        for (int i = 1, j, current; i < nums.length; i++) {
            current = nums[i];
            for (j = i - 1; j >= 0 && nums[j] > current; j--) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = current;
        }
    }

    /**
     * 归并排序 Merge Sort
     * 稳定的算法
     * 时间复杂度T(n)
     * T(n) = 2 * T(n/2) + O(n)
     * O(nlogn)
     * 空间复杂度O(n)
     * @param nums
     * @param lo
     * @param hi
     */
    public static void sort3(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort3(nums, lo, mid);
        sort3(nums, mid+1, hi);
        merge(nums, lo, mid, hi);
    }
    public static void merge(int[] nums, int lo, int mid, int hi) {
        int[] copy = nums.clone();
        int k = lo, i = lo, j = mid + 1;
        while (k <= hi) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > hi) {
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else {
                nums[k++] = copy[i++];
            }
        }
    }

//    Quick Sort leetcode 215
    /**
     * 快速排序 Quick Sort
     * @param nums
     * @param lo
     * @param hi
     */
    public static void sort4(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(nums, lo, hi);
        sort4(nums, lo, p - 1);
        sort4(nums, p + 1, hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        Random ran = new Random();
        swap(nums, ran.nextInt(hi-lo+1)+lo, hi);
        int i, j;
        for (i = lo, j = lo; j < hi; j++) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, j);
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
        return i;
    }

//    Topological Sort
//    拓扑排序(进度安排)
//    必须有向图且图里没有环
//    入度为0的点输出，删除有向边
//    广度优先搜索bps
//    还没有完全实现
//    public static void sort5() {
////        Queue<Integer> q = new LinkedList<>();
////        for (int i = 0; i < V; i++) {
////            if (indegree[i] == 0) q.add(i);
////        }
////
////        while (!q.isEmpty()) {
////            int v = q.poll();
////            System.out.println(v);
////            for (int u = 0; u < adj[v].length; u++) {
////                if (--indegree[u] == 0) q.add(u);
////            }
////        }
////    }

//    Heap Sort
//    Bucket Sort

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
//        sort1(nums);
//        sort2(nums);
//        sort3(nums, 0, nums.length-1);
        sort4(nums, 0, nums.length-1);
    }
}
