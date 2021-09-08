package com.gerciadev.cumbu.activity;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.gerciadev.cumbu.R;
import com.gerciadev.cumbu.config.ConfigFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends IntroActivity {
    private FirebaseAuth autenticacao;
    private static final int ACTIVITY_NUM = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

  public void callHome(View view){
        startActivity(new Intent(getApplicationContext(),IntroActivity.class));
  }
    public void callLoginScreen(View view){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.buttonEntrar),"transition_login");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else {
            startActivity(intent);

        }
    }
    public void callSignupScreen(View view){
        Intent intent = new Intent(getApplicationContext(), CadastroActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.buttonCadastrar),"transition_signUp");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
            startActivity(intent,options.toBundle());
        }
        else {
            startActivity(intent);

        }
    }

}