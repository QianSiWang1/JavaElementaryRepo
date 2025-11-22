package hot100.matrix;

/**
 * num 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class Search2DMatrixⅡ {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 5));
    }

    private static boolean searchMatrix(int[][] matrix, int i) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == i) {
                return true;
            }
            if (matrix[x][y] > i) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
