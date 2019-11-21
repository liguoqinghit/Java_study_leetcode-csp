package study1;

public class Student {
    String name;
    int age;
    public void study() {
        System.out.println("好好学习，天天向上");
    }
    public void eat() {
        System.out.println("学习饿了要吃饭");
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("s:" + s);
        System.out.println("姓名：" + s.name);
        System.out.println("年龄：" + s.age);
        System.out.println("1---------------");

        s.name = "实打实";
        s.age = 18;
        System.out.println("姓名：" + s.name);
        System.out.println("年龄：" + s.age);
        System.out.println("2---------------");

        s.eat();
        s.study();


    }
}
