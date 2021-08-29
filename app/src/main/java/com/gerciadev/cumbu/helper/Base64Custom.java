package com.gerciadev.cumbu.helper;

import android.util.Base64;

/**
 * Created by gerciafonseca on 29/08/2021
 */
public class Base64Custom {

    public static String codeBase64(String texto){
        return Base64.encodeToString(texto.getBytes(),Base64.DEFAULT).replaceAll("\\n|\\r","");
    }
    public static  String decodeBase64(String textoCodificado){
       return new String(Base64.decode(textoCodificado,Base64.DEFAULT));
    }
}
