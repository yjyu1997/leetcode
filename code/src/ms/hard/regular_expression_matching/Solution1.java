package ms.hard.regular_expression_matching;

import org.junit.Test;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.15,2021</pre>
 */
public class Solution1 {

    public static final Character STAR_MARK = '*';
    public static final Character PERIOD_MARK = '.';

    /**
     * '*'匹配0次或多次 '.'匹配任意单个字符
     *  for dp[i][j]
     * case1: p的第j个字符是一个字母，则s必须匹配一个相同的字母
     *  dp[i][j] = dp[i-1][j-1], s[i] = p[j]
     *           = false , s[i] != p[j]
     *
     * case2: p的第j个字符是 '*'
     *    abc*
     *    abcccc
     *  dp[i][j] = dp[i][j-2], s[i] != p[j-1]
     *  dp[i][j] = dp[i-1][j] or dp[i][j-2]
     *
     * margin case: dp[0][0] = true;
     */
    public boolean isMatch(String s, String p) {

        p = removeDuplicatedStar(p);

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for (int i = 0; i < m+1 ; i++) {
            for (int j = 1; j < n+1 ; j++) {

                if(p.charAt(j-1) == STAR_MARK){

                    if(matches(s,p,i,j-1)){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }
                    else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
                else {
                    dp[i][j] = matches(s, p, i, j) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];

    }


    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == PERIOD_MARK) {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }



    public String removeDuplicatedStar(String p) {
        StringBuilder builder = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (c != '*') {
                builder.append(c);
            } else if (builder.length() < 1) {
                builder.append(c);
            } else if (builder.charAt(builder.length() - 1) != '*') {
                builder.append(c);
            }
        }
        return builder.toString();
    }


    @Test
    public void test(){
        String s = "aab";
        String p = "c*a*b";

        System.out.println(isMatch(s,p));
    }

}
