package com.bbinformatique.calculatrice_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Classe entrée du programme
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Calcul pour la Calculatrice
     */
    private Calculattrice_II calculator;

    /**
     * Affichage sur la calculatrice
     */
    private TextView display;

    /**
     * A la création de l'activité
     * @param savedInstanceState Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.calculator = new Calculattrice_II();
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getName(), "Lancement de l'activité");
    }

    /**
     * Au Click sur un boutton de la calculatrice
     * @param v View
     */
    public void onClick(View v){
        Button button = (Button) v;
        Log.i(this.getClass().getName(), "Pressed = " + button.getText());
        this.calculator.touchePressee((String)button.getText());
        Log.i(this.getClass().getName(), "input = " + button.getText());
        display = findViewById(R.id.textView);
        display.setText(calculator.getValeurAffichee());
    }
}