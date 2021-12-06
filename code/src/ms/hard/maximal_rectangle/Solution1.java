package ms.hard.maximal_rectangle;

/**
 * Solution1
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Dec.06,2021</pre>
 */
public class Solution1 {

    /**
     *  时间复杂度：
     *  O(mn) 列举连续1 矩阵
     *  对连续1 矩阵的 每个点 都要 O(m) 来 计算高度
     *  O(mn) + O(mn) * O(m) = O(m^2.n)
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

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == '0') {
                    continue;
                }

                int width = left[i][j];
                int area = width;

                for (int k = i - 1; k >=0 ; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }

                ret = Math.max(ret, area);
            }
        }

        return ret;
    }


}
