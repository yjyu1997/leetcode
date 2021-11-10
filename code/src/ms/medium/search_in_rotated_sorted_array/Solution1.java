package ms.medium.search_in_rotated_sorted_array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Solution1 <br/>
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">link</a>
 * Wrong Answer! Just A Try
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.10,2021</pre>
 */
public class Solution1 {
    public int search(int[] nums, int target) {

        int result = -1;
        int iMin = 0;
        int iMax = nums.length - 1;
        int pivot = -1;

        while (iMin <= iMax){
            int i = (iMin + iMax + 1) / 2;

            if(i < nums.length -1 && nums[i+1] < nums[i]){
                pivot = i+1;
            }

            if(i > 0 && nums[i-1] > nums[i]){
                pivot = i;
            }

            if(nums[i] > target){
                iMax = i - 1;
            }
            else if(nums[i] < target){
                iMin = i + 1;
            }
            else {
                return i;
            }
        }

        if(pivot != -1){
            if(iMin == 0){

                int search = search(Arrays.copyOfRange(nums, pivot, nums.length), target);
                result = search == -1 ? -1 : pivot + search;
            }
            else if(iMax == nums.length - 1){
                int search = pivot - search(Arrays.copyOf(nums,pivot),target);
                result = search == -1 ? -1 : pivot - search;
            }
        }

        return result;
    }

    @Test
    public void test1(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] rotated = {6, 7,1,2,3,4,5};
        int search = search(rotated, 6);
        System.out.println(search);
    }
}
