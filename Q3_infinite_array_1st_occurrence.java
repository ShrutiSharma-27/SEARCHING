/*
* infinite array indicates that you can't use arr.length
* Question : Find position of an element in a sorted array of infinite numbers.
* time complexity : logN (=logN for BS + logN for increasing range 2 times at every step= 2logN)
*/

public class Q3_infinite_array_1st_occurrence {
    public static void main(String[] args) {
        int[] test_arr={0,2,3,4,8,11,90,91,91,95,98,100,102,500};
        int target1=4;
        System.out.println(findIndex(test_arr,target1));
    }

    static int findIndex(int[] arr, int target){
        int start=0;
        int end=1;
        int ans=-1;
        int range=end-start+1;
        if (target<arr[start]) return ans;
        while (true){
            if (arr[start]==target) return start;
            else if (arr[end]==target) return end;
            else if (arr[end]>target) {
                return binarySearch(arr, target, start, end);
            }
            range*=2;
            start = end + 1;
            end += range ; //end += box_size*2
        }
    }

    static int binarySearch(int[] arr,int target,int initial_index,int final_index){
        while(initial_index<=final_index){
            //find middle
            /*int mid=(start+end)/2 gives error as there might be the possibility in large nos that start+end
            exceeds the int limit while making the calculations*/
            int mid= initial_index + (final_index-initial_index)/2;
            if (target == arr[mid]) return mid; //target found
            else if (target < arr[mid]) final_index=mid-1;
            else if (target > arr[mid]) initial_index=mid+1;
        }
        return -1;
    }

}


