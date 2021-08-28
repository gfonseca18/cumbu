package com.gerciadev.cumbu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gerciadev.cumbu.R;
import com.gerciadev.cumbu.config.ConfigFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {
    private EditText campoNome,campoEmail,campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);


        //validar se os campos estão vazios

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                //validar se os campos estão vazios
             if (!textoNome.isEmpty()){
                 if (!textoEmail.isEmpty()){
                     if (!textoSenha.isEmpty()){
                         cadastrarUtilizador();
                     }else {
                         Toast.makeText(CadastroActivity.this,
                                 "Preencha o Senha!",
                                 Toast.LENGTH_SHORT).show();
                     }

                 }else {
                     Toast.makeText(CadastroActivity.this,
                             "Preencha o Email!",
                             Toast.LENGTH_SHORT).show();
                 }

             }else {
                 Toast.makeText(CadastroActivity.this,
                         "Preencha o Nome!",
                         Toast.LENGTH_SHORT).show();
             }

            }
        });
    }
    public void cadastrarUtilizador(){
        //recuperar o objecto do firebase para autenticar o utilizador
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                "email","senha"
        );
    }
}