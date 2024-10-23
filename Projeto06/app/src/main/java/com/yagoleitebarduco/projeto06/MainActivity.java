package com.yagoleitebarduco.projeto06;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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

    String[] frases = {
            "A jornada pode ser longa, mas cada passo é um avanço em direção aos seus sonhos.",
            "A força não vem de vencer sempre, mas de levantar-se toda vez que cair.",
            "Acredite em você e faça do seu esforço a ponte entre o sonho e a realidade.",
            "Beba Agua!!"
    };

    public void gerarFrase (View view) {
        TextView texto = findViewById(R.id.txt_result);
        int nAleatorio = new Random().nextInt(4);

        String frase = frases[nAleatorio];

        texto.setText(frase);
    }

    public void exibirFrases (View view) {
        TextView texto = findViewById(R.id.txt_result);
        String txtresult = "";

        for (String frase : frases) {
            txtresult = txtresult + frase + "\n \n";
        }

        texto.setText(txtresult);
    }
}