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

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        } else if (enclosing != null) {
            return enclosing.get(name);
        }

        throw new RuntimeError(name, "Undefined varaible '" + name.lexeme + "'.");
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
        } else if (enclosing != null) {
            enclosing.assign(name, value);
        }

        throw new RuntimeError(name, "Undefined variable: '" + name.lexeme + "'.");

    }
}
