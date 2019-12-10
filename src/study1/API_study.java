package study1;

import java.util.Scanner;

public class API_study {
//    包路径、构造方法、方法摘要
    /*
    Scanner类的功能：可以实现键盘输入数据到程序当中
    引用类型的一般使用步骤：
    1.导包 import 包路径.类名称
    如果需要使用的目标类，和当前类位于同一个包下，则可以省略导包语句
    只有java.lang包下的内容不需要导包
    2.创建 类名称 对象名 = new 类名称(参数);
    3.使用 对象名.成员方法名(参数)

    匿名对象
    new 类名称();
    只能使用唯一的一次，下次再用不得不再创建一个新对象
    new Person().name = "xiao";
    new Person().showName();
     */
    public static void main(String[] args) {
//        System.in从键盘输入
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        num = Math.max(num, sc.nextInt());
//        num = Math.max(num, sc.nextInt());
//        System.out.println("num = " + num);
//        int num = new Scanner(System.in).nextInt();
//        System.out.println("num = " + num);
        methodParam(new Scanner(System.in));
    }
    public static void methodParam(Scanner sc) {
        int num = sc.nextInt();
        System.out.println("num = " + num);
    }
}
