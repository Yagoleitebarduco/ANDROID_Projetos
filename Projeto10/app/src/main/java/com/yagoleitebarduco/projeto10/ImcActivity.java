package com.yagoleitebarduco.projeto10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class ImcActivity extends AppCompatActivity {

    private TextInputEditText editPeso, editAltura;
    private Button btnCalc, btnLimp;
    double imc, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);

        // TextInputLayout
        editPeso = findViewById(R.id.edit_Peso);
        editAltura = findViewById(R.id.edit_Altura);

        // Botões
        btnCalc = findViewById(R.id.btn_calcImc);
        btnLimp = findViewById(R.id.btn_limpar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcImc(View view) {
        peso = (Double.parseDouble(editPeso.getText().toString()));
        altura = (Double.parseDouble(editAltura.getText().toString()));

        altura = altura / 100;

        imc = peso / (altura * altura);

        if (imc < 17) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Muito Abaixo do Peso!");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        } else if (imc >= 17 && imc < 18.5) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Abaixo do Peso!");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        } else if (imc >= 18.5 && imc< 25) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Peso Normal!");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        } else if (imc >= 25 && imc < 30){
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Acima do Peso!");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        } else if (imc >= 30 && imc < 35) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Obesida I");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        } else if (imc >= 35 && imc <40) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Obesidade II - Severa!");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        } else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(this);

            alerta.setTitle("Calculadora IMC");
            alerta.setMessage("Seu IMC e de " + imc + " - Obesidade II - Morbido!");
            alerta.setNeutralButton("CONFIRMAR", null);

            alerta.create();
            alerta.show();
        }
    }

    public void limpar(View view) {
        editPeso.setText("");
        editAltura.setText("");

        peso = 0;
        altura = 0;
        imc = 0;
    }
}