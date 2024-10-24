package com.yagoleitebarduco.projeto07;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

    public void selecionarPedra(View view) {
        verificarGanhador("Pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    private String escolhaAleatoriaApp(){
        String[] opcoes = {
                "Pedra",
                "Papel",
                "Tesoura"
        };

        int numeroAleatorio = new Random().nextInt(3);

        ImageView image_app = findViewById(R.id.img_app);
        String escolhaApp = opcoes[numeroAleatorio];

        switch (escolhaApp) {
            case "Pedra":
                image_app.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                image_app.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                image_app.setImageResource(R.drawable.tesoura);
                break;
        };

        return escolhaApp;
    }


    public void verificarGanhador(String escolhaDoUsuario) {
        // Testar se o Botão esta Pegando --> System.out.println("Item Clicado: " + escolhaDoUsuario);

        String escolhaApp = escolhaAleatoriaApp();
        TextView txt_result = findViewById(R.id.txt_result);

        if ( //APP GANHAR
                (escolhaApp == "Pedra" && escolhaDoUsuario == "Tesoura") ||
                (escolhaApp == "Papel" && escolhaDoUsuario == "Pedra") ||
                (escolhaApp == "Tesoura" && escolhaDoUsuario == "Papel")) {

            txt_result.setText("Você Perdeu :(");
        } else if (//USUARIO GANHAR
                (escolhaApp == "Pedra" && escolhaDoUsuario == "Papel") ||
                (escolhaApp == "Papel" && escolhaDoUsuario == "Tesoura") ||
                (escolhaApp == "Tesoura" && escolhaDoUsuario == "Pedra")) {

            txt_result.setText("Você Ganhou :)");
        } else {
            // EMPATAE
            txt_result.setText("Você Empatou");
        }
    }
}