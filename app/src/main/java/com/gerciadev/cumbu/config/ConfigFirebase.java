package com.gerciadev.cumbu.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by gerciafonseca on 28/08/2021
 */
public class ConfigFirebase {
    private static  DatabaseReference firebase;
    private  static  FirebaseAuth autenticacao;
     //retorna a instancia do Firebase
    public  static DatabaseReference getFirebaseDatabase(){
        if (firebase == null){
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return firebase;
    }
    //retorna a instancia do FirebaseAuth
    public static FirebaseAuth getFirebaseAutenticacao(){
        if (autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
       return autenticacao;
    }
}
