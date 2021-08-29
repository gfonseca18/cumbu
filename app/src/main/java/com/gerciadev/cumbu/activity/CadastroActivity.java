package com.gerciadev.cumbu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gerciadev.cumbu.R;
import com.gerciadev.cumbu.config.ConfigFirebase;
import com.gerciadev.cumbu.helper.Base64Custom;
import com.gerciadev.cumbu.model.Utilizador;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {
    private EditText campoNome,campoEmail,campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;
    private Utilizador utilizador;
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
                         utilizador = new Utilizador();
                         utilizador.setNome( textoNome);
                         utilizador.setEmail(textoEmail);
                         utilizador.setSenha(textoSenha);

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
        autenticacao.createUserWithEmailAndPassword(utilizador.getEmail(),utilizador.getSenha()

        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
               if (task.isSuccessful()){
                   String idUtilizador = Base64Custom.codeBase64(utilizador.getEmail());
                   utilizador.setIdUtilizador(idUtilizador);
                   utilizador.salvar();
                   finish();
               }else{
                   String exececao = "";
                   //Tratamento de execpções
                   try {
                       throw  task.getException();

                   }catch (FirebaseAuthWeakPasswordException e){
                       exececao = "Digite uma senha mais forte!";
                   }catch (FirebaseAuthInvalidCredentialsException e){
                       exececao= "Por favor,digite um e-mail válido";
                   }catch (FirebaseAuthUserCollisionException e){
                       exececao = "Este conta já foi cadastrada";
                   }catch (Exception e){
                       exececao = "Erro ao cadastrar utilizador:" +e.getMessage();
                       e.printStackTrace();
                   }
                   Toast.makeText(CadastroActivity.this,
                           exececao,
                           Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}