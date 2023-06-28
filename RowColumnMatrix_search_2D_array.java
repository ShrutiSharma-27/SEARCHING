//array (or matrix) is row-wise and column-wise sorted
//can't apply binary search as it is not strictly sorted. 
import java.util.Arrays;

public class RowColumnMatrix_search_2D_array {
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

//Output : 
// [2, 3]
// [-1, -1]
// [1, 0]

//time complexity is O(n)
//space comlexity is O(1) as no extra space is used

//if I've applied the naive approach (traversing throughout the array using 2 nested loops) then time complexity will be O(n^2)
//and space complexity will be same as above O(1)
