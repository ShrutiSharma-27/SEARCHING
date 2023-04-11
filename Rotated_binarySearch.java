public class Rotated_binarySearch {
    public static void main(String[] args) {
        int[] test_arr={7,7,7,10,12,12,2,3,6};
    }

    static int binarySearch(int[] arr, int t, int start, int end){
        while (start<=end){
            int mid=start+(end-start)/2;
            if (t==arr[mid]) return mid;
            else if (t<arr[mid]) end=mid-1;
            else start=mid+1;
        }
        return -1;
    }

    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start <= end){
            int mid=start+(end-start)/2;
            if (mid<end && arr[mid]>arr[mid+1]) return mid;
            else if (mid>start && arr[mid]<arr[mid-1]) return mid-1;
            //else if (arr[start]>=arr[mid]) end=mid-1; this part  will not work for duplicates (if start=mid )
            //else start=mid+1;  when arr[start]<arr[mid]
        }
        return -1;
    }
}
