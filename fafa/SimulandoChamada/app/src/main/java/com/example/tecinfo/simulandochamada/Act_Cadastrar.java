package com.example.tecinfo.simulandochamada;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Act_Cadastrar extends AppCompatActivity {

    SharedPreferences meusdados;
    public static final String mypreference = "call";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__cadastrar);

        meusdados = getSharedPreferences(mypreference, Context.MODE_PRIVATE);


        final EditText cad_email = findViewById(R.id.edi_Email);
        final EditText cad_senha = findViewById(R.id.edi_Senha);
        final EditText cad_confirmar = findViewById(R.id.edi_confirmar_senha);
        Button btn_confirmar = findViewById(R.id.btn_Confirmar);

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cad_senha.getText().toString().equals(cad_confirmar.getText().toString())) {

                    SharedPreferences.Editor editor = meusdados.edit();
                    editor.putString("email", cad_email.getText().toString());
                    editor.putString("senha", cad_senha.getText().toString());

                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Dados Salvos ", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "As senhas não são iguais", Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}
