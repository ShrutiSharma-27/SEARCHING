public class Rotated_binarySearch_Duplicate {
    public static void main(String[] args) {
        int[] test_arr={7,10,12,0,2,3,6};
        System.out.println(search(test_arr, 6));
        System.out.println(search(test_arr, 9));
        System.out.println(search(test_arr, 0));
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
        int pivot = findPivot(arr);

        if (pivot == -1) return binarySearch(arr, t, 0, arr.length-1);
        else if (arr[pivot] == t) return pivot ;
        else if (arr[0] > t) return binarySearch(arr, t , pivot+1, arr.length-1);
        else if (arr[0] < t) return binarySearch(arr, t , 0, pivot);
        else return -1;
    }

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
}

// Output :
// 6
// -1
// 3
