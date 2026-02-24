public class ternarySearch {
    public static void main(String[] args) {
        int[] arr = { 10,9,8,7, 1, 2, 3, 4, 5};
        // System.out.println(ternarySearch(arr, 5));
        // System.out.println(unimodalMinima(arr));
        System.out.println(UnimodalSearch(arr,5));
    }

    public static int ternarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (arr[mid1] == target) {
                return mid1;
            }
            if (arr[mid2] == target) {
                return mid2;
            }
            if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1; // Target not found
    }

    public static int unimodalMinima(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int minimum = -1;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;
            if (arr[mid1] == arr[mid2]) {
                minimum = mid1;
                right = mid2 - 1;
                left = mid1 + 1;
            } else if(arr[mid1] < arr[mid2]) {
                minimum = mid1;
                right = mid2 - 1;
            }else{
                minimum = mid2;
                left = mid1 + 1;
            }
        }
        return minimum;
    }

    public static int UnimodalSearch(int[] arr, int target) {
        
        return -1; // method not found
    }

}
