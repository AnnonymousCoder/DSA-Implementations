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
#include<stdio.h>
#include<stdbool.h>

#define ARRAY_LENGTH 5

void swap(int* arr, int i, int j){
    if(arr == NULL){ return;}
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void selection_sort_ascending(int arr[ARRAY_LENGTH]){
    int start_index = 0;
    do{
        int min_index = start_index + 1;

        //check for minimum element
        for(int i = start_index; i < ARRAY_LENGTH; i++){
            if(arr[min_index] > arr[i]){
                min_index = i;
            }
        }

        //perform swap
        swap(arr, start_index, min_index);
        start_index++;

    }while(start_index < ARRAY_LENGTH - 1);
}

void selection_sort_descending(int arr[ARRAY_LENGTH]){
    int start_index = 0;
    do{
        int max_index = start_index + 1;

        //check for maximum element
        for(int i = start_index; i < ARRAY_LENGTH; i++){
            if(arr[i] > arr[max_index]){
                max_index = i;
            }
        }

        //perform swap
        swap(arr, start_index, max_index);
        start_index++;

    }while(start_index < ARRAY_LENGTH - 1);
}

void array_pretty_print(int* arr, size_t length){
    if(arr == NULL){ return; }
    if(length == 0){ return; }
    
    printf("[");
    for(size_t i = 0; i < length; i++){
        printf("%d", arr[i]);
        if(i < length-1){ printf(","); }
    }
    printf("]\n");
}

void selection_sort(int arr[ARRAY_LENGTH], bool ascending){
    if(ascending){
        selection_sort_ascending(arr);
    }else{
        selection_sort_descending(arr);
    }
}

int main(){
    int arr[ARRAY_LENGTH] = {64, 25, 12, 22, 11};

    selection_sort(arr, true);

    printf("Sorted array in ascending order:\t");
    array_pretty_print(arr, ARRAY_LENGTH);

    selection_sort(arr, false);
    printf("Sorted array in descending order:\t");
    array_pretty_print(arr, ARRAY_LENGTH);

    return 0;
}