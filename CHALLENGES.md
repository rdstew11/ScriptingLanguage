# Overview
At the end of chapter, Nystrom provides some extra challenges to explore. I will be keeping a record of them here, as well as any progress I may have made.

# 4. Scanning
- The lexical grammars of Python and Haskell are not regular. What does that mean, and why aren't they?
- Aside from seperating tokens - distringuishing `print foo` from `printfoo` - spaces aren't used for much in most languages. However, in a couple of dark corners, a space does affect how a code is parsed in CoffeeScript, Ruby, and the C preprocessor. Where and what effect does it have in each of those languages?
- Our scanner here, like most, discards comments and whitespaces since those aren't needed by the parser. Why might you want to write a scanner that does not discard those? What would it be useful for?
- Add support to Lox's scanner for C-style /\* ... /\* block comments. Make sure to handle newlines in them. Consider allowing them to nest. Is adding support for nesting more work than you expected? Why?
    - Added support for C-style block comments. Have not added nesting support.