#include "vm.h"

#include <stdio.h>

#include "common.h"
#include "debug.h"

// TODO remove this global and instead pass around a pointer
VM vm;

static void resetStack() { vm.stackTop = vm.stack; }

void initVM() { resetStack(); }
void freeVM() {}

void push(Value value) {
    *vm.stackTop = value;
    vm.stackTop++;
}

Value pop() {
    vm.stackTop--;
    return *vm.stackTop;
}

static InterpretResult run() {
    /**
     * Stack Based VM
     *
     * Read into register based VMs
     *
     * The main difference is that instructions can read their
     * inputs from anywhere in the stack and can store their
     * outputs into specific stack slots.
     *
     * See: https://www.lua.org/doc/jucs05.pdf
     *
     */
#define READ_BYTE() (*vm.ip++)
#define READ_CONSTANT() (vm.chunk->constants.values[READ_BYTE()])
#define BINARY_OP(op)     \
    do {                  \
        double b = pop(); \
        double a = pop(); \
        push(a op b);     \
    } while (false)

    // Some noted techniques that could be useful:
    // direct threaded code, jump table, computed goto
    for (;;) {
#ifdef DEBUG_TRACE_EXECUTION
        printf("        ");
        for (Value* slot = vm.stack; slot < vm.stackTop; slot++) {
            printf("[");
            printValue(*slot);
            printf("]");
        }
        disassembleInstr(vm.chunk, (int)(vm.ip - vm.chunk->code));
#endif

        uint8_t instr;
        switch (instr = READ_BYTE()) {
            case OP_CONSTANT: {
                Value constant = READ_CONSTANT();
                push(constant);
                printf("\n");
                break;
            }
            case OP_NEGATE:
                push(-pop());
                break;
            case OP_ADD:
                BINARY_OP(+);
                break;
            case OP_SUBTRACT:
                BINARY_OP(-);
                break;
            case OP_MULTIPLY:
                BINARY_OP(*);
                break;
            case OP_DIVIDE:
                BINARY_OP(/);
                break;
            case OP_RETURN: {
                printValue(pop());
                printf("\n");
                return INTERPRET_OK;
            }
        }
    }

#undef READ_BYTE
#undef READ_CONSTANT
#undef BINARY_OP
}

InterpretResult interpret(const char* source) {
    Chunk chunk;
    initChunk(&chunk);

    if (!compile(source, &chunk)) {
        printf("Compile failed.");
        freeChunk(&chunk);
        return INTERPRET_COMPILE_ERROR;
    }

    vm.chunk = &chunk;
    vm.ip = vm.chunk->code;

    InterpretResult result = run();
    freeChunk(&chunk);
    return result;
}