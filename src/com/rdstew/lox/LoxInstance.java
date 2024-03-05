package com.rdstew.lox;

import java.util.HashMap;
import java.util.Map;

class LoxInstance {
    private LoxClass lxClass;
    private final Map<String, Object> fields = new HashMap<>();

    LoxInstance(LoxClass lxClass) {
        this.lxClass = lxClass;
    }

    Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        LoxFunction method = lxClass.findMethod(name.lexeme);
        if (method != null) {
            return method;
        }

        throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
    }

    void set(Token name, Object value) {
        fields.put(name.lexeme, value);
    }

    @Override
    public String toString() {
        return lxClass.name + " instance";
    }
}
