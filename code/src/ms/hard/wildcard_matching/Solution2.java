package ms.hard.wildcard_matching;

import org.junit.Test;

/**
 * Solution2 <br/>
 * <p>
 * Dynamic Programming <br/>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.12,2021</pre>
 */
public class Solution2 {

    public static final Character STAR_MARK = '*';
    public static final Character QUESTION_MARK = '?';

    public boolean isMatch(String s, String p) {

        //Remove the duplicated star mark
        p = removeDuplicatedStar(p);

        int sLength = s.length();
        int pLength = p.length();

        if (p.equals(s)) {
            return true;
        }

        if (pLength > 0 && p.equals(STAR_MARK.toString())) {
            return true;
        }

        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }

        Boolean[][] dp = getDpMatrix(s, p);

        return dp[pLength][sLength];
    }


    private Boolean[][] getDpMatrix(String s, String p){

        int sLength = s.length();
        int pLength = p.length();



        Boolean[][] dp = new Boolean[pLength + 1][sLength + 1];

        //first, leave the matrix [0][0] with true
        dp[0][0] = true;

        //if end with '?' or equals p[p_index - 1] == s[s_index  - 1]
        //D[p_index][s_index] = D[p_index - 1][s_index -1]

        //if end with '*'
        // a. '*' matches "", then isMatch(s, p[1:])
        // b. '*' matches one or more character, then isMatch(s[1:], p)
        //if D[p_index - 1][s_index -1] is true
        // ==> D[p_index][i], i >= s_index - 1 is true

        for (int p_index = 1; p_index < pLength + 1; p_index++) {
            if (p.charAt(p_index - 1) == STAR_MARK) {
                int s_Index = 1;

                //loop until find D[p_index - 1][s_index -1] is true
                while ((!dp[p_index - 1][s_Index - 1]) && (s_Index < sLength + 1)) {
                    s_Index++;
                }

                //fill all the matrix
                dp[p_index][s_Index - 1] = dp[p_index - 1][s_Index - 1];

                while (s_Index < sLength + 1) {
                    dp[p_index][s_Index++] = true;
                }
            } else if (p.charAt(p_index - 1) == QUESTION_MARK) {
                for (int s_index = 1; s_index < sLength + 1; s_index++) {
                    dp[p_index][s_index] = dp[p_index - 1][s_index - 1];
                }
            } else {
                for (int s_index = 1; s_index < sLength + 1; s_index++) {
                    dp[p_index][s_index] = dp[p_index - 1][s_index - 1]
                            && p.charAt(p_index - 1) == s.charAt(s_index - 1);
                }
            }
        }

        return dp;
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

    public <T> void printMatrix(T[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void test1() {
         System.out.println(isMatch("bbbaaabbababbaabbabbbbba",
                "*ab*****b"));
        System.out.println(isMatch("de", "??"));
        //this.<Boolean>printMatrix(getDpMatrix("bbbaaabbababbaabbabbbbba", "*ab*****b"));
    }
}
