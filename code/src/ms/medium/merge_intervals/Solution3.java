package ms.medium.merge_intervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution3
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 5.0.0
 * @since <pre>Nov.23,2021</pre>
 */
public class Solution3 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            if(interval[0] <= result.get(result.size() - 1)[1]
            && interval[1] >= result.get(result.size() - 1)[1]){
                result.get(result.size() - 1)[1] = interval[1];
            }
            else if(interval[1] <= result.get(result.size() - 1)[1]){
                continue;
            }
            else {
                result.add(interval);
            }
        }

        return result.toArray(new int[0][0]);
    }


    @Test
    public void test1(){
        int[][] ints = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ints2 = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merge = merge(ints);
        System.out.println(Arrays.deepToString(merge));
    }

}
