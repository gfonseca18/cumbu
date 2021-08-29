package com.gerciadev.cumbu.activity;


import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gerciadev.cumbu.R;
import com.gerciadev.cumbu.activity.CadastroActivity;
import com.gerciadev.cumbu.activity.LoginActivity;
import com.gerciadev.cumbu.config.ConfigFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {
    private FirebaseAuth autenticacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        verificarLogin();
        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide( new FragmentSlide.Builder()
        .background(android.R.color.white)
                .fragment(R.layout.intro_1)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_2)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_3)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_4)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(android.R.color.white)
                .fragment(R.layout.intro_cadastro)
                .build());
    }

    //metodos para verificar a assinatura

    @Override
    protected void onStart(){
        super.onStart();
        verificarLogin();
    }

    public  void  btEntrar(View view){
        //inicie a activity
        startActivity(new Intent(this, LoginActivity.class));

    }
    public  void  btCadastrar(View view){
      startActivity(new Intent(this, CadastroActivity.class));
    }

    public void verificarLogin(){
       autenticacao = ConfigFirebase.getFirebaseAutenticacao();
       autenticacao.signOut();
       if (autenticacao.getCurrentUser() != null){
        abrirTelaPrincipal();
       }
    }
    public  void abrirTelaPrincipal(){
        startActivity(new Intent(this,PrincipalActivity.class));

    }

}