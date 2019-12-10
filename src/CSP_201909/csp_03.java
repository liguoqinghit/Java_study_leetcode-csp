package CSP_201909;
import java.util.Scanner;
//参考网址
//https://blog.csdn.net/weixin_45655522/article/details/102170274
//https://blog.csdn.net/weixin_43074474/article/details/102243202
public class csp_03 {
    private static boolean is_alpha(char a) {
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
    }

    public static int hex_to_dec(char a, char b) {
        return (is_alpha(a) ? (10 + a - 'a') : (a - '0')) * 16 +
                (is_alpha(b) ? (10 + b - 'a') : (b - '0'));
    }

    public static void out_string(String a) {
        for (int i = 0; i < a.length(); i++) {
            out_char(a.charAt(i));
        }
    }

    public static void out_char(char a) {
        //        System.out.print("\\x" + Integer.toHexString(a1).toUpperCase());
        System.out.print(String.format("\\x%02X", (int) a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int p = sc.nextInt(), q = sc.nextInt();
        char[] pixel;
        int[][][] pixel_three = new int[n][m][3];
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                String pixel_in = sc.nextLine();
                pixel = pixel_in.toCharArray();
                if (pixel.length == 2) {
                    pixel_three[i][j][0] = hex_to_dec(pixel[1], pixel[1]);
                    pixel_three[i][j][1] = pixel_three[i][j][0];
                    pixel_three[i][j][2] = pixel_three[i][j][0];
                } else if (pixel.length == 3) {
                    pixel_three[i][j][0] = hex_to_dec(pixel[1], pixel[1]);
                    pixel_three[i][j][1] = hex_to_dec(pixel[1], pixel[2]);
                    pixel_three[i][j][2] = hex_to_dec(pixel[2], pixel[2]);
                } else if (pixel.length == 4) {
                    pixel_three[i][j][0] = hex_to_dec(pixel[1], pixel[1]);
                    pixel_three[i][j][1] = hex_to_dec(pixel[2], pixel[2]);
                    pixel_three[i][j][2] = hex_to_dec(pixel[3], pixel[3]);
                } else {
                    pixel_three[i][j][0] = hex_to_dec(pixel[1], pixel[2]);
                    pixel_three[i][j][1] = hex_to_dec(pixel[3], pixel[4]);
                    pixel_three[i][j][2] = hex_to_dec(pixel[5], pixel[6]);
                }
            }
        }
        int r=0, g=0, b=0, R=0, G=0, B=0;
        for (int i = 0; i < n / q; ++i) {
            for (int j = 0; j < m / p; ++j) {
                R = G = B = 0;
                for (int x = i * q; x < (i + 1) * q; ++x) {
                    for (int y = j * p; y < (j + 1) * p; ++y) {
                        R += pixel_three[x][y][0];
                        G += pixel_three[x][y][1];
                        B += pixel_three[x][y][2];
                    }
                }
                R /= p*q; G /= p*q; B /= p*q;
                if (!(R == r && G == g && B == b)) {
                    if (R == 0 && G == 0 && B ==0) {
                        System.out.print("\\x1B");
                        out_string("[0m");
                    } else {
                        System.out.print("\\x1B");
                        out_string("[48;2;" + R + ";" + G + ";" + B + "m");
                    }
                    r = R; g = G; b = B;
                }
                out_char(' ');
            }
            if (R != 0 || G != 0 || B != 0) {
                System.out.print("\\x1B");
                out_string("[0m");
            }
            r = g = b = 0;
            out_char('\n');
        }
    }

}

/*
\n  10  x0A
' ' 32  x20
[   91  x5B
m  109  x6D
;   59  x3B

【样例1 输入】
1 1
1 1
#010203

01 02 03

\x1B\x5B\x34\x38\x3B\x32\x3B\x31\x3B\x32\x3B\x33\x6D\x20\x1B\x5B\x30\x6D\x0A
转义之后：\033[48;2;1;2;3m'空格'\033[0m\n


【样例 2 输入】
2 2
1 2
#111111
#0
#000000
#111

\x1B\x5B\x34\x38\x3B\x32\x3B\x38\x3B\x38\x3B\x38\x6D\x20\x20\x1B\x5B\x30\x6D\x0A
\033[48;2;8;8;8m'空格''空格'\033[0m\n

2 2
1 2
#111111
#2
#4
#A

\x1B\x5B\x34\x38\x3B\x32\x3B\x34\x32\x3B\x34\x32\x3B\x34\x32\x6D\x20\x1B\x5B\x34\x38\x3B\x32\x3B\x31\x36\x3B\x31\x34\x34\x3B\x31\x33\x34\x6D\x20\x1B\x5B\x30\x6D\x0A
\x1B\x5B\x34\x38\x3B\x32\x3B\x32\x35\x3B\x32\x35\x3B\x32\x35\x6D\x20\x1B\x5B\x34\x38\x3B\x32\x3B\x2D\x31\x35\x33\x3B\x2D\x31\x35\x33\x3B\x2D\x31\x35\x33\x6D\x20\x1B\x5B\x30\x6D\x0A
\x1B\x5B\x34\x38\x3B\x32\x3B\x34\x32\x3B\x34\x32\x3B\x34\x32\x6D\x20\x1B\x5B\x34\x38\x3B\x32\x3B\x2D\x31\x37\x30\x3B\x2D\x31\x37\x30\x3B\x2D\x31\x37\x30\x6D\x20\x1B\x5B\x30\x6D\x0A
 */