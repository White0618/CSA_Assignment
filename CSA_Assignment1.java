import java.util.Scanner;

public class CSA_Assignment1 {
    public static void main(String[] args) {
        System.out.println("1、 B 2、 B 3、 D 4、 B 5、 D");
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println("1.杨辉三角形");
            System.out.println("2.求位数并逆序输出");
            System.out.println("3.回文数判断");
            System.out.println("4.求所有水仙花数");
            System.out.println("5.最小值和最大值之和");
            System.out.println("请输入您的选择：");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("请输入想要打印的等腰三角型的行数：");
                    int n = sc.nextInt();
                    showTriangle(n);
                    break;
                case 2:
                    System.out.println("请输入一个正整数：");
                    sc.nextLine();
                    String s = sc.nextLine();
                    reverseSUM(s);
                    break;
                case 3:
                    System.out.println("请输入一个整数：");
                    int num = sc.nextInt();
                    isPalindrome(num);
                    break;
                case 4:
                    ShuiXianHua();
                    break;
                case 5:
                    arraysDemo();
                    break;
                default:
                    System.out.println("没有这个选项！");
            }
        }
    }

    public static void showTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < 1 + 2 * i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void reverseSUM(String s) {
        int j = 0;
        char[] chars = s.toCharArray();
        char[] temp = new char[chars.length];
        System.out.println("您输入的正整数的位数是：" + chars.length);
        for (int i = chars.length - 1; i >= 0; i--, j++) {
            temp[j] = chars[i];
        }
        s = String.valueOf(temp);
        System.out.println("您输入的正整数的逆序是：" + s);
    }

    public static void reverseSum(int num) {
        String s="";
        s+=num;
        System.out.println(s.length());
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println("您输入的正整数的逆序是：" + sb);
    }

    public static void isPalindrome(int num) {
        int n = 0, x = num;
        while (x != 0) {
            int ge = x % 10;
            n = n * 10 + ge;
            x /= 10;
        }
        if (n == num) System.out.println("是的");
        else System.out.println("不是");
    }

    public static void ShuiXianHua() {
        for (int i = 100; i <= 999; i++) {
            int num = (int) Math.pow(i % 10, 3) + (int) Math.pow((i / 10) % 10, 3) + (int) Math.pow((i / 100) % 10, 3);
            if (num == i)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void arraysDemo() {
        int[] num = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10个整数：");
        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        int max = num[0], min = num[0];
        for (int i = 1; i < 10; i++) {
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }
        System.out.println(max + min);
    }
}