package com.uctech.bitxchange.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by UcheAtSoftquest on 11/3/2017.
 */

public class ApiClient {
   public static final String SERVICE_ENDPOINT = "https://min-api.cryptocompare.com/data/";
   private  static Retrofit retrofit = null;

   public static Retrofit getClient(){
       if(retrofit == null) {
           retrofit = new Retrofit.Builder()
                   .baseUrl(SERVICE_ENDPOINT)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit;
   }
}
