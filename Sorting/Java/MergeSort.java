package Java;

/*
 * Merge Sort - follows a divide and conquer approach to sort the array. It recursively divides the input array into 2 halves, recursively sorting the 2 halves and finally merging them together.
 * Steps to follow:
 * 1. Divide the unsorted array into 2 halves until we reach array of size 1.
 * 2. Sort each array halve individually.
 * 3. Merge the 2 sorted halves together.
 
 */

 import java.util.Random;
 import java.util.Arrays;

public class MergeSort {
    private static void insertionSort(int[] arr, int mid, int left, int right, boolean isAscending){
        if(isAscending){
            for(int i = mid+1; i <= right; i++){
                int lower = arr[i];
                for(int j = left; j < i; j++){
                    if(arr[j] > lower){
                        int temp = arr[j];
                        arr[j] = lower;
                        lower = temp;
                    }
                }
                arr[i] = lower;
            }
        }else{
            for(int i = left; i <= mid; i++){
                int lower = arr[i];
                for(int j = right; j > i; j--){
                    if(arr[j] > lower){
                        int temp = arr[j];
                        arr[j] = lower;
                        lower = temp;
                    }
                }
                arr[i] = lower;
            }
        }
    }

    public static int mergeSort(int[] arr, int left, int right, boolean isAscending){
        if(left == right){ return left;}

        int mid = (right + left) / 2;
        int l = mergeSort(arr, left, mid, isAscending); //left half sort
        int r = mergeSort(arr, mid+1, right, isAscending); //right half sort

        if((right - left) == 1 && arr[l] > arr[r]){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }else{
            insertionSort(arr, mid, left, right, isAscending);
        }
        return 0;
    }

    public static void mergeSort(int[] arr, boolean isAscending){
        mergeSort(arr, 0, arr.length-1, isAscending);
    }

    public static void main(String[] args){
        int[] num = new int[10];
        Random random = new Random();

        for(int i = 0; i < num.length; i++){
            num[i] = random.nextInt(30);
        }
        IO.println(Arrays.toString(num)); //Unordered Array
        
        mergeSort(num, true); //Ascending Order
        IO.println(Arrays.toString(num));
        
        mergeSort(num, false); //Descending Order
        IO.println(Arrays.toString(num));
    }
}
