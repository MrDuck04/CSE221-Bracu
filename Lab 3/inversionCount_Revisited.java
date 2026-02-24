//task2
import java.util.*;
import java.io.*;
public class inversionCount_Revisited {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int [] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // int[] arr = {10, 2, 5, 1, -2, 25};
        System.out.println(inversionCountRevisited(arr));
    }

    public static long inversionCountRevisited(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, 0, arr.length - 1, temp);
    }

    public static long mergeSort(int[] arr, int low, int high, int[] temp) {
        long count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low+high) /2;
        count += mergeSort(arr, low, mid, temp);
        count += mergeSort(arr, mid+1, high, temp);
        count += countCrossPairs(arr, low, mid, high);
        merge(arr, low, mid, high, temp);
        return count;
    }

    public static long countCrossPairs(int[] arr, int low, int mid, int high) {
        long count = 0;
        for (int j = mid + 1; j <= high; j++) {
            long squared = 1L * arr[j] * arr[j];
            int firstGreater = upperBound(arr, low, mid, squared);
            count += (mid - firstGreater + 1);
        }
        return count;
    }

    public static int upperBound(int[] arr, int low, int high, long value) {
        int left = low;
        int right = high;
        int answer = high + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > value) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int left = low;
        int right = mid + 1;
        int k = low;
        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]){
                temp[k++] = arr[left++];
            }else{
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }
}
