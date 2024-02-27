package com.rdstew.lox;

import java.util.HashMap;
import java.util.Map;

class LoxInstance {
    private LoxClass lxClass;

    LoxInstance(LoxClass lxClass) {
        this.lxClass = lxClass;
    }

    @Override
    public String toString() {
        return lxClass.name + " instance";
    }
}
