package com.yagoleitebarduco.projeto08;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edit_precoAlcool, edit_precoGasolina;
    private TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edit_precoAlcool = findViewById(R.id.txt_precoAlcool);
        edit_precoGasolina = findViewById(R.id.txt_precoGasolina);
        txt_resultado = findViewById(R.id.txt_result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void caucularPreco (View view) {
        String precoAlccol = edit_precoAlcool.getText().toString();
        String precoGasolina = edit_precoGasolina.getText().toString();

        Boolean camposValidados = validarCampos(precoAlccol, precoGasolina);

        if (camposValidados) {
            double valorAlcool = Double.parseDouble(precoAlccol);
            double valorGasolina = Double.parseDouble(precoGasolina);

            double resultado = valorAlcool/valorGasolina;

            if(resultado >= 0.7){
                txt_resultado.setText("Melhor Utilizar Gasolina");
            } else  {
                txt_resultado.setText("Melhor Usar Alcool");
            }
        } else {
            txt_resultado.setText("Prencha os Campos Primeiro");
        }
    }

    public Boolean validarCampos (String pAlcool, String pGasolina) {
        boolean camposValidados = true; //Campos Verdadeiros

        if (pAlcool == null ||pAlcool.equals("")){
            camposValidados = false;

        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}