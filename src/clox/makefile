CC=gcc
CFLAGS=-I.

ODIR=obj
LIBS=

DEPS = chunk.h common.h memory.h debug.h
OBJ = main.o memory.o chunk.o debug.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

lox: $(OBJ)
	$(CC) -o lox $(OBJ) $(CFLAGS)

clean:
	rm *.o
