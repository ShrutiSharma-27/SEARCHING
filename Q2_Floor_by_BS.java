public class Q2_Floor_by_BS {
    public static void main(String[] args) {
        int[] test_arr={-24,-12,-1,0,12,24,36,48,60,72,84};
        int target_ele=5;
        System.out.println(floor(test_arr,target_ele));
    }

    static int floor(int[] arr, int target){ //return index : greatest number <=target
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid= start + (end-start)/2;
            if (target == arr[mid]) return mid; //target found
            else if (target < arr[mid]) end=mid-1;
            else if (target > arr[mid]) start=mid+1;
        }
        return end;
    }
}
