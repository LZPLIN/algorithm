// hash表法 求两数之和:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4,5,6};
        System.out.println(twoSum_2(ints,10));
    }

    // 暴力破解法 求两数之和
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // hash表法 求两数之和
    public static int[] twoSum_2(int[] nums,int target){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(n-1);

        for (int i=0;i<n;i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
