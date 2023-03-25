public class Linear_search2 {
    public static void main(String[] args) {
        int[] test_arr={12,60,100,0,5};
        boolean res1 = linearSearchBool(test_arr, 5);
        System.out.println("For target=5 : "+res1);
        boolean res2 = linearSearchBool(test_arr, 1008);
        System.out.println("For target=1008 : "+res2);
    }

    //if target found : return index
    //if not : return -1
    static boolean linearSearchBool(int[] arr, int target){
        //edge checks
        if (arr.length==0){
            return false;
        }

        for (int member : arr){
            if (member==target){
                return true;
            }
        }
        //this statement will run only if none of the above statements had executed.
        return false;
    }
}
