package CASassignment3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("<-------第一题------->");
        UseCompute.useCom(new Add(), 3, 2);
        UseCompute.useCom(new Subtract(), 3, 2);
        UseCompute.useCom(new Multiply(), 3, 2);
        UseCompute.useCom(new Divide(), 3, 2);

        System.out.println("<-------第二题------->");
        System.out.println("请输入您的分数：");
        int score = sc.nextInt();
        if (score < 0 || score > 100) throw new ScoreOutOfBoundException(score + "不在0~100之间");
        else System.out.println("您的分数为：" + score);

        System.out.println("<-------第三题------->");
        System.out.println("请输入N的值：");
        int n = sc.nextInt();
        try {
            if (n < 0) throw new NOutOfBoundException("N的值应大于等于0！");
        } catch (NOutOfBoundException e) {
            e.printStackTrace();
        }
        while (n < 0) {
            System.out.println("请重新输入N的值：");
            n = sc.nextInt();
            try {
                if (n < 0) throw new NOutOfBoundException("N的值应大于等于0！");
            } catch (NOutOfBoundException e) {
                e.printStackTrace();
            }
        }
        int sum = 0;
        System.out.println("请输入N个数：");
        for (int i = 0; i < n; i++) sum += sc.nextInt();
        System.out.print("平均值为：");
        if (n == 0) System.out.println(0);
        else System.out.println(sum / n);

        System.out.println("<-------第四题------->");
        Employee e = new Employee("张三", "12345678910", new MyDate(2000, 1, 1)) {
            @Override
            public void earnings() {
                System.out.println(this.getName() + "正在工作");
            }
        };
        System.out.println(e);

        System.out.println("<-------第五题------->");
/*        System.out.println("请输入字符串S：");
        String s=sc.next();
        System.out.println("请输入单词字典的词数：");
        String[] words=new String[sc.nextInt()];
        for(int i=0;i<words.length;i++) words[i]=sc.next();*/
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word : words)
            if (hm.containsKey(word)) hm.put(word, hm.get(word) + 1);
            else hm.put(word, 1);
        int count = 0;
        Set<String> ss = hm.keySet();
        for (String str : ss) {
            int j = 0, k = 0;
            while (k < s.length() && j < str.length()) {
                //匹配
                while (k < s.length() && str.charAt(j) != s.charAt(k)) k++;
                //匹配成功，匹配下一个
                if (k < s.length() && str.charAt(j) == s.charAt(k)) {
                    j++;
                    k++;
                }
            }
            if (j == str.length()) count += hm.get(str);
        }
        return count;
    }

}

interface Compute {
    int computer(int n, int m);
}

class Add implements Compute {
    public Add() {
    }

    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}

class Subtract implements Compute {
    public Subtract() {
    }

    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}

class Multiply implements Compute {
    public Multiply() {
    }

    @Override
    public int computer(int n, int m) {
        return n * m;
    }
}

class Divide implements Compute {
    public Divide() {
    }

    @Override
    public int computer(int n, int m) {
        return n / m;
    }
}

class UseCompute {
    private UseCompute() {
    }

    public static void useCom(Compute com, int one, int two) {
        System.out.println(com.computer(one, two));
    }
}

class ScoreOutOfBoundException extends RuntimeException {
    public ScoreOutOfBoundException() {
    }

    public ScoreOutOfBoundException(String message) {
        super(message);
    }
}

class NOutOfBoundException extends RuntimeException {
    public NOutOfBoundException() {
    }

    public NOutOfBoundException(String message) {
        super(message);
    }
}

class MyDate {
    private int year;
    private int mouth;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "." + mouth + "." + day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

abstract class Employee {
    private String name;
    private String num;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, String num, MyDate birthday) {
        this.name = name;
        this.num = num;
        this.birthday = birthday;
    }

    public abstract void earnings();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", birthday='" + birthday.toString() + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}


