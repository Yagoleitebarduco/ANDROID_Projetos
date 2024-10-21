package com.cassiomacielgomes.projeto04;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final int NUMERO_MAXIMO = 60; //Variáveis Constantes
    private static final int QUANTIDADE_SORTEADA = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void sortearNumeros(View view) {
        // Criar um Array para armazenar numeros
        ArrayList<Integer> numeros = new ArrayList<>();

        // Integer =  wrapper
        //Adiciona Numeros de 1 a 60

        for(int i = 1; i <= NUMERO_MAXIMO; i++){
            numeros.add(i);
        }

        // Embaralhando os numeros
        Collections.shuffle(numeros);
        StringBuilder resultato = new StringBuilder("Números Sorteados: \n");

        // Pegar os Nmeos do Array;
        for(int i = 0; i < QUANTIDADE_SORTEADA; i++){
            resultato.append(numeros.get(i)).append(" ");
        }

        // Exibir o Resultado
        TextView resultadosTextView = findViewById(R.id.resultadoSorteio);
        resultadosTextView.setText(resultato.toString());
    }
}