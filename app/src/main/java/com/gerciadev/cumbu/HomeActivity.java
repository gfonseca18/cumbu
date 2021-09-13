package com.gerciadev.cumbu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.gerciadev.cumbu.activity.DespesasActivity;
import com.gerciadev.cumbu.activity.LoginActivity;
import com.gerciadev.cumbu.activity.MainActivity;
import com.gerciadev.cumbu.activity.ReceitasActivity;
import com.gerciadev.cumbu.config.ConfiguracaoFirebase;
import com.gerciadev.cumbu.fragments.AddFragment;
import com.gerciadev.cumbu.fragments.CoinsFragment;
import com.gerciadev.cumbu.fragments.PieFragment;
import com.gerciadev.cumbu.fragments.ToolsFragment;
import com.gerciadev.cumbu.fragments.WalletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private FirebaseAuth autenticacao;
    private FrameLayout frameLayout;
    private  BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //configuracoes de objetos
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        frameLayout = findViewById(R.id.viewPager);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        frameLayout  = findViewById(R.id.viewPager);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.wallet:
                        WalletFragment walletFragment = new WalletFragment();
                        selectFragment(walletFragment);
                        break;
                    case R.id.coins:
                        CoinsFragment coinsFragment = new CoinsFragment();
                        selectFragment(coinsFragment);
                        break;
                    case R.id.add:
                        showPublishContentDialogue();
                        break;
                    case R.id.pie:
                        PieFragment pieFragment = new PieFragment();
                        selectFragment(pieFragment);
                        break;
                    case R.id.settings:
                       ToolsFragment toolsFragment = new ToolsFragment();
                        selectFragment(toolsFragment);
                        break;

                }

                return false;
            }

        });
        bottomNavigationView.setSelectedItemId(R.id.wallet);
    }

    private void selectFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,fragment);
        fragmentTransaction.commit();

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    private void showPublishContentDialogue() {

        Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.fragment_add);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(true);

        TextView txt_add_d = dialog.findViewById(R.id.txt_add_d);
        TextView txt_add_r = dialog.findViewById(R.id.txt_add_r);

        txt_add_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,DespesasActivity.class);
                intent.putExtra("type","video");
                startActivity(intent);
            }
        });

        txt_add_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ReceitasActivity.class);
                intent.putExtra("type","video");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSair :
                autenticacao.signOut();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void deslogarUsuario(){
        try{
            autenticacao.signOut();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}