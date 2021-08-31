package com.gerciadev.cumbu.activity;

import android.content.Intent;
import android.os.Bundle;

import com.gerciadev.cumbu.databinding.ActivityPrincipalBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.gerciadev.cumbu.activity.databinding.ActivityPrincipalBinding;

import com.gerciadev.cumbu.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class PrincipalActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityPrincipalBinding binding;
    private MaterialCalendarView calendarView;
    private TextView textoSaldo,textSaudacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        /*Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        textoSaldo = findViewById(R.id.textSaldo);
        textSaudacao = findViewById(R.id.textSaudacao);
        calendarView = findViewById(R.id.calendarView);


    }



    public void adicionarReceita(View view){
        startActivity(new Intent(this,ReceitasActivity.class));

    }
    public void adicionarDespesa(View view){
        startActivity(new Intent(this, DespesasActivity.class));
    }
    public void configuracaoCalendarView(){
        CharSequence meses [] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outobro","Novembro","Dezembro"};
        calendarView.setTitleMonths(meses);
        calendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {

            }
        });
    }
}