package com.gerciadev.cumbu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.gerciadev.cumbu.R;

public class CadastroActivity extends AppCompatActivity {
    private EditText campoNome,campoEmail,campoSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);


        //validar se os campos estão vazios
    }
}