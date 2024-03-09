#include "chunk.h"
#include "common.h"
#include "debug.h"
#include "vm.h"

int main_1(int argc, const char *arg[]) {
    initVM();
    /*
        1 + 2 * 3 - 4 / -5
    */

    Chunk chunk;
    initChunk(&chunk);
    int constant = addConstant(&chunk, 2);
    writeChunk(&chunk, OP_CONSTANT, 123);
    writeChunk(&chunk, constant, 123);

    constant = addConstant(&chunk, 3);
    writeChunk(&chunk, OP_CONSTANT, 123);
    writeChunk(&chunk, constant, 123);

    writeChunk(&chunk, OP_MULTIPLY, 123);

    constant = addConstant(&chunk, 1);
    writeChunk(&chunk, OP_CONSTANT, 123);
    writeChunk(&chunk, constant, 123);

    writeChunk(&chunk, OP_ADD, 123);

    constant = addConstant(&chunk, 4);
    writeChunk(&chunk, OP_CONSTANT, 123);
    writeChunk(&chunk, constant, 123);

    constant = addConstant(&chunk, 5);
    writeChunk(&chunk, OP_CONSTANT, 123);
    writeChunk(&chunk, constant, 123);

    writeChunk(&chunk, OP_NEGATE, 123);

    writeChunk(&chunk, OP_DIVIDE, 123);

    writeChunk(&chunk, OP_SUBTRACT, 123);

    writeChunk(&chunk, OP_RETURN, 123);

    interpret(&chunk);
    freeVM();
    freeChunk(&chunk);
    return 0;
}