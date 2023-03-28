class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return peak(arr);
    }

    static int peak (int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start!=end){
            int mid = start + (end - start)/2 ;
            if (arr[mid]<arr[mid+1]) start=mid+1; //you are in increasing part of array hence mid+1 element > mid element
            else end=mid; //you are in decreasing part so this may be the ans but look at left side with including mid (that's why we haven't used end=mid-1)
        }
        return start;
    }
}
