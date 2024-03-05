package com.rdstew.lox;

import java.util.List;

class LoxFunction implements LoxCallable {
    private final Stmt.Function declaration;
    private final Environment closure;
    private final boolean isInitializer;

    LoxFunction(Stmt.Function decalaration, Environment closure, boolean isInitializer) {
        this.declaration = decalaration;
        this.closure = closure;
        this.isInitializer = isInitializer;
    }

    LoxFunction bind(LoxInstance instance) {
        Environment env = new Environment(closure);
        env.define("this", instance);
        return new LoxFunction(declaration, env, isInitializer);
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        // Create function scope and execute body
        Environment env = new Environment(closure);
        for (int i = 0; i < declaration.params.size(); i++) {
            env.define(declaration.params.get(i).lexeme, arguments.get(i));
        }
        try {
            interpreter.executeBlock(declaration.body, env);
        } catch (Return returnValue) {
            if (isInitializer) {
                return closure.getAt(0, "this");
            }
            return returnValue.value;
        }

        if (isInitializer) {
            return closure.getAt(0, "this");
        }

        return null;
    }

    @Override
    public int arity() {
        return declaration.params.size();
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }
}
