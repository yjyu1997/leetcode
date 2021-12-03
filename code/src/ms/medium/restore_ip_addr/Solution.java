package ms.medium.restore_ip_addr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution <br/>
 *
 * <a href="https://leetcode.com/problems/restore-ip-addresses/">link</a>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 5.0.0
 * @since <pre>Nov.24,2021</pre>
 */
public class Solution {

    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();

    public boolean valid(String segment) {
        int m = segment.length();
        if(m > 3 ){
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }

    public void updateOutput(int currPos){
        String segment = s.substring(currPos + 1, n);
        if(valid(segment)){
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }


    public void backtrack(int prevPos, int dots){

        //xxx.xxx.xxx.xxx
        int maxPos = Math.min(n-1, prevPos + 4);

        for(int currPos = prevPos + 1; currPos < maxPos; ++currPos){
            String segment = s.substring(prevPos + 1, currPos + 1);
            if(valid(segment)){
                segments.add(segment);

                if(dots - 1 == 0){
                    //all dots are placed
                    updateOutput(currPos);
                }
                else {
                    backtrack(currPos, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    @Test
    public void test1(){
        String testStr1 = "25525511135";
        List<String> ret = restoreIpAddresses(testStr1);
        System.out.println(ret);
    }
}
