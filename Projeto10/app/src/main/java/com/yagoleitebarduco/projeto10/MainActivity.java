package com.yagoleitebarduco.projeto10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView btnTelaImc, btnTelaCalcGas, btnTelaCalc, btnOutros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnTelaImc = findViewById(R.id.app_imc);
        btnTelaCalcGas = findViewById(R.id.app_calcaGasolina);
        btnTelaCalc = findViewById(R.id.app_Calculadora);
        btnOutros = findViewById(R.id.app_Outros);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void abrirAppImc (View view) {
        Intent telaImc = new Intent(MainActivity.this, ImcActivity.class);
        startActivity(telaImc);
    }
}