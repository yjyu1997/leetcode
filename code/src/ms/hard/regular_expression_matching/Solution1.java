package ms.hard.regular_expression_matching;

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
     */
    public boolean isMatch(String s, String p) {

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

}
