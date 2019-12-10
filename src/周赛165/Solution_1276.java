package 周赛165;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Solution_1276 {
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> num = new ArrayList<>();
        if (tomatoSlices > cheeseSlices*4 || tomatoSlices < cheeseSlices *2) return num;
        int total_jumbo = 0;
        int total_small = 0;
        for (total_small = cheeseSlices; total_small>=0; total_small--, total_jumbo++) {
            if (total_small*2 + total_jumbo*4 == tomatoSlices) break;
        }
        if (total_small*2 + total_jumbo*4 != tomatoSlices) return num;
        num.add(total_jumbo);
        num.add(total_small);
        return num;
    }

    public static void main(String[] args) {
        int tomatoSlices = 6;
        int cheeseSlices = 7;
        System.out.println(numOfBurgers(tomatoSlices, cheeseSlices));

    }
}
