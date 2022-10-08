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
    private Calculatrice calculator;

    /**
     * Affichage sur la calculatrice
     */
    private TextView display;

    /**
     * A la création de l'activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.calculator = new Calculatrice();
        setContentView(R.layout.activity_main);
        this.display = findViewById(R.id.textView);
        Log.i(this.getClass().getName(), "Lancement de l'activité");
    }

    public void onClick(View v){
        Button button = (Button) v;
        Log.i(this.getClass().getName(), "Pressed = " + button.getText());
        this.calculator.input((String)button.getText());
        Log.i(this.getClass().getName(), this.calculator.toString());
        this.display.setText(this.calculator.display());
    }
}