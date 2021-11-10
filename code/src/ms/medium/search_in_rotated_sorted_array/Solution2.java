package ms.medium.search_in_rotated_sorted_array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Solution2<br/>
 * 先找pivot 再左右分治
 *
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.10,2021</pre>
 */
public class Solution2 {

    public int search(int[] nums, int target) {
        int iMin = 0;
        int iMax = nums.length - 1;
        int pivot = -1;

        while (iMin <= iMax){
            int i = (iMin + iMax + 1) / 2;

            if(i < nums.length -1 && nums[i+1] < nums[i]){
                pivot = i+1;
                break;
            }

            else if(i > 0 && nums[i-1] > nums[i]){
                pivot = i;
                break;
            }

            else if(nums[i] > nums[iMin]){
                iMin = i + 1;
            }

            else {
                iMax = i - 1;
            }

        }

        if(pivot != -1){
            if(target > nums[0]){
                return subSearch(Arrays.copyOf(nums,pivot),target);
            }
            else if(target < nums[0]){

                int i = subSearch(Arrays.copyOfRange(nums, pivot, nums.length), target);
                return i == -1 ? i : pivot + i;
            }
            else {
                return 0;
            }
        }
        return subSearch(nums,target);
    }


    public int subSearch(int[] subArray, int target){
        int iMin = 0;
        int iMax = subArray.length - 1;

        while (iMin <= iMax) {
            int i = (iMin + iMax + 1) / 2;

            if (subArray[i] > target) {
                iMax = i - 1;
            } else if (subArray[i] < target) {
                iMin = i + 1;
            } else {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test1(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] rotated = {4,5,6,7,0,1,2};
        int search = search(rotated, 3);
        System.out.println(search);
    }
}
