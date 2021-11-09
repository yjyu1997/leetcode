package ms.medium.letter_combinations;

import org.junit.Test;

import java.util.*;

/**
 * Solution1
 * BFS
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.08,2021</pre>
 */
public class Solution1 {

    static Map<String, List<String>> dic = new HashMap<>(16);
    static List<String> num1 = new ArrayList<>();
    static List<String> num2 = new ArrayList<>();
    static List<String> num3 = new ArrayList<>();
    static List<String> num4 = new ArrayList<>();
    static List<String> num5 = new ArrayList<>();
    static List<String> num6 = new ArrayList<>();
    static List<String> num7 = new ArrayList<>();
    static List<String> num8 = new ArrayList<>();
    static List<String> num9 = new ArrayList<>();

    static {
        num2.add("a");
        num2.add("b");
        num2.add("c");

        num3.add("d");
        num3.add("e");
        num3.add("f");

        num4.add("g");
        num4.add("h");
        num4.add("i");

        num5.add("j");
        num5.add("k");
        num5.add("l");

        num6.add("m");
        num6.add("n");
        num6.add("o");

        num7.add("p");
        num7.add("q");
        num7.add("r");
        num7.add("s");

        num8.add("t");
        num8.add("u");
        num8.add("v");

        num9.add("w");
        num9.add("x");
        num9.add("y");
        num9.add("z");


        dic.put("1", num1);
        dic.put("2", num2);
        dic.put("3", num3);
        dic.put("4", num4);
        dic.put("5", num5);
        dic.put("6", num6);
        dic.put("7", num7);
        dic.put("8", num8);
        dic.put("9", num9);
    }



    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();

        List<String> result =  new ArrayList<>();
        if(chars.length > 0){
            for (int i = 0; i < chars.length; i++) {
                List<String> elements = dic.get(String.valueOf(chars[i]));
                result = doCombine(result, elements);
            }
        }
        return result;
    }

    public List<String> doCombine(List<String> input1, List<String> input2){
        List<String> result = new ArrayList<>();

        if(input1.size() == 0){
            return input2;
        }

        if(input2.size() == 0){
            return input1;
        }

        for (String e1 : input1) {
            for (String e2 : input2) {
                result.add(e1 + e2);
            }
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("243"));
    }
}
