CC=gcc

INC_DIR=include/
CFLAGS=-I$(INC_DIR)

ODIR=obj
LIBS=

DEPS = chunk.h common.h memory.h debug.h value.h vm.h scanner.h compiler.h object.h table.h
OBJ = main.o memory.o chunk.o debug.o value.o vm.o scanner.o compiler.o object.o table.c

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

all: $(OBJ)
	$(CC) -o lox $(OBJ) $(CFLAGS)

clean:
	del *.o
