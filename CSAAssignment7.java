package test1;

import java.util.HashMap;
import java.util.Random;

public class CSAAssignment7 {
    static Random random = new Random();

    public static void test() {
        System.out.println(task1("abbc", "dog cat cat fish"));
        System.out.println(task2(new int[]{1, 2, 2, 3, 0}));
        for (int i = 0; i < 5; i++) {
            int target = random.nextInt(15) - 3;
            System.out.println("target:" + target + "\tresult" + task3(new int[]
                    {0, 4, 5, 6, 8}, target));
        }
    }

    public static void main(String[] args) {
        test();
    }

    public static boolean task1(String pattern, String str) {
        HashMap<Character, String> hm = new HashMap<>();
        String[] ss = str.split(" ");
        if (pattern.length() != ss.length) return false;
        for (int i = 0; i < ss.length; i++) {
            if (!hm.containsKey(pattern.charAt(i))) {
                if (hm.containsValue(ss[i])) return false;
                hm.put(pattern.charAt(i), ss[i]);
            } else if (!ss[i].equals(hm.get(pattern.charAt(i)))) return false;
        }
        return true;
    }

    public static int task2(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        for (int i : nums) {
            if (!flag[i]) flag[i] = true;
            else return i;
        }
        return -1;
    }

    public static int task3(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m;
        while (l <= r) {
            m = (l + r) >> 1;
            if (nums[m] < target) l = m + 1;
            else r = m-1;
        }
        if(l>=nums.length) return -l;
        else if(target==nums[l]) return l;
        else return -l;
    }
}
