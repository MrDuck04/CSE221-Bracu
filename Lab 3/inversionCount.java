import java.util.*;
import java.io.*;

public class inversionCount {
    static long count = 0;
   
    public static int[] mergeSort(int[] arr) {
       
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        
        int[] left = Arrays.copyOfRange(arr,0, mid); //can i use this?
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return sort(left,right);
    }
    public static int[] sort(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int [] arr = new int[left.length+right.length];
        while( i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else{//right is smaller
                count+= left.length-i;
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
    public static long numberOfInversions(int[] arr) {
        count = 0;
        mergeSort(arr);
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int[] arr = new int[length];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // int[] arr = {1, 2, 5, 4, 3};
        System.out.println(numberOfInversions(arr));
        int[] sorted = mergeSort(arr);
        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }
}
