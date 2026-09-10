package com.example.parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtPassword;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtPassword = findViewById(R.id.edtPassword);

        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        });
    }

    private void validarLogin() {

        String usuario = edtUsuario.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (usuario.isEmpty() || password.isEmpty()) {

            Toast.makeText(
                    MainActivity.this, "Por favor llenar los campos", Toast.LENGTH_SHORT
            ).show();

            return;
        }

        if (usuario.equals("uac123") && password.equals("12345678")) {

            Intent intent = new Intent(MainActivity.this,
                    ResultadoActivity.class
            );

            startActivity(intent);

        } else {

            Toast.makeText(
                    MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT
            ).show();
        }
    }
}