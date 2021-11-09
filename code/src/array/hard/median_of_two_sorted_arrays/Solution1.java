package array.hard.median_of_two_sorted_arrays;

import org.junit.Test;

/**
 * Solution
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.03,2021</pre>
 */
public class Solution1 {

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
        int l1 = nums1.length;
        int l2 = nums2.length;
        int medIndex;


        medIndex = (l1 + l2) / 2;


        Integer[] merged = new Integer[l1 + l2];

        int i, j, k;

        i = j = k = 0;

        while (merged[medIndex] == null) {
            while (i < l1 && j < l2) {
                if (nums1[i] < nums2[j]) {
                    merged[k++] = nums1[i++];
                } else {
                    merged[k++] = nums2[j++];
                }
            }

            while (i < l1) {
                merged[k++] = nums1[i++];
            }

            while (j < l2) {
                merged[k++] = nums2[j++];
            }
        }

        if((l1 + l2) % 2 == 0){
            return (Double.valueOf(merged[medIndex]) + Double.valueOf(merged[medIndex - 1])) / 2d;
        }

        return merged[medIndex];

    }

    @Test
    public void test1() {
        int[] num1 = {};
        int[] num2 = {1};

        double median = findMedianSortedArrays(num1, num2);
        System.out.println(median);
    }

}
