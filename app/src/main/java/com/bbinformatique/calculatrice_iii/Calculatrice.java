package com.bbinformatique.calculatrice_iii;

/**
 * Classe qui réalise les calcules de la calculatrice
 */
public class Calculatrice {
    private Operator operator;
    private State state;
    private Integer result;
    private Integer operand_1;
    private Integer operand_2;

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
    private void entreeOperator(Operator operator){

    }

    private void resoudre() {
    }

    private void entreeChiffre(int parseInt) {
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
