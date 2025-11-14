package Java;

/*
 * Bubble Sort - works by repeatedly swapping the adjecent elements if they are in wrong order.
 * Steps to follow:
 *  1. Traverse the array while swapping the current and adjacent index values if the current element is larger than the adjacent.
 *     After the first Pass the largest element should be at index N-1. 
 *  2. Repeat step 1 excluding the N-num of passes index.    
 *  
 */

 import java.util.Arrays;

class BubbleSort{
    private static void swap(int[] arr, int curr , int nxt){
        int temp = arr[curr];
        arr[curr] = arr[nxt];
        arr[nxt] = temp;
    }

    private static void bubbleSortAscending(int[] arr){
        boolean swapped = false;
        while(!swapped){
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                    swapped = true;
                }
            }
            if(swapped){swapped = false;}else{swapped = true;}
        }
    }

    private static void bubbleSortDescending(int[] arr){
        boolean swapped = false;
        while(!swapped){
            for(int i = arr.length-1; i > 0; i--){
                if(arr[i] > arr[i-1]){
                    swap(arr, i, i-1);
                    swapped = true;
                }
            }
            if(swapped){swapped = false;}else{swapped = true;}
        }
    }

    public static void bubbleSort(int[] arr, boolean isAscending){
        if(isAscending){
            bubbleSortAscending(arr);
        }else{
            bubbleSortDescending(arr);
        }
    }

    public static void bubbleSort(int[] arr){
        bubbleSort(arr, true);
    }

    public static void main(String[] args){
        int num[] = {7, 5, 4, 6, 19, 3, 6, 7 , 29};

        bubbleSort(num); //Ascending Order
        IO.println(Arrays.toString(num));
        
        bubbleSort(num, false);
        IO.println(Arrays.toString(num));
    }
}