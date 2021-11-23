package ms.medium.anagrams;

import org.junit.Test;

import java.util.*;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.15,2021</pre>
 */
public class Solution1 {

    public List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            //let strs be sorted
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }


    @Test
    public void test1() {
        String[] input = {"eat", "tea", "tan", "nat", "ate", "bat"};
        System.out.println(groupAnagrams(input));
    }
}
