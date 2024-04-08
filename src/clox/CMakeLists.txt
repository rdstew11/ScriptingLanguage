cmake_minimum_required(VERSION 3.27)
project(lox)
set(CMAKE_CXX_STANDARD 17)
set(INCLUDE_DIRECTORY "./include")

add_executable(lox src/main.c
        src/chunk.c
        src/compiler.c
        src/debug.c
        src/memory.c
        src/object.c
        src/scanner.c
        src/table.c
        src/value.c
        src/vm.c
        include/chunk.h
        include/common.h
        include/compiler.h
        include/debug.h
        include/memory.h
        include/object.h
        include/scanner.h
        include/table.h
        include/value.h
        include/vm.h
)

target_include_directories(lox PRIVATE ./include)
include_directories(./include)
