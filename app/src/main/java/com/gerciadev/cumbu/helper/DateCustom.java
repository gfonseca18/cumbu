package com.gerciadev.cumbu.helper;

import java.text.SimpleDateFormat;

/**
 * Created by gerciafonseca on 30/08/2021
 */
public class DateCustom {

    public static String dataAtual(){
        long data = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String dataString = simpleDateFormat.format(data);
        return dataString;
    }

    public  static String mesAnoDataEscolhida(String data){

                String retornoData[] = data.split("-");
                String dia = retornoData[0];
                String mes = retornoData[1];
                String ano = retornoData[2];

                String mesAno = mes + ano;
                return  mesAno;
    }

}
