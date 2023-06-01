public class Q4_RotationCount_by_RBS {
    public static void main(String[] args) {
        int[] test_arr = {4,5,6,0,1,2};
        System.out.println(RotationCount(test_arr, false));

        int[] test_arr1={7,7,10,12,0,0,2,3,3,3,6,7};
        System.out.println(RotationCount(test_arr1, true));
    }

    static int  RotationCount(int[] arr, boolean dup) { 
        if (dup == false){  //false means it's a non duplicate array but NOTE : pivot function for duplicates will run finely for non-duplicate arrays.
            int pivot = findPivot(arr); //doing for non-duplicates now
            //if (pivot==-1) return 0; else :  no need as -1+1 will give 0
            return pivot+1;
        }
        else{
            int pivot1 = findPivot_duplicate(arr); //doing for duplicates
            return pivot1+1;
        }
    }
//for non-duplicate
    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start <= end){
            int mid=start+(end-start)/2;
            if (mid < end && arr[mid] > arr[mid+1]) return mid;
            else if (mid > start && arr[mid] < arr[mid-1]) return mid-1;
            else if (arr[start]>=arr[mid]) end=mid-1; //this part will not work for duplicates (if start=mid )
            else start=mid+1; // when arr[start]<arr[mid]
        }
        return -1;
    }
    //for duplicates
    static int findPivot_duplicate(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start <= end){
            int mid=start+(end-start)/2;
            if (mid < end && arr[mid] > arr[mid+1]) return mid;
            else if (mid > start && arr[mid] < arr[mid-1]) return mid-1;
            //if elements at mid, start and end are equal then skip the duplicates
            else if (arr[start] == arr[mid] && arr[end] == arr[mid]) {
                // NOTE : but what if one of them is a pivot, so you can't directly skip
                //check if start is a pivot
                if (arr[start] >= arr[start + 1]) return start ;
                start++;
                //check if end is a pivot
                if (arr[end] < arr[end-1]) return end-1;
                end--;
            }
            //if the left side is sorted, so pivot should be in the right hand side of mid
            else if (arr[start] < arr[mid] || (arr[start]==arr[mid] && arr[mid] > arr[end])) start = mid+1;
            //if pivot lies on left hand side of mid
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}

//Output :
// 3
// 4
