package ms.medium.merge_intervals;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Solution1 <br/>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,<br/>
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.<br>
 * <a href="https://leetcode.com/problems/merge-intervals/">link</a>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.17,2021</pre>
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {

            boolean isMerged = false;

            for (int i = 0; i < result.size(); i++) {
                int[] stored = result.get(i);

                if(interval[0] >= stored[0]
                        && interval[0] <= stored[1]
                        && interval[1] >= stored[1]){
                    stored[1] = interval[1];
                    isMerged = true;
                }

                else if(interval[0] <= stored[0] && interval[1] >= stored[1]){
                    stored[0] = interval[0];
                    stored[1] = interval[1];
                    isMerged = true;
                }

                else if(interval[0] <= stored[0]
                        && interval[1] >= stored[0]
                        && interval[1] <= stored[1]){
                    stored[0] = interval[0];
                    isMerged = true;
                }

                else if (interval[0] >= stored[0] && interval[1] <= stored[1]){
                    isMerged = true;
                }
            }

            if(!isMerged) {
                result.add(interval);
            }
        }

        return result.toArray(new int[0][0]);
    }



    @Test
    public void test1(){
        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ints2 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = merge(ints2);
        System.out.println(Arrays.deepToString(merge));
    }
}
