CC=gcc
CFLAGS=-I.

ODIR=obj
LIBS=

DEPS = chunk.h common.h memory.h debug.h value.h vm.h scanner.h compiler.h
OBJ = main.o memory.o chunk.o debug.o value.o vm.o scanner.o compiler.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

lox: $(OBJ)
	$(CC) -o lox $(OBJ) $(CFLAGS)

clean:
	del *.o
