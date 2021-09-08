package com.gerciadev.cumbu.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gerciadev.cumbu.R;
import com.gerciadev.cumbu.config.ConfigFirebase;
import com.gerciadev.cumbu.model.Utilizador;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {
    private EditText campoEmail,campoSenha;
    private Button botaoEntrar;
    private Utilizador utilizador;
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.editmail);
        campoSenha = findViewById(R.id.editPassword);
        botaoEntrar = findViewById(R.id.buttonEntrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if (!textoEmail.isEmpty()){
                    if (!textoSenha.isEmpty()){
                        utilizador = new Utilizador();
                        utilizador.setEmail(textoEmail);
                        utilizador.setSenha(textoSenha);
                        validarLogin();

                    }else {
                        Toast.makeText(LoginActivity.this,
                                "Preencha a senha !",Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(LoginActivity.this,"Preencha o email!",
                            Toast.LENGTH_SHORT).show();

                    }
            }
        });
    }

    public void validarLogin(){
        autenticacao = ConfigFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                utilizador.getEmail(),
                utilizador.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirTelaPrincipal();
                }else {
                    String excecao = "";
                    try {
                        throw task.getException();

                    }catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Utilizador não está cadastrado.";
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email e senha não correspondem a um utilizador cadastrado";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar utilizador" + e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(LoginActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void abrirTelaPrincipal(){
        startActivity(new Intent(this,PrincipalActivity.class));
        finish();
    }
    public void callHome(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}