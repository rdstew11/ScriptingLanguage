# Overview
This repository contains the C foundational work that has been done alongside my reading of
['Crafting Interpreters' by Robert Nystrom](https://craftinginterpreters.com/). 

I originally implemented this language structure in Java, which had the added benefits of leaning into JVM's garbage 
collector and class structure. This can be seen here: [rdstew11/Interpreter](https://github.com/rdstew11/Interpreter).

I am using this project as a playground to explore concepts related to the implementation of programming languages. This 
implementation is by no means a complete programming language. It's current state is the of an early scripting language.

# Implementation Details

This language has 3 parts in its execution pipeline:

- Scanner
- Compiler
- Virtual Machine

The Scanner converts source code into tokens which are passed to the Compiler to be processed into bytecode. The grammar
for this language only requires at max a single token lookahead, which allows the scanning to be done on demand by the 
Compiler as it needs new tokens. The compiler is a single-pass compiler implementing a Vaughan Pratt's top-down operating
precedence parsing algorithm, which is a specific implementation of a recursive decent parsing algorithm. For a detailed
explanation on this algorithm see: [Pratt Parsing Into](https://abarker.github.io/typped/pratt_parsing_intro.html).
