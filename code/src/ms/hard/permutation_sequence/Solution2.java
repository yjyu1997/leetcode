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

        for (int i = 0; i < m; ++i) {
            c[i] = 0;
        }


        StringBuffer ans = new StringBuffer();

        k--;

        for (int i = 1; i <= n ; i++) {
            add(c,i,1);
        }

        for (int i = n-1; i >= 0 ; i--) {
            int kth = kth(c, k/factorial[i] + 1);
            ans.append(kth);
            add(c,kth, -1);
            k %= factorial[i];
        }

        return ans.toString();
    }


    /**
     * 单点更新
     *
     * @param c 树状数组
     * @param u 更新的位置
     * @param x 更新后的数
     */
    private void add(int[] c, int u, int x) {

        while (u < c.length) {

            //每个都加上x
            c[u] += x;

            //更新下一个节点
            u += lowBit(u);
        }

    }


    /**
     * 区间求和
     * @param u
     */
    private int rnk(int[]c, int u) {

        int ret = 0;
        while (u > 0) {
            ret += c[u];
            u -= lowBit(u);
        }
        return ret;
    }


    private int kth(int[]c, int k){
        int ret = 0;

        for (int i = c.length >> 1; i > 0 ; i >>= 1) {

            if(c[ret + i] < k) {
                ret += i;
                k -= c[ret];
            }
        }

        return ret + 1;
    }

    /**
     * Find the lowest 1
     */
    private int lowBit(int x) {
        return x & -x;
    }


    @Test
    public void test1() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(getPermutation(15,7));
        }

    }


}
