import java.util.Arrays;
public class Binary_search_sortedMatrix {
    public static void main(String[] args) {
        int[][] test_matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println(Arrays.toString(matrix_search(test_matrix, 4)));
    }

    //search in the row provided and between the columns passed.
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while (cStart <= cEnd){
            int mid = cStart + (cEnd - cStart)/2 ;
            if (matrix[row][mid] == target) return new int[] {row, mid};
            else if (matrix[row][mid] < target) cStart = mid+1 ;
            else cEnd = mid-1;
        }
        return new int[] {-1,-1};
    }

    static int[] matrix_search(int[][] matrix, int t){
        int rows=matrix.length;
        int columns=matrix[0].length;

        int rStart = 0;
        int rEnd = rows-1 ;
        int cMid = (columns-1)/2 ;

        //edge-case
        if (rows == 1) return binarySearch(matrix, 0, 0, columns-1, t);

        //run the loop till 2 rows are remaining
        //here we're eliminating rows but we can also eliminate columns
        while (rStart < (rEnd-1)){ //while this is true it will have more than 2 rows
            int mid = rStart + (rEnd - rStart)/2 ;
            if (matrix[mid][cMid] == t) return new int[] {mid, cMid} ;
            else if (matrix[mid][cMid] < t) rStart = mid;
            else rEnd = mid;
        }
        //now we have 2 rows
        //check whether the target is in the middle column or not
        if (matrix[rStart][cMid] == t) return new int[] {rStart, cMid} ;
        if (matrix[rStart+1][cMid] == t) return new int[] {rStart+1, cMid} ; //rStart+1 = end

        //search in 1st half
        if (t<=matrix[rStart][cMid-1]) return binarySearch(matrix, rStart, 0, cMid-1, t) ;
        //search in 2nd half
        else if (t>=matrix[rStart][cMid+1] && t<=matrix[rStart][columns-1]) return binarySearch(matrix, rStart, cMid+1, columns-1, t) ;
        //search in 3rd half
        else if (t<=matrix[rStart+1][cMid-1]) return binarySearch(matrix, rStart+1, 0, cMid-1, t) ;
        //search in 4th half
        else return binarySearch(matrix, rStart+1, cMid+1, columns-1, t) ;
    }
}

//Output :
//[1, 0]

//time complexity is O(logn +  logm) where n is no of rows and m is no of columns.
//space complexity is O(1) as no auxiliary space is utilized.
