import java.util.Arrays;
import java.util.Random;

public class CSA_Assignment9 {
    static Random random = new Random();

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] nums1 = new int[random.nextInt(20) + 1];
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = random.nextInt(30) - 10;
        printArr(nums1);
        printArr(task1(nums1));
        System.out.println("======================");
        int[] nums2 = new int[random.nextInt(20) + 1];
        for (int i = 0; i < nums2.length; i++)
            nums2[i] = random.nextInt(3);
        printArr(nums2);
        task2(nums2);
        printArr(nums2);
    }

    public static int[] task1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int j=i+1;
            while(j<nums.length&&nums[j]<=nums[i]){j++;}
            if(j==nums.length){res[i]=0;}
            else{res[i]=j-i;}
        }
        return res;
    }

    public static void task2(int[] nums) {
        quickSort(0,nums.length-1,nums);
    }

    public static void printArr(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int l, int r,int[] nums) {
        if (l>=r) return;
        int i=l,j=r;
        while(i!=j){
            for(;i<j&&nums[l]<=nums[j];j--);
            for(;i<j&&nums[i]<=nums[l];i++);
            swap(nums,i,j);
        }
        swap(nums,l,i);
        quickSort(l,i-1,nums);
        quickSort(i+1,r,nums);
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
