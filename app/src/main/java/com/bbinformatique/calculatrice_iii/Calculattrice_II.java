package com.bbinformatique.calculatrice_iii;

import android.util.Log;

public class Calculattrice_II {

    /**
     * Les états de la calculatrice
     */
    enum Etat {
        AVANT_ZERO,
        A_ZERO,
        ACQ_NB1,
        ACQ_NB2,
        RESULTAT,
        ERREUR
    }

    /**
     * Etat courant
     */
    private Etat etat;
    /**
     * Valeur affichée
     */
    private String affichage;
    /**
     * Valeur nombre 1
     */
    private double nb1;
    /**
     * Valeur nombre 2
     */
    private int nb2;
    /**
     * Valeur de l'opérateur
     */
    private String operator;
    /**
     * Résultat du calcul
     */
    private double result;

    public Calculattrice_II(){
        traitement_raz();
    }


    public String getValeurAffichee(){
        return affichage;
    }
    /**
     * Remise A zéro de la calculatrice
     */
    private void traitement_raz(){
        etat = Etat.A_ZERO;
        affichage = "0";
        nb1 = 0;
        nb2 = 0;
    }

    public void touchePressee(String car){
        try {
            if("+-*/".contains(car)){
                // operateur
                traitementOperateur(car);
            } else if("RAZ".equals(car)){
                traitement_raz();
            }else if("1234567890".contains(car)){
                // chiffre
                traitementChiffre(car);
            } else {
                // ignorer
            }
        } catch (Exception e) {
            e.printStackTrace();
            etat = Etat.ERREUR;
        } finally {
            Log.i("Calculatrice : ", "nb1 = " + nb1 + " nb2 = " + nb2 + " operator = " + operator + " result = " + result);
        }
    }

    public void traitementOperateur(String operateur){
        switch (etat) {
            case A_ZERO:
                nb1 = 0;
                operator = operateur;
                etat = Etat.ACQ_NB2;
                break;
            case ACQ_NB1:
                if("=".equals(operateur)){
                    nb1 = 0;
                }else{
                    operator = operateur;
                    nb2 = 0;
                    etat = Etat.ACQ_NB2;
                }
                break;
            case ACQ_NB2:
                result = calcul();
                affichage = "" + result;
                etat = Etat.RESULTAT;
                break;
            case RESULTAT:
                nb1 = Double.parseDouble(String.valueOf(result));
                etat = Etat.ACQ_NB2;

                break;
            default:
                break;
        }
    }

    public void traitementChiffre(String chiffre){
        switch (etat){
            case A_ZERO:
                nb1 = acquisitionNombre((int) nb1, chiffre);
                affichage = "" + nb1;
                etat = Etat.ACQ_NB1;
                break;
            case ACQ_NB1:
                nb1 = acquisitionNombre((int) nb1, chiffre);
                affichage = "" + nb1;
                break;
            case ACQ_NB2:
                nb1 = acquisitionNombre(nb2, chiffre);
                affichage = "" + nb2;
                break;
            case RESULTAT:
                nb1 = 0;
                etat = Etat.ACQ_NB1;
                break;
            default:
                break;
        }
    }

    private int acquisitionNombre(int nombre, String car){
        String stringNombre = "" + nombre + car;
        return (int) Double.parseDouble(stringNombre);
    }

    private double calcul(){
        switch (operator){
            case "+":
                return nb1 + nb2;
            case "-":
                return nb1 - nb2;
            case "*":
                return nb1 * nb2;
            case "/":
                return nb1 / nb2;
            default:
                return 0;
        }
    }
}
