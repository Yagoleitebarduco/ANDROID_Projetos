package com.yagoleitebarduco.projeto09;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editValor;
    private TextView txtPorcentagem, txtGorjeta, txtTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.edit_valorConta);
        txtPorcentagem = findViewById(R.id.txt_porcentagem);
        txtGorjeta = findViewById(R.id.txt_valorGorjeta);
        txtTotal = findViewById(R.id.txt_valorTotal);
        seekBarGorjeta = findViewById(R.id.seekBar_porcentagem);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                txtPorcentagem.setText(Math.round(porcentagem) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                caucular();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void caucular() {
        String valorRecuperado = editValor.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um Valor Primeiro",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            double valorDigitada = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitada * (porcentagem/ 100);
            double total = gorjeta + valorDigitada;

            txtGorjeta.setText("R$ " + Math.round(gorjeta));
            txtTotal.setText("R$ " + String.format("%.2f", total));
        }
    }
}