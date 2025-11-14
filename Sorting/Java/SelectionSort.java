package Java;
/*
 * Selection Sort is a comparison-based sorting algorithm. It repeatedly selects the smallest(or largest) element from the unsorted portion and swapping 
 * it with the first unsorted element. This process continues until the entire array is sorted. 
 * 
 * Steps to follow:
 * 1. Find the smallest/largest element in the unsorted array and swap it with the first element of the array.
 * 2. Find the smallest/largest among the remaining elements and swap with the second element.
 * 3. repeat the process until the entire array is sorted.
 * 
 * Time Complexity: O(n^2) as there are 2 nested loops.
 * Space Complexity: O(1) as the only extra memory used is for temp variables.
 * 
 * Advantages:
 *  - Simple to understand and implement.
 *  - Requires only a constant O(1) extra memory space.
 *  - Less number of swaps (memory writes) compared to other standard algorithms.
 * 
 * Disadvantages:
 *  - Inefficient on large lists as its time complexity is O(n^2).
 *  - Not a stable sort, meaning that it does not preserve the relative order of equal elements.
*/
import java.util.Arrays;

class SelectionSort{

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sortAscending(int[] arr){
        int startIndex = 0;
        do{
            int minIndex = startIndex+1;
           
            //check for minimum
            for(int i = startIndex; i < arr.length; i++){
                if(arr[minIndex] > arr[i]){
                    minIndex = i;
                }
            }

            //perform swap
            swap(arr, startIndex, minIndex);
            startIndex++;

        }while(startIndex < arr.length - 1);      
    }

    public static void sortDescending(int[] arr){
        int startIndex = 0;
        do{
            int maxIndex = startIndex+1;

            //check for maximum
            for(int i = startIndex; i < arr.length; i++){
                if(arr[i] > arr[maxIndex]){
                    maxIndex = i;
                }   
            }

            //perform swap
            swap(arr, startIndex, maxIndex);
            startIndex++;

        }while(startIndex < arr.length-1);
    }

    public static void sort(int[] arr, boolean ascending){
        if(ascending){
            sortAscending(arr);
        }else{
            sortDescending(arr);
        }
    }

    public static void main(String[] args){
        int[] arr = {64, 25, 12, 22, 11};
        sort(arr, false);
        IO.println("Sorted array in Descending Order:\t"+ Arrays.toString(arr));
        sort(arr, true);
        IO.println("Sorted array in Ascending Order:\t" + Arrays.toString(arr));
    }
}