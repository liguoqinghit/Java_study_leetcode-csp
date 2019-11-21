package 周赛162;

import java.util.ArrayList;
import java.util.List;

public class Solution_1253 {
    public static List<List<Integer>> reconstructMatrix(int upper,int lower, int[] colsum) {
        int sum = 0;
        int upper2 = upper;
        int lower2 = lower;
        int num = 0;
        for (int i : colsum) {
            if (i == 2) {
                upper--;
                lower--;
                num++;
            }
            sum += i;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (upper2+lower2 != sum | num > upper2 | num > lower2) {
            return list;
        }
        List<Integer> upperlist = new ArrayList<>();
        List<Integer> lowerlist = new ArrayList<>();
        for (int i=0; i<colsum.length; i++) {
            if (colsum[i] == 2) {
                upperlist.add(1);
                lowerlist.add(1);
                continue;
            }
            if (upper > 0 & colsum[i] > 0) {
                upper--;
                colsum[i]--;
                upperlist.add(1);
            } else {
                upperlist.add(0);
            }
            if (lower > 0 & colsum[i] > 0) {
                lower--;
                lowerlist.add(1);
            } else {
                lowerlist.add(0);
            }
        }
        list.add(upperlist);
        list.add(lowerlist);
        return list;

    }

    public static void main(String[] args) {
        int upper = 2, lower = 1;
        int[] colsum = {1, 1, 1};
//        int upper = 9, lower = 2;
//        int[] colsum = {0,1,2,0,0,0,0,0,2,1,2,1,2};
        System.out.println(reconstructMatrix(upper, lower, colsum));

    }
}

/*
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>();
        List<Integer> loweList = new ArrayList<>();
        if (colsum == null || colsum.length == 0) return res;
        int sum = 0;
        for (int num : colsum) {
            sum += num;
        }

        if (upper + lower != sum) return res;
        for (int num : colsum) {
            if (num == 2) {
                upperList.add(1);
                loweList.add(1);
                upper--;
                lower--;
            } else if (num == 1) {
                if (upper > lower) {
                    upperList.add(1);
                    loweList.add(0);
                    upper--;
                } else {
                    upperList.add(0);
                    loweList.add(1);
                    lower--;
                }
            } else {
                upperList.add(0);
                loweList.add(0);
            }
            if (upper < 0 || lower < 0) {
                return res;
            }
        }
        res.add(upperList);
        res.add(loweList);
        return res;

    }
 */