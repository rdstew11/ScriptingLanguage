INC_DIR := include
SRC_DIR := src
OBJ_DIR := obj
BIN_DIR := .

EXE = $(BIN_DIR)/lox

SRC = $(wildcard $(SRC_DIR)/*.c)
OBJ = $(patsubst $(SRC_DIR)/%.c, $(OBJ_DIR)/%.o, $(SRC))

CC      := gcc
CFLAGS  := -I$(INC_DIR) -Wall
LDFLAGS := -Llib
LDLIBS  :=

all: $(EXE)

.phony: all

$(EXE): $(OBJ) | $(BIN_DIR)
	$(CC) $(LDFLAGS) $^ $(LDLIBS) -o $@

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c | $(SRC_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

$(BIN_DIR) $(OBJ_DIR):
	mkdir -p $@

clean:
	del $(OBJ_DIR)\*.o