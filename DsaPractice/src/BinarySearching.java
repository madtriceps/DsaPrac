public class BinarySearching {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BinarySearching b = new BinarySearching();

        int indexx = b.bubbleSearch(arr,10);
        System.out.println(indexx);
    }

    public int bubbleSearch(int[] a , int target){
        int low=0, high=a.length-1;
        int mid;
        if(a.length == 0){
            return -1;
        }
        while(low <= high){
            mid = (low + high)/2;
            if(a[mid] == target){
                return mid;
            }
            if(a[mid] > target){
                high = mid-1;
                mid = (low + high)/2;
            }
            if(a[mid] < target){
                low = mid+1;
                mid = (low + high)/2;
            }
        }

        return -1;
    }

}
