public class Binary_search_OrderAgnostic {
    //when the sorted array is given but we don't know whether in ascending or descending order
    public static void main(String[] args) {
        int [] ascArr={5,10,15,20,25,30,35,40,45};
        int [] descArr={40,36,32,28,24,20,16,12,8,4,1};
        int ascTarget=15;
        int descTarget=4;
        System.out.println(orderAgnosticBS(ascArr, ascTarget));
        System.out.println(orderAgnosticBS(descArr, descTarget));
    }

    static int orderAgnosticBS(int[] arr, int target){
         int start=0;
         int end=arr.length-1;
         boolean isAsc = arr[start]<arr[end];

         while (start<=end){
             int mid=start+(end-start)/2;
             if (target == arr[mid]) return mid;
             if (isAsc){
                 if (target < arr[mid]) end=mid-1;
                 else start=mid+1;
             }
             else{
                 if (target < arr[mid]) start=mid+1;
                 else end=mid-1;
             }
         }
         return-1;
    }
}
