//array (or matrix) is row-wise and column-wise sorted
import java.util.Arrays;

public class Binary_search_2D_array {
    public static void main(String[] args) {
        int[][] test_matrix = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        int[] res1 = RowColMatrix_Search(test_matrix, 49);
        int[] res2 = RowColMatrix_Search(test_matrix, 39);
        int[] res3 = RowColMatrix_Search(test_matrix, 15);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(res3));
    }

    static int[] RowColMatrix_Search(int[][] matrix, int t){
        int row = 0;
        int col = matrix.length-1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == t) return new int[]{row, col};
            else if (matrix[row][col] < t) row++;
            else col--;
        }
        return new int[] {-1,-1};
    }
}