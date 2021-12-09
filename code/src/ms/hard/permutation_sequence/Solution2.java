package ms.hard.permutation_sequence;

import org.junit.Test;

/**
 * Solution2
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.09,2021</pre>
 */
public class Solution2 {


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

        //构建树状数组
        int m = 1;
        //2倍扩容
        while (m < n) {
            m <<= 1;
        }

        int[] c = new int[m];

        for(int i=0; i<m; ++i) {
            c[i] = 0;
        }


        return null;
    }

    private void add(int[] c , int u , int x){

        while(u < c.length){
            c[u] += x;
            u += lowBit(u);
        }

    }


    /**
     * Find the lowest 1
     */
    private int lowBit(int x){
        return x & -x;
    }




    @Test
    public void test1(){
        System.out.println(3&-3);
    }


}
