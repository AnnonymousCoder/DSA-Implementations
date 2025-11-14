/*
 * Bubble Sort - works by repeatedly swapping the adjecent elements if they are in wrong order.
 * Steps to follow:
 *  1. Traverse the array while swapping the current and adjacent index values if the current element is larger than the adjacent.
 *     After the first Pass the largest element should be at index N-1. 
 *  2. Repeat step 1 excluding the N-num of passes index.    
 *  
 * Time Complexity:  O(N^2)
 * Space Complexity: O(1)
 *
 * Advantages:
 *  - Simple to implement and understand.
 *  - In-place sorting algorithm (requires only a constant amount of additional memory space).
 *  - Stable sorting algorithm (maintains the relative order of equal elements).
 * 
 * Disadvantages:
 * - Inefficient for large datasets compared to more advanced algorithms like Quick Sort or Merge Sort.
 * - Performs poorly on average and in the worst-case scenarios.
 */

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <time.h>

#include "helper_functions.h"

#define COUNT 10

int swap(int *arr, int curr, int nxt){
    if(arr == NULL) {return -1;}
    int temp  = arr[curr];
    arr[curr] = arr[nxt];
    arr[nxt]  = temp;
    return 0;
}

int bubble_sort_ascending(int *arr, int count){
    if(arr == NULL){return -1;}
    if(count <=  0){return -2;}

    bool swapped = false;
    while(!swapped){
        for(int i = 0; i < count-1; i++){
            if(arr[i] > arr[i+1]){
                swap(arr, i, i+1);
                swapped = true;
            }
        }
        if(swapped){swapped = false;}else{swapped = true;}
    }
    return 0;
}

int bubble_sort_descending(int *arr, int count){
    if(arr == NULL){return -1;}
    if(count <= 0){return -2;}

    bool swapped = false;
    while(!swapped){
        for(int i = count-1; i > 0; i--){
            if(arr[i] > arr[i-1]){
                swap(arr, i, i-1);
                swapped = true;
            }
        }
        if(swapped){swapped = false;}else{swapped = true;}
    }
    return 0;
}

int bubble_sort(int *arr, int count, bool isAscending){
    if(isAscending){
        return bubble_sort_ascending(arr, count);
    }
    return bubble_sort_descending(arr, count);
}

int main(void){
    int arr[COUNT] = {0};
    
    srand(time(NULL));

    for(int i = 0; i < COUNT; i++){
        arr[i] = rand() % 30;
    }

    array_pretty_print(arr, COUNT); //Unsorted Array.

    bubble_sort(arr, COUNT, true);
    array_pretty_print(arr, COUNT); //Ascending Order.

    bubble_sort(arr, COUNT, false);
    array_pretty_print(arr, COUNT); //DescendingOrder.
    return 0;
}