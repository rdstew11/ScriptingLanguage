package com.rdstew.lox;

import java.util.List;

abstract class Stmt {
    interface Visitor<R> {
        R visitExpresionStmt(Expresion stmt);
        R visitPrintStmt(Print stmt);
    }
    static class Expresion extends Stmt {
        Expresion(Expr expression) {
            this.expression = expression;
        }

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitExpresionStmt(this);
        }

        final Expr expression;
    }
    static class Print extends Stmt {
        Print(Expr expression) {
            this.expression = expression;
        }

        @Override
        <R> R accept(Visitor<R> visitor){
            return visitor.visitPrintStmt(this);
        }

        final Expr expression;
    }

    abstract <R> R accept(Visitor<R> visitor);
}
