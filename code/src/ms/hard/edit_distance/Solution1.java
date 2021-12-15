package ms.hard.edit_distance;

import org.junit.Test;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.14,2021</pre>
 */
public class Solution1 {

    /**
     * case1: word1 添加 一个字母
     *
     * case2: word2 添加一个字母
     *
     * case3：word1 修改一个字母
     *
     * ------------------------------------
     * 现有编辑距离 d[i][j]
     *
     * 代表从 word1 1～i 和 word2 1～j 子字符串需要的编辑距离
     *
     * case1:最后一个字母相同
     *
     * d[i][j] = 1 + min(d[i-1][j] , d[i][j-1], d[i-1][j-1] - 1)
     *
     * case2: 最后一个字母不同
     *
     * d[i][j] = 1 + min(d[i-1][j] , d[i][j-1], d[i-1][j-1])
     *
     * 寻找边际情况：
     *
     * d[0][j] = j
     * d[i][0] = i
     *
     *
     *
     */
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }


        int[][] dp = new int[n+1][m+1];

        //init margin case
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int case_one = dp[i-1][j];
                int case_two = dp[i][j-1];
                int case_three = dp[i-1][j-1] - 1;

                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    case_three ++;
                }

                dp[i][j] = 1 + Math.min(case_three,Math.min(case_one,case_two));
            }
        }

        return dp[n][m];
    }

    @Test
    public void test1(){
        System.out.println(minDistance("horse","ros"));
    }

}
