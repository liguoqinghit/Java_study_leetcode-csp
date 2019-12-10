package CSP_201403;

import java.util.Scanner;

public class csp_03 {
    public static class Arg {
        boolean hasPar;  // 是否有参数
        boolean isAppear;  // 是否存在
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Arg用来标注 rule中出现的字母以及是否有参数
        Arg[] argues = new Arg[26];
        for (int i = 0; i < argues.length; i++) {
            argues[i] = new Arg();
        }

        char[] rule = sc.nextLine().toCharArray();
        for (int i = 0; i < rule.length; i++) {
            if (rule[i] == ':') {
                argues[rule[i - 1] - 'a'].hasPar = true;
            } else {
                argues[rule[i] - 'a'].isAppear = true;
            }
        }

        int n = Integer.parseInt(sc.nextLine());
        StringBuilder[] result = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            result[i] = new StringBuilder("Case " + (i+1) + ": ");
            boolean[] isAppear = new boolean[26];
            String[] parameter = new String[26];
            String[] in = sc.nextLine().split(" ");
            for (int j = 1; j < in.length; j++) {
                if (((in[j].length() != 2 || in[j].charAt(0) != '-')
                        || (in[j].charAt(1) - 'a' < 0 || in[j].charAt(1) - 'a' > 25))
                        || (!argues[in[j].charAt(1) - 'a'].isAppear)) {
                    break;
                }
                char c = in[j].charAt(1);
                if (argues[c - 'a'].hasPar && j < in.length-1) {
                    isAppear[c - 'a'] = true;
                    parameter[c - 'a'] = in[j + 1];
                    j++;
                } else {
                    isAppear[c - 'a'] = true;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (isAppear[j]) {
                    char temp = (char)('a' + j);
                    result[i].append("-" + temp + " ");
                    if (argues[j].hasPar) {
                        result[i].append(parameter[j] + " ");
                    }
                }
            }

        }
        sc.close();
        for (int i = 0; i < n; i++) {
            System.out.println(result[i].toString().trim());
        }
    }
}

/*
样例输入
albw:x
4
ls -a -l -a documents -b
ls
ls -w 10 -x -w 15
ls -a -b -c -d -e -l

样例输出
Case 1: -a -l
Case 2:
Case 3: -w 15 -x
Case 4: -a -b
 */
