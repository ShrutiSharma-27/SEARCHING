import java.util.*;

public class Linear_search_2D_array {
    public static void main(String[] args) {
        int[][] test_arr= {{100,102,300},
                {2,4,8,90},
                {1,88,23},
                {3,2}};
        int[] result1 = LS_2dArr(test_arr,23 ); // result = [row index, column index]
        int[] result2 = LS_2dArr(test_arr, 0);

        System.out.println("result for 23 : "+Arrays.toString(result1));
        System.out.println("result for 0 : "+Arrays.toString(result2));
    }
    static int[] LS_2dArr(int[][] arr, int target){
        if (arr.length==0){
            return new int[]{-1,-1} ;
        }
        for (int row=0; row<arr.length ; row++){
            for (int column=0 ; column<arr[row].length ; column++){
                if (arr[row][column]==target){
                    return new int[]{row, column};
                }
            }
        }
        return new int[]{-1,-1} ;
    }

}