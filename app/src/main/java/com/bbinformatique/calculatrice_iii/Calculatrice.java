package com.bbinformatique.calculatrice_iii;

import android.util.Log;

/**
 * Classe qui réalise les calcules de la calculatrice
 */
public class Calculatrice {
    private Operator operator;
    private State state = State.OPERAND_1;
    private double result;
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
                Log.i(this.getClass().getName(), "Entree est potentiellement un chiffre : " + text);
                try{
                    this.entreeChiffre(Integer.parseInt(text));
                }catch (NumberFormatException ignore) {
                    // Faire quelque chose
                }
                
        }
    }

    /**
     * Entrée d'un opérateur
     * @param operator Operator
     */
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

    /**
     * Résolution du calcul
     */
    private void resoudre() {
        switch (this.operator){
            case ADD:
                this.result = this.operand_1 + this.operand_2;
                break;
            case SUB:
                this.result = this.operand_1 - this.operand_2;
                break;
            case MUL:
                this.result = this.operand_1 * this.operand_2;
                break;
            case DIV:
                // Traiter la division par 0
                if (this.operand_2 == 0){
                    this.state = State.ERROR;
                    return;
                }
                else {
                    this.result = this.operand_1 / this.operand_2;
                }
                break;
            default:
                break;
        }
    }

    private void entreeChiffre(int parseInt){
        Log.i(this.getClass().getName(), "Chiffre : " + parseInt);
        Log.i(this.getClass().getName(), "state : " + this.state.toString());
        switch (this.state){
            case RESULT:
                break;
            case ERROR:
                this.resset();
                break;
            case OPERAND_1:
                this.operand_1 = entreeChiffreOperande(this.operand_1, parseInt);
                break;
            case OPERAND_2:
                this.operand_2 = entreeChiffreOperande(this.operand_2, parseInt);

                break;
            case OPERATOR:
                this.state = State.OPERAND_2;
                break;

        }
    }

    private double entreeChiffreOperande(double operand, int parseInt) {
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
