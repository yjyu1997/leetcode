package ms.medium.spiral_matrix;

import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Solution1 <br/>
 * Given an m x n matrix, return all elements of the matrix in spiral order.<br>
 * <a href="https://leetcode.com/problems/spiral-matrix/">link</a>
 *
 * @author <span style="color:#FFB43B;"><b>Heyu Yao</b></span>
 * @version 1.0.0
 * @since <pre>Nov.15,2021</pre>
 */
public class Solution1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        Set<Point> visited = new HashSet<>();

        Point point = new Point(0, 0);
        result.add(matrix[0][0]);
        visited.add(point);

        while (result.size() < m * n) {
            point = mvRight(matrix, point, visited, result);
            point = mvDown(matrix, point, visited, result);
            point = mvLeft(matrix, point, visited, result);
            point = mvUp(matrix, point, visited, result);
        }
        return result;
    }


    private Point mvRight(int[][] matrix, Point point, Set<Point> visited, List<Integer> result) {

        point = new Point(point.x + 1, point.y);

        while (!(visited.contains(point) ||
                point.x >= matrix[0].length ||
                point.y >= matrix.length ||
                point.x < 0 ||
                point.y < 0)) {

            result.add(matrix[point.y][point.x]);
            visited.add(point);
            point = new Point(point.x + 1, point.y);
        }

        point.setLocation(point.x - 1, point.y);
        return point;
    }

    private Point mvDown(int[][] matrix, Point point, Set<Point> visited, List<Integer> result) {

        point = new Point(point.x, point.y + 1);

        while (!(visited.contains(point) ||
                point.x >= matrix[0].length ||
                point.y >= matrix.length ||
                point.x < 0 ||
                point.y < 0)) {

            result.add(matrix[point.y][point.x]);
            visited.add(point);
            point = new Point(point.x, point.y + 1);
        }

        point.setLocation(point.x, point.y - 1);
        return point;
    }


    private Point mvLeft(int[][] matrix, Point point, Set<Point> visited, List<Integer> result) {

        point= new Point(point.x - 1, point.y);

        while (!(visited.contains(point) ||
                point.x >= matrix[0].length ||
                point.y >= matrix.length ||
                point.x < 0 ||
                point.y < 0)) {

            result.add(matrix[point.y][point.x]);
            visited.add(point);
            point = new Point(point.x - 1, point.y);
        }

        point.setLocation(point.x + 1, point.y);
        return point;
    }


    private Point mvUp(int[][] matrix, Point point, Set<Point> visited, List<Integer> result) {

        point = new Point(point.x, point.y - 1);

        while (!(visited.contains(point) ||
                point.x >= matrix[0].length ||
                point.y >= matrix.length ||
                point.x < 0 ||
                point.y < 0)) {

            result.add(matrix[point.y][point.x]);
            visited.add(point);
            point = new Point(point.x, point.y - 1);
        }

        point.setLocation(point.x, point.y + 1);
        return point;
    }


    class Point{
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setLocation(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }



    @Test
    public void test1() {
        //int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{1,2,3,},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }
}
