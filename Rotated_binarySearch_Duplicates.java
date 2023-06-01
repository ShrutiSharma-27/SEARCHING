public class Rotated_binarySearch_Duplicate {
    public static void main(String[] args) {
        int[] test_arr={7,7,10,12,0,0,2,3,3,3,6,7};
        System.out.println(search(test_arr, 6));
        System.out.println(search(test_arr, 2));
        System.out.println(search(test_arr, 12));
    }

    static int binarySearch(int[] arr, int t, int start, int end){
        while (start <= end){
            int mid = start + (end-start)/2 ;
            if(arr[mid] == t) return mid;
            else if(arr[mid] <= t) start = mid + 1;
            else end = mid - 1 ;
        }
        return -1; //if target isn't found
    }

    static int search(int[] arr, int t){
        int pivot = findPivot_duplicate(arr);

        if (pivot == -1) return binarySearch(arr, t, 0, arr.length-1);
        else if (arr[pivot] == t) return pivot ;
        else if (arr[0] > t) return binarySearch(arr, t , pivot+1, arr.length-1);
        else if (arr[0] < t) return binarySearch(arr, t , 0, pivot);
        else return -1;
    }

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
                if (arr[start] >= arr[start + 1]){
                    return start ;
                }
                start++;
                //check if end is a pivot
                if (arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
            //if the left side is sorted, so pivot should be in the right hand side of mid
            else if (arr[start] < arr[mid] || (arr[start]==arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            }
            //if pivot lies on left hand side of mid
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
