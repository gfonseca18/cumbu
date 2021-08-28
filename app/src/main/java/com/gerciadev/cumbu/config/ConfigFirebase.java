package com.gerciadev.cumbu.config;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by gerciafonseca on 28/08/2021
 */
public class ConfigFirebase {
    private  static  FirebaseAuth autenticacao;

    //retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
       return autenticacao;
    }
}
