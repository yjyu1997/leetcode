package ms.hard.permutation_sequence;

import org.junit.Test;

import java.util.Arrays;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.09,2021</pre>
 */
public class Solution1 {


    /**
     *
     * @param n 几位数排列
     * @param k 排第k位的排列
     * @return 排列
     */
    public String getPermutation(int n, int k) {

        //计算阶乘
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--;

        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);

        for (int i = 1; i <= n ; i++) {

            //calcute the number order in current unused numbers
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                // find the number in proper order
                order -= valid[j];

                if(order == 0){
                    // if found
                    ans.append(j);

                    //made this number invalid
                    valid[j] = 0;
                    break;
                }
            }

            k %= factorial[n - i];
        }

        return ans.toString();
    }


}
