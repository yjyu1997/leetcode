package ms.hard.maximal_rectangle;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution3
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.08,2021</pre>
 */
public class Solution3 {

    /**
     * 单调栈+常数优化
     */
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;

        if(rows == 0){
            return 0;
        }

        int columns = matrix[0].length;

        int[][] left = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }

        int ret = 0;

        for (int j = 0; j < columns; j++) {
            //for each columns
            int[] up = new int[rows];
            int[] down = new int[rows];
            Arrays.fill(down, rows);

            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    down[stack.peek()] = i;
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = 0; i < rows; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }

        return ret;
    }


    @Test
    public void test(){
//        char[][] matrix =
//                        {{'1','0','1','0','0'},
//                        {'1','0','1','1','1'},
//                        {'1','1','1','1','1'},
//                        {'1','0','0','1','0'}};

        char[][] matrix =
                {{'1'}};

        System.out.println(maximalRectangle(matrix));
    }

}
