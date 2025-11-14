package Java;

/*
 * Insertion Sort - works by dividing the array into 2 parts, sorted and unsorted. Inserting each element of the unsorted array into its correct position in the sorted potion of the array.
 * Steps to follow:
 *  1. Start from the 2nd element (as the first element is already sorted)
 *  2. Compare the current element with the elements in the sorted array (to its left)
 *  3. Shift all the elements in the sorted array that are greater than the current element to the right by one position
 *  4. Insert the current element into its correct position in the sorted array
 *  5. Repeat until the entire array is sorted
 * 
 * Time Complexity:
 *  Best Case: O(n) - when the array is already sorted
 *  Average Case: O(n^2) - when the array is randomly sorted
 *  Worst Case: O(n^2) - when the array is sorted in reverse order
 * 
 * Space Complexity: O(1) - as it is an in-place sorting algorithm
 * 
 * Advatages:
 *  1. Simple to implement and understand
 *  2. Efficient for small data sets
 *  3. Stable sort (does not change the relative order of equal elements)
 * 
 * Disadvantages:
 *  1. Inefficient for large data sets
 */

import java.util.Random;
import java.util.Arrays;

class InsertionSort{

    private static void cmpAndShift(int[] arr, int elem, int startIndex, int endIndex){
        if(startIndex == endIndex){ return; }
        
        if(startIndex < endIndex){
            for(int i = startIndex; i < endIndex; i++){
                if(arr[i] > elem){
                    int temp = arr[i];
                    arr[i] = elem;
                    elem = temp;
                }
            }
        }else{
            for(int i = startIndex; i > endIndex; i--){
                if(arr[i] > elem){
                    int temp = arr[i];
                    arr[i] = elem;
                    elem = temp;
                }
            }
        }

        arr[endIndex] = elem;
    }
    
    public static void insertionSortDescending(int[] arr){
        if(arr.length < 2){return;}

        if(arr[arr.length-1] > arr[arr.length-2]){
            int temp = arr[arr.length-1];
            arr[arr.length-1] = arr[arr.length-2];
            arr[arr.length-2] = temp;
        }

        for(int i = arr.length-2; i > 0; i--){
            if(arr[i] > arr[i-1]){
                cmpAndShift(arr, arr[i-1], arr.length-1, i-1);
            }
        }
    }

    public static void insertionSortAscending(int[] arr){
        if(arr.length < 2){return;}
        
        if(arr[0] > arr[1]){
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }

        for(int i = 1; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                cmpAndShift(arr, arr[i+1], 0, i+1);
            }
        }
    } 
   
    public static void insertionSort(int[] arr, boolean isAscending){
        if(isAscending){
            insertionSortAscending(arr);
        }else{
            insertionSortDescending(arr);
        }
    }
    public static void main(String[] args){
        int[] num = new int[10];
        Random random = new Random();
        
        for (int i = 0; i < num.length; i++) {
           num[i] = random.nextInt(30);
        }

        IO.println(Arrays.toString(num)); //Usorted Array


        insertionSort(num, true); //Ascending Order
        IO.println(Arrays.toString(num));
        
        insertionSort(num, false); //Descending Order
        IO.println(Arrays.toString(num));

    }
}