package com.rdstew.lox;

import java.util.Map;
import java.util.HashMap;

class Environment {
    // Enclosing is the enclosing scope of the current environemtn
    // Similar concept to Python __mro__ (Except reassignment doesn't seem fun).
    final Environment enclosing;
    private final Map<String, Object> values = new HashMap<>();

    Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    void define(String name, Object value) {
        values.put(name, value);
    }

    Environment ancestor(int distance) {
        Environment env = this;
        for (int i = 0; i < distance; i++) {
            env = env.enclosing;
        }
        return env;
    }

    Object getAt(int distance, String name) {
        return ancestor(distance).values.get(name);
    }

    void assignAt(int distance, Token name, Object value) {
        ancestor(distance).values.put(name.lexeme, value);
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        } else if (enclosing != null) {
            return enclosing.get(name);
        }

        throw new RuntimeError(name, "GET Undefined variable '" + name.lexeme + "'.");
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        } else if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }
        throw new RuntimeError(name, "ASSIGN Undefined variable: '" + name.lexeme + "'.");

    }
}
