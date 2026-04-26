package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numero;
    TextView resultado, suma;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.numero);
        resultado = findViewById(R.id.resultado);
        suma = findViewById(R.id.suma);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> calcularSerie());
    }

    private void calcularSerie() {
        String input = numero.getText().toString();

        if (input.isEmpty()) {
            Toast.makeText(this, "Ingrese un valor", Toast.LENGTH_SHORT).show();
            return;
        }

        int n;
        try {
            n = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Solo números válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (n <= 0) {
            Toast.makeText(this, "n debe ser mayor a 0", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder serie = new StringBuilder();
        double sumaTotal = 0;

        double impar = 1;
        double par = -2.5;

        double incImpar = 4;
        double incPar = -6;

        for (int i = 1; i <= n; i++) {
            double valor;

            if (i % 2 == 1) { // impar
                valor = impar;
                impar += incImpar;
                incImpar += 4;
            } else { // par
                valor = par;
                par += incPar;
                incPar -= 4;
            }

            serie.append(valor);
            if (i < n) serie.append(", ");

            sumaTotal += valor;
        }

        resultado.setText(serie.toString());
        suma.setText(String.valueOf(sumaTotal));
    }
}