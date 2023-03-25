/*
TIME COMPLEXITY : O(N)
WORST CASE TIME COMPLEXITY : O(N)
BEST CASE TIME COMPLEXITY : O(1)

SPACE COMPLEXITY : O(1)
*/

public class Linear_search {
    public static void main(String[] args) {
        int[] test_arr={12,60,100,0,5};
        int res1 = linearSearch(test_arr, 5);
        System.out.println("For target=5, index= "+res1);
        int res2 = linearSearch(test_arr, 1008);
        System.out.println("For target=1008, index= "+res2);
    }

    //if target found : return index
    //if not : return -1
    static int linearSearch(int[] arr, int target){
        //edge checks
        if (arr.length==0){
            return -1;
        }

        for (int i=0 ; i<arr.length ; i++){
            if (arr[i]==target){
                return i;
            }
        }
        //this statement will run only if none of the above statements had executed.
        return -1;
    }
}
