package 周赛163;

import java.util.ArrayList;
import java.util.List;

public class Solution_1260 {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> glist = new ArrayList<>();
        List<Integer> num_list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                num_list.add(grid[i][j]);
            }
        }

        List<Integer> temp = new ArrayList<>(num_list);
        for (int i = 0; i < num_list.size(); i++) {
            k %= num_list.size();
            num_list.set(i, temp.get((i-k+num_list.size()) % num_list.size()));
        }
        System.out.println(num_list);
        for (int i = 0; i < grid.length; i++) {
            List<Integer> glist2 = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                glist2.add(num_list.get(grid[0].length*i+j));
//                System.out.print(num_list.get(3*i+j));
            }
//            System.out.println(" ");
            glist.add(glist2);
        }
        return glist;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int k = 1;
        int[][] grid = {{1,}, {2,}, {3,}, {4,}};
        int k = 23;
        List<List<Integer>> lists = shiftGrid(grid, k);
        System.out.println(lists);


    }

}
