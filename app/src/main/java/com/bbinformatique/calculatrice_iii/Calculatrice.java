package com.bbinformatique.calculatrice_iii;

public class Calculatrice {
    public void input(String text) {
    }

    public String display() {
        String zero = "0";
        return zero;
    }
    private enum State {
        OPERAND_1,
        OPERAND_2,
        OPERATOR,
        RESULT,
        ERROR
    }
    private enum Operator {
        ADD,
        SUB,
        MUL,
        DIV
    }
}
