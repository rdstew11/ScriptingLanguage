CC=gcc
CFLAGS=-I.

ODIR=obj
LIBS=

DEPS = chunk.h common.h memory.h debug.h value.h vm.h
OBJ = main.o memory.o chunk.o debug.o value.o vm.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

lox: $(OBJ)
	$(CC) -o lox $(OBJ) $(CFLAGS)

clean:
	rm *.o
