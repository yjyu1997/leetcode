package array.hard.median_of_two_sorted_arrays;

import org.junit.Test;

/**
 * Solution2
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.04,2021</pre>
 */
public class Solution2 {

    /**
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     *
     * @param nums1 array 1
     * @param nums2 array 2
     * @return median
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            m = nums2.length;
            n = nums1.length;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int iMin = 0;
        int iMax = m;

        //start binary search to find nums1[i-1] <= nums2[j] & nums2[j-1] <= nums1[i]
        //i + j = m-i + n-j (if m+n is even)
        //i + j = m-i + n-j + 1 (if m+n is odd)
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;


            if(i > 0 && nums1[i-1] > nums2[j]){
                //i is too big
                iMax = i - 1;
            }

            else if(i < m && nums2[j-1] > nums1[i]){
                //i is too small
                iMin = i + 1;
            }

            else{
                int maxOfLeft;
                int minOfRight;

                if(i == 0){
                    maxOfLeft = nums2[j-1];
                }
                else if(j == 0){
                    maxOfLeft = nums1[i-1];
                }
                else{
                    maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if((m + n) % 2 == 1){
                    return maxOfLeft;
                }

                if(i == m){
                    minOfRight = nums2[j];
                }
                else if(j == n){
                    minOfRight = nums1[i];
                }
                else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (minOfRight + maxOfLeft) / 2.0;

            }
        }

        return 0.0;
    }

    @Test
    public void test1(){
        int[] num1 = {};
        int[] num2 = {1};

        double median = findMedianSortedArrays(num1, num2);
        System.out.println(median);
    }
}
