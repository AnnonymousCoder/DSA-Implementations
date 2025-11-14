#ifndef HELPER_DSA
#define HELPER_DSA

#include <stdio.h>

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

#endif