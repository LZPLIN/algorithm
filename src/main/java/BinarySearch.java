import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分法查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(binarySearch(nums,2));
    }

    public static int binarySearch(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
