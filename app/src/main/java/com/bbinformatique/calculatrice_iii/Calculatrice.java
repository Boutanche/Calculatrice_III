package com.bbinformatique.calculatrice_iii;

/**
 * Classe qui réalise les calcules de la calculatrice
 */
public class Calculatrice {
    private Operator operator;
    private State state;
    private Integer result;
    private double operand_1;
    private double operand_2;

    /**
     * Données en entrée
     * @param text String
     */
    public void input(String text) {
        switch (text){
            case "RAZ":
                this.resset();
                break;
            case "+":
                this.entreeOperator(Operator.ADD);
                break;
            case "-":
                this.entreeOperator(Operator.SUB);
                break;
            case "*":
                this.entreeOperator(Operator.MUL);
                break;
            case "/":
                this.entreeOperator(Operator.DIV);
                break;
            case "=":
                this.resoudre();
                break;
            default:
                try{
                    this.entreeChiffre(Integer.parseInt(text));
                }catch (NumberFormatException ignore){
                }
                
        }
    }

    private void entreeChiffre(int parseInt) {
    }

    private void entreeOperator(Operator operator){
        switch (this.state){
            case OPERAND_2:
                this.resoudre();
                break;
            case OPERAND_1:
                this.operator = operator;
                this.state = State.OPERATOR;
                break;
            case RESULT:
                this.operand_1 = this.result;
                this.operand_2 = 0;
                this.result = 0;
                break;
            case OPERATOR:
                // Change operator
                break;
            case ERROR:
                // Ne rien faire
                break;
            default:
                break;
        }

    }

    private void resoudre() {
    }

    private double entreeChiffre(double operand, int parseInt) {
        if (operand != 0){
            operand*=10;
        }
        operand += parseInt;
        return operand;
    }

    private void resset() {
        this.state = State.OPERAND_1;
        this.result = 0;
        this.operand_1 = 0;
        this.operand_2 = 0;
        this.operator = null;
    }

    /**
     * Affichage en sortie
     * @return
     */
    public String display() {
        String zero = "0";
        return zero;
    }

    /**
     * Enumération des états possibles
     */
    private enum State {
        OPERAND_1,
        OPERAND_2,
        OPERATOR,
        RESULT,
        ERROR
    }

    /**
     * Enumération des oppérateurs possibles
     */
    private enum Operator {
        ADD,
        SUB,
        MUL,
        DIV
    }
}
