import java.util.Arrays;

public class merge_sort{
    public static void main (String [] args){
        int[] arr = {5, 2, 8, 1, 9,3,6,4,7};

        System.out.println(Arrays.toString(mergeSort(arr)));
        // mergeSort(arr, 0, arr.length - 1);
        // mergeSort(arr, low, high);

    }
    public static int[] mergeSort(int[] arr) {
       
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        
        int[] left = Arrays.copyOfRange(arr,0, mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return sort(left,right);
    }
    public static int[] sort(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int [] arr = new int[left.length+right.length];
        while( i < left.length && j < right.length){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return arr;
    }
    // public static void mergeSort(int[] arr, int low, int high) {
    //     if (low >= high) {
    //         return;
    //     }
    //     int mid = (low+high) /2;
    //     mergeSort(arr,low,mid);
    //     mergeSort(arr, mid+1, high);
    //     merge(arr, low, mid, high);
        
    // }

    // public static void merge(int[] arr, int low, int mid, int high) {
    //     int left = low;
    //     int right = mid + 1;
    //     int k = 0;
    //     int[] temp = new int[high - low + 1];
    //     while (left <= mid && right <= high) {
    //         if(arr[left] <= arr[right]){
    //             temp[k++] = arr[left++];
    //         }else{
    //             temp[k++] = arr[right++];
    //         }
    //     }
    //     while (left <= mid) {
    //         temp[k++] = arr[left++];
    //     }
    //     while (right <= high) {
    //         temp[k++] = arr[right++];
    //     }
    //     for (int i = low; i < high; i++) {
    //         arr[i] = temp[i-low];
    //     }
        
    // }
        
}

