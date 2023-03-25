/*
TIME COMPLEXITY : O(logN)
WORST CASE TIME COMPLEXITY : O(logN)
BEST CASE TIME COMPLEXITY : O(1)

SPACE COMPLEXITY : O(1)
*/

public class Binary_search {
    public static void main(String[] args) {
        int[] test_arr={-24,-12,-1,0,12,24,36,48,60,72,84}; //consider a sorted array
        int target_ele=60;
        System.out.println(binarySearch(test_arr,target_ele));
    }

    static int binarySearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            //find middle
            /*int mid=(start+end)/2 gives error as there might be the possibility in large nos that start+end
            exceeds the int limit while making the calculations*/
            int mid= start + (end-start)/2;
            if (target == arr[mid]) return mid; //target found
            else if (target < arr[mid]) end=mid-1;
            else if (target > arr[mid]) start=mid+1;
        }
        return -1;
    }
}
