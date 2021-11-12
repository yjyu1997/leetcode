package ms.hard.wildcard_matching;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution1 <br/>
 * 备忘录算法 <br/>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.10,2021</pre>
 */
public class Solution1 {

    public static final String STAR_MARK = "*";
    public static final String QUESTION_MARK = "?";
    public static Map<Integer,Boolean> dp = new HashMap<>();

    public boolean isMatch(String s, String p) {

        p = removeDuplicatedStar(p);

        String pCurrent = p.isEmpty() ? p : p.substring(0,1);

        String sCurrent = s.isEmpty() ? s : s.substring(0,1);

        if(dp.containsKey(hash(s,p))){
            return dp.get(hash(s,p));
        }
        //if p == s, return true

        if(s.equals(p)){
            dp.put(hash(s,p),true);
        }

        // p == '*', return true

        else if(p.equals(STAR_MARK)){
            dp.put(hash(s,p),true);
        }
        // p is empty, return false

        else if(p.isEmpty()){
            dp.put(hash(s,p),false);
        }


        // p[0] == s[0] or p[0] == '?' mv to next
        else if(pCurrent.equals(QUESTION_MARK)  ||
        pCurrent.equals(sCurrent)){
            try {
                dp.put(hash(s,p), isMatch(s.substring(1), p.substring(1)));
            }catch (Exception e){
                dp.put(hash(s,p),false);
            }
        }

        //if p[0] == '*' then
        else if(pCurrent.equals(STAR_MARK)){
            boolean match = isMatch(s, p.substring(1));
            if(!match){
                try {
                    match = isMatch(s.substring(1), p);
                }catch (Exception e){
                    dp.put(hash(s,p),false);
                }
            }
            dp.put(hash(s,p),match);
        }

        else {
            dp.put(hash(s,p),false);
        }
        // a. '*' matches "", then isMatch(s, p[1:])
        // b. '*' matches one or more character, then isMarch(s[1:], p)
        return dp.get(hash(s,p));
    }


    public int hash(String s, String p){
        return s.hashCode() + p.hashCode();
    }

    public String removeDuplicatedStar(String p){
        StringBuilder builder = new StringBuilder();
        for (char c : p.toCharArray()) {
            if(c != '*'){
                builder.append(c);
            }
            else if(builder.length() < 1){
                builder.append(c);
            }
            else if(builder.charAt(builder.length() - 1) != '*'){
                builder.append(c);
            }
        }
        return builder.toString();
    }


    @Test
    public void test1(){
       // System.out.println(isMatch("bbbaaabbababbaabbabbbbba",
       //        "*ab*****b"));
        System.out.println(isMatch("de", "??*"));
    }
}
