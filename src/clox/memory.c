#include "memory.h"

#include <stdio.h>
#include <stdlib.h>

void *reallocate(void *pointer, size_t oldSize, size_t newSize) {
    if (newSize == 0) {
        free(pointer);
        return NULL;
    }
    void *result = realloc(pointer, newSize);
    if (result == NULL) {
        printf("(REALLOC failed) pointer: %p newsize: %d\n", pointer, newSize);
        exit(1);
    }
    return result;
}