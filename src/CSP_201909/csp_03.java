package CSP_201909;

public class csp_03 {
    public static void main(String[] args) {
        System.out.println("\033[38;2;255;0;0m " +
                "Hello" +
                "\033[0m" +
                " " +
                "\033[38;2;0;0;255m" +
                "\033[48;2;255;255;255m " +
                "World ! " +
                "\033[0m\n" +
                " !");
    }
}

/*
1 1
1 1
#010203

01 02 03
\x1B\x5B\x34\x38\x3B\x32\x3B\x31\x3B\x32\x3B\x33\x6D\x20\x1B\x5B\x30\x6D\x0A
  33 133  64  68  73  62  73  61  73  62  73  63 155  40  33 133  60 155 12

【样例 2 输入】
2 2
1 2
#111111
#0
#000000
#111

\x1B\x5B\x34\x38\x3B\x32\x3B\x38\x3B\x38\x3B
\x38\x6D\x20\x20\x1B\x5B\x30\x6D\x0A
 */