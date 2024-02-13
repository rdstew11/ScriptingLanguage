# [02/10/24]
## Added
- Created Expr classes
    - Implemented Visitor pattern for Expr subclasses
        - Visitor Interface for handling visitor objects to each Expr subclass
            - `Visitor.visitBinaryExpr()`
            - `Visitor.visitGroupingExpr()`
            - `Visitor.visitLiteralExpr()`
            - `Visitor.visitUnaryExpr()`
        - Added `Expr.accept()` override function to each Expr subclass to call their specific visitor function
        - This pattern approximates a functional style programming within OOP, making it easier to create new functions for the Expr subclasses. Conversely, it makes it more difficult to add a new Expr subclass.
            - For more explanation, see `5.3.2 The Visitor Pattern`
    - Current class structure:
        - Grouping class
            - Expression
        - Literal class
            - Value
        - Unary class
            - Operator Token
            - Right Expression
        - Binary class
            - Left Expression
            - Operator Token
            - Right Expression
    - Generated using `com.rdstew.tool.GenerateAST` for quickly generating the `Expr.java` file with defined subclasses.
        

- Created AstPrinter class for printing out ASTs in a more readable form
    - Utilizes Visitor pattern to recursively generate strings out of nested Expr objects.


# [02/10/24] 
## C/C++ Setup
- Installed MSYS2 to `\opt\`
- MSYS2 command to instal mingw lib: `pacman -S --needed base-devel mingw-w64-ucrt-x86_64-toolchain`
- Added `\MSYS2\ucrt64\bin` to PATH

## Java Lox
- Completed Scanner implementation
    - Added minimum required token types
    - Multiline comments are allowed
    - Multicharacter parsing for !, =, /, <, >
    - Identifier parsing
    - Added block comment parsing
    - Alphanumeric Character check based on char value
    
