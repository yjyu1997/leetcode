package ms.medium.word_search;

import org.junit.Test;

/**
 * Solution1 <br/>
 * <p>
 * 79. Word Search <br/>
 * <a href="https://leetcode.com/problems/word-search/">link</a>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.23,2021</pre>
 */
public class Solution1 {

    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int row = 0; row < this.rows; ++row) {
            for (int col = 0; col < this.cols; ++col) {
                if (this.backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Step 1). At the beginning, first we check if we reach the bottom case of the recursion,
     * where the word to be matched is empty, i.e. we have already found the match for each prefix of the word.
     * <p>
     * Step 2). We then check if the current state is invalid, either the position of
     * the cell is out of the boundary of the board or the letter in the current cell
     * does not match with the first letter of the word.
     * <p>
     * Step 3). If the current step is valid, we then start the exploration of backtracking with
     * the strategy of DFS. First, we mark the current cell as visited, e.g. any non-alphabetic letter
     * will do. Then we iterate through the four possible directions, namely up, right, down and left.
     * The order of the directions can be altered, to one's preference.
     * <p>
     * Step 4). At the end of the exploration, we revert the cell back to its original state.
     * Finally we return the result of the exploration.
     */
    public boolean backtrack(int row, int col, String word, int index) {

        //1. check if we reach the bottom case
        if (index >= word.length()) {
            return true;
        }

        //2. check the boundaries
        if (row < 0 || row == this.rows || col < 0 || col == this.cols
                || this.board[row][col] != word.charAt(index)) {
            return false;
        }

        //3. explore neighbors in DFS
        boolean ret = false;
        this.board[row][col] = '#';

        //right, up , left, down
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};

        for (int d = 0; d < 4; ++d) {
            ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1);
            if (ret) {
                break;
            }
        }

        this.board[row][col] = word.charAt(index);
        return ret;
    }

    @Test
    public void test1() {
        char[][] chars = {{'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'}
                , {'A', 'D', 'E', 'E'}};

        boolean ret = exist(chars, "ABCCEDE");

        System.out.println(ret);
    }
}
