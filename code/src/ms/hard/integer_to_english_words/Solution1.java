package ms.hard.integer_to_english_words;

import org.junit.Test;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.15,2021</pre>
 */
public class Solution1 {

    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};


    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }
        StringBuffer sb = new StringBuffer();

        for(int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000){

            //按每三位分为四组

            int curNum = num / unit;

            if(curNum != 0){
                num %= unit;
                StringBuffer curr = new StringBuffer();
                recursion(curr, curNum);
                curr.append(thousands[i]).append(" ");
                sb.append(curr);
            }
        }

        return sb.toString().trim();
    }


    public void recursion(StringBuffer curr, int num) {
        if (num == 0) {
            return;
        } else if (num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num < 20) {
            curr.append(teens[num - 10]).append(" ");
        } else if (num < 100) {
            curr.append(tens[num / 10]).append(" ");
            recursion(curr, num % 10);
        } else {
            curr.append(singles[num / 100]).append(" Hundred ");
            recursion(curr, num % 100);
        }
    }


    public String toEnglish(int num) {
        StringBuffer curr = new StringBuffer();
        int hundred = num / 100;
        num %= 100;
        if (hundred != 0) {
            curr.append(singles[hundred]).append(" Hundred ");
        }
        int ten = num / 10;
        if (ten >= 2) {
            curr.append(tens[ten]).append(" ");
            num %= 10;
        }
        if (num > 0 && num < 10) {
            curr.append(singles[num]).append(" ");
        } else if (num >= 10) {
            curr.append(teens[num - 10]).append(" ");
        }
        return curr.toString();
    }


    @Test
    public void test(){
        System.out.println(numberToWords(2));
    }

}
