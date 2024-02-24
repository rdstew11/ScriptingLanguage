package com.rdstew.lox;

class Return extends RuntimeException {
    final Object value;

    Return(Object value) {
        // Disable some JVM machinery we do not need
        super(null, null, false, false);
        this.value = value;
    }
}
