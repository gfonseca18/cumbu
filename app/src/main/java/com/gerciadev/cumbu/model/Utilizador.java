package com.gerciadev.cumbu.model;

import com.gerciadev.cumbu.config.ConfigFirebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

/**
 * Created by gerciafonseca on 28/08/2021
 */
public class Utilizador {
    private String idUtilizador;
    private String nome;
    private  String email;
    private  String senha;
    private Double receitaTotal = 0.00;
    private Double despesaTotal = 0.00;



    public Utilizador() {
    }
    public void salvar(){
        DatabaseReference firebase = ConfigFirebase.getFirebaseDatabase();
        firebase.child("utilizadores")
                .child(this.idUtilizador)
                .setValue(this);
    }

    public Double getReceitaTotal() {
        return receitaTotal;
    }

    public void setReceitaTotal(Double receitaTotal) {
        this.receitaTotal = receitaTotal;
    }

    public Double getDespesaTotal() {
        return despesaTotal;
    }

    public void setDespesaTotal(Double despesaTotal) {
        this.despesaTotal = despesaTotal;
    }

    @Exclude
    public String getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(String idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
