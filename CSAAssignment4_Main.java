import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSAAssignment4 {
    static List<List<Integer>> ll = new ArrayList<>();
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<-------第一题------->");
        System.out.println("请输入x:");
        System.out.println(reverse(sc.nextInt()));

        System.out.println("<-------第二题------->");
        System.out.println("请输入n:");
        System.out.println(climbStairs(sc.nextInt()));

        System.out.println("<-------第三题------->");
        System.out.println("请输入nums的大小：");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入nums数组：");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        subsets(nums);
        System.out.println(ll);
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n > Integer.MAX_VALUE || n < Integer.MIN_VALUE ? 0 : (int) n;
    }

    public static int climbStairs(int n) {
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            int temp = q + p;
            p = q;
            q = temp;
        }
        return q;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < 1 << n; i++) {
            l.clear();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0)
                    l.add(nums[j]);
            }
            ll.add(new ArrayList<>(l));
        }
        return ll;
    }
}
