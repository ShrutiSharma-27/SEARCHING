//Linear search which returns element itself on finding

public class Linear_search1 {
    public static void main(String[] args) {
        int[] test_arr={12,60,100,0,5};
        int res1 = linearSearchEle(test_arr, 5);
        System.out.println("For target=5 : "+res1);
        int res2 = linearSearchEle(test_arr, 1008);
        System.out.println("For target=1008 : "+res2);
    }

    //if target found : return index
    //if not : return -1
    static int linearSearchEle(int[] arr, int target){
        //edge checks
        if (arr.length==0){
            return Integer.MAX_VALUE; //as this might be the case when -1 is one of the element in array passed
        }

        for (int member : arr){
            if (member==target){
                return member;
            }
        }
        //this statement will run only if none of the above statements had executed.
        return Integer.MAX_VALUE;
    }
}
