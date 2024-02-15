package CSAassignment2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("<-------第一题------->");
        Book book = new Book("Java Programming", "John Smith", 2022);
        book.displayInfo();
        System.out.println();

        System.out.println("<-------第二题------->");
        Car car1 = new Car("宝马", "白", 200, 4, 3);
        Truck truck1 = new Truck("大运", "黑", 100, 6, 1, 3000);
        car1.start();
        car1.accelerate(60);
        car1.brake();
        truck1.start();
        truck1.accelerate(30);
        truck1.brake();
        Car car2 = new Car("奔驰", "黑", 200, 4, 6);
        Truck truck2 = new Truck("长安", "黑", 100, 6, 3, 5000);
        car2.start();
        car2.accelerate(60);
        car2.brake();
        truck2.start();
        truck2.accelerate(30);
        truck2.brake();

        System.out.println("<-------第三题------->");
        Calculator.add(2, 3);
        Calculator.subtract(4, 2);
        Calculator.multiply(2, 5);
        Calculator.divide(5, 2);
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入超大数1：");
        String a = sc.nextLine();
        System.out.println("请输入超大数2:");
        String b = sc.nextLine();
        System.out.println(getSum(a, b));

        System.out.println("<-------第四题------->");
        String[] s1 = {"flower", "flow", "flight"};
        String longestCommonPrefix = longestCommonPrefix(s1);
        System.out.printf("示例1最长公共前缀:%s\n\n", longestCommonPrefix);
        String[] s2 = {"dog", "racer", "car"};
        longestCommonPrefix = longestCommonPrefix(s2);
        System.out.printf("示例2最长公共前缀:%s\n\n", longestCommonPrefix);

        System.out.println("<-------第五题------->");
        System.out.println("请输入height数组的大小n=");
        int n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("请输入height数组：");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            if (height[i] < 0) {
                System.out.println("输入错误！！！");
                return;
            }
        }
        System.out.println(trap(height));

    }

    public static String getSum(String a, String b) {
        List<Integer> la = new ArrayList<>();
        List<Integer> lb = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int maxlength = Math.max(a.length(), b.length());
        for (int i = a.length() - 1; i >= 0; --i) la.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; --i) lb.add(b.charAt(i) - '0');
        for (int i = 0; i < maxlength; i++) {
            if (i < la.size()) temp += la.get(i);
            if (i < lb.size()) temp += lb.get(i);
            sb.append(temp % 10);
            temp /= 10;
        }
        if (temp == 1) sb.append(1);
        return sb.reverse().toString();
    }

    public static String longestCommonPrefix(String[] ss) {
        if (ss == null || ss.length == 0) return "";
        int minLength = ss[0].length();
        for (int i = 1; i < ss.length; i++)
            if (minLength > ss[i].length()) minLength = ss[i].length();
        int i;
        boolean flag = true;
        for (i = 0; flag && i < minLength; i++) {
            char c = ss[0].charAt(i);
            for (int j = 1; j < ss.length; j++)
                if (ss[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
        }
        if (!flag) return ss[0].substring(0, i - 1);
        else return ss[0].substring(0, i);
    }

    public static int trap(int[] h) {
        int count = 0;
        int l = findLeft(h, 0);
        int r = findRight(h, l);
        while (r != -1 && r < h.length)
            if (r == 0) r = findRight(h, ++l);
            else {
                int sum = 0;
                for (int i = l + 1; i < r; i++) sum += h[i];
                count += (r - l - 1) * Math.min(h[l], h[r]) - sum;
                l = findLeft(h, r);
                r = findRight(h, l);
            }
        return count;
    }

    public static int findLeft(int[] h, int l) {
        while (l < h.length - 2 && h[l] <= h[l + 1]) l++;
        return l;
    }

    public static int findRight(int[] h, int l) {
        for (int i = l + 2; i < h.length; i++) if (h[i] >= h[l]) return i;
        int temp = -1;
        for (int i = l + 2; i < h.length; i++) if (check(h, l + 1, i)) temp = i;
        if (temp != -1) return temp;
        for (int i = l + 1; i < h.length - 1; i++) if (h[i] < h[i + 1]) return 0;
        return -1;
    }

    public static boolean check(int[] h, int l, int r) {
        for (int i = l; i < r; i++) if (h[i] >= h[r]) return false;
        return true;
    }

    public static class Book {
        private String title;
        private String author;
        private int YearOfPublication;

        public Book() {
        }

        public Book(String title, String author, int yearOfPublication) {
            this.title = title;
            this.author = author;
            YearOfPublication = yearOfPublication;
        }


        public void displayInfo() {
            System.out.printf("Title:%s,Author:%s,Year:%d\n", title, author, YearOfPublication);
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYearOfPublication() {
            return YearOfPublication;
        }

        public void setYearOfPublication(int yearOfPublication) {
            YearOfPublication = yearOfPublication;
        }
    }

    public abstract static class Vehicle {
        private String brand;
        private String color;
        private int speed;
        private int wheels;

        public Vehicle() {
        }

        public Vehicle(String brand, String color, int speed, int wheels) {
            this.brand = brand;
            this.color = color;
            this.speed = speed;
            this.wheels = wheels;
        }

        public abstract void start();

        public abstract void accelerate(int speed);

        public abstract void brake();

        public abstract void information();

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getWheels() {
            return wheels;
        }

        public void setWheels(int wheels) {
            this.wheels = wheels;
        }
    }

    public static class Car extends Vehicle {
        private int loader;

        public Car() {
        }

        public Car(String brand, String color, int speed, int wheels, int loader) {
            super(brand, color, speed, wheels);
            this.loader = loader;
        }

        @Override
        public void start() {
            System.out.println(getBrand() + " is started");
            information();
        }

        @Override
        public void accelerate(int speed) {
            System.out.println(getBrand() + " is accelerating at speed " + speed + " km/h");
            information();
        }

        @Override
        public void brake() {
            System.out.println(getBrand() + " is braking");
            information();
        }

        @Override
        public void information() {
            System.out.println("车轮的个数是：" + super.getWheels());
            System.out.printf("这是一辆小车，能载6人，实载%d人", this.loader);
            if (loader >= 6) System.out.print("，你超员了！！！");
            System.out.print("\n\n");
        }
    }

    public static class Truck extends Vehicle {
        private int loader;
        private int payload;

        public Truck() {
        }

        public Truck(String brand, String color, int speed, int wheels, int loader, int payload) {
            super(brand, color, speed, wheels);
            this.loader = loader;
            this.payload = payload;
        }

        @Override
        public void start() {
            System.out.println(getBrand() + " is started");
            information();
        }

        @Override
        public void accelerate(int speed) {
            System.out.println(getBrand() + " is accelerating at speed " + speed + " km/h");
            information();
        }

        @Override
        public void brake() {
            System.out.println(getBrand() + " is braking");
            information();
        }

        @Override
        public void information() {
            System.out.println("车轮的个数是：" + super.getWheels());
            System.out.printf("这是一辆卡车，能载3人，实载%d人", this.loader);
            if (loader >= 3) System.out.print("，你超员了！！！");
            System.out.println();
            System.out.printf("这是一辆卡车，核载5000kg，你已装载%dkg", this.payload);
            if (payload > 5000) System.out.print("，你超载了！！！");
            System.out.print("\n\n");
        }
    }

    public static class Calculator {
        public static double add(double a, double b) {
            System.out.println("Addition:" + (a + b));
            return a + b;
        }

        public static double subtract(double a, double b) {
            System.out.println("Subtraction:" + (a - b));
            return a - b;
        }

        public static double multiply(double a, double b) {
            System.out.println("Multiplication:" + (a * b));
            return a * b;
        }

        public static double divide(double a, double b) {
            if (b == 0) {
                System.out.println("Input error!!!");
                return 0;
            }
            System.out.println("Division:" + (a / b));
            return a / b;
        }

        public static BigDecimal addBig(String a, String b) {
            BigDecimal b1 = new BigDecimal(a);
            BigDecimal b2 = new BigDecimal(b);
            System.out.println("BigAddition:" + b1.add(b2));
            return b1.add(b2);
        }

        public static BigDecimal subtractBig(String a, String b) {
            BigDecimal b1 = new BigDecimal(a);
            BigDecimal b2 = new BigDecimal(b);
            System.out.println("BigSubtraction:" + b1.subtract(b2));
            return b1.subtract(b2);
        }

        public static BigDecimal multiplyBig(String a, String b) {
            BigDecimal b1 = new BigDecimal(a);
            BigDecimal b2 = new BigDecimal(b);
            System.out.println("BigSubtraction:" + b1.multiply(b2));
            return b1.subtract(b2);
        }

        public static BigDecimal divideBig(String a, String b) {
            if (b.equals("0")) {
                System.out.println("Input error!!!");
                return new BigDecimal(0);
            }
            BigDecimal b1 = new BigDecimal(a);
            BigDecimal b2 = new BigDecimal(b);
            System.out.println("BigDivision:" + b1.divide(b2, RoundingMode.HALF_UP));
            return b1.divide(b2, RoundingMode.HALF_UP);
        }
    }

}
