package 随机一题_leetcode;

import java.util.Stack;

public class LeetCode1190 {
    private static int[] parent;
    public  static String reverseParentheses(String s) {
        parent = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                int f = stack.pop();
                parent[i] = f;
                parent[f] = i;
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        reverse(s, 0, s.length()-1, false, sb);
        return sb.toString();
    }

    public static void reverse(String s, int start, int end, boolean reversed, StringBuilder sb) {
        if (reversed) {
            for (int i = end; i >= start; i--) {
                if (s.charAt(i) == ')') {
                    reverse(s, parent[i]+1, i-1, true, sb);
                    i = parent[i];
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else {
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '(') {
                    reverse(s, i + 1, parent[i] - 1, true, sb);
                    i = parent[i];
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
    }

    /**
     * 利用堆栈的思想，把除了 )之外的字符串放入堆中
     * 遇到 )就把 (之前的全部弹出来，然后再从弹出来的字符串的0开始往stack里面放
     * 最后所有全部放入stack，从0开始remove就可以得到最终结果
     * @param s
     * @return
     */
    public  static String reverseParentheses2(String s) {
        int num = 0;
        char r = '-';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                num++;
                r = s.charAt(i);
            }
        }
        if (num == 0) return "";
        if (num == 1) return String.valueOf(r);
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            char temp = s.charAt(i);
            if (temp == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                for (int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            } else stack.push(temp);
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.remove(0));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "(abcd)";
//        s = "";
//        s = "(u(love)i)";
//        s = "(ed(et(oc))el)";
//        s = "a(bcdefghijkl(mno)p)q";
//        s = "abc";
//        s = "(())";
//        s = "co(de(fight)s)";
//        "cosfighted"
        System.out.println(reverseParentheses(s));
    }
}
