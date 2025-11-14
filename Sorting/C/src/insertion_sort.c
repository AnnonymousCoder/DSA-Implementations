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

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include "helper_functions.h"

#define COUNT 10

void cmpAndShift(int *arr, int elem, int startIndex, int endIndex){
    if(arr == NULL || startIndex == endIndex){return;}

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

void insertion_sort_descending(int *arr, int count){
    if(arr == NULL || count < 2){ return; }

    if(arr[count-1] > arr[count-2]){
        int temp = arr[count-1];
        arr[count-1] = arr[count-2];
        arr[count-2] = temp;
    }

    for(int i = count-2; i > 0; i--){
        if(arr[i] > arr[i-1]){
            cmpAndShift(arr, arr[i-1], count-1, i-1);
        }
    }
}
void insertion_sort_ascending(int *arr, int count){
    if(arr == NULL || count < 2){ return; }

    if(arr[0] > arr[1]){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    for(int i = 1; i < count-1; i++){
        if(arr[i] > arr[i+1]){
            cmpAndShift(arr, arr[i+1], 0, i+1);
        }
    }
}

void insertion_sort(int *arr, int count, bool isAscending){
    if(arr == NULL || count <= 0){return;}

    if(isAscending){
        insertion_sort_ascending(arr, count);
    }else{
        insertion_sort_descending(arr, count);
    }
}
int main(void){
    
    int arr[COUNT];

    srand(time(NULL));
    for(int i = 0; i < COUNT; i++){
        arr[i] = rand() % 30;
    }
    
    array_pretty_print(arr, COUNT); //Unsorted Array

    insertion_sort(arr, COUNT, true); //Ascending Order
    array_pretty_print(arr, COUNT);

    insertion_sort(arr, COUNT, false); //Descending Order
    array_pretty_print(arr, COUNT);

    return 0;
}