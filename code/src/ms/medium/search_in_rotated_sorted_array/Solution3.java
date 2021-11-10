package ms.medium.search_in_rotated_sorted_array;

import org.junit.Test;

/**
 * Solution3
 * hint: Draw the Picture
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.10,2021</pre>
 */
public class Solution3 {

    public int search(int[] nums, int target) {
        int iMin = 0;
        int iMax = nums.length - 1;

        while(iMin <= iMax){
            int i = (iMin + iMax + 1) / 2;

            if(nums[i] == target){
                return i;
            }

            //if pivot is larger than the first element
            if(nums[i] > nums[0]){
                if(nums[0] <= target  && target < nums[i]){
                    iMax = i - 1;
                }

                else {
                    iMin = i + 1;
                }
            }
            else {
                if(target > nums[i] && target <=nums[nums.length - 1]){
                    iMin = i + 1;
                }

                else{
                    iMax = i - 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void test1(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] rotated = {4,5,6,7,0,1,2};
        int search = search(ints, 0);
        System.out.println(search);
    }
}
