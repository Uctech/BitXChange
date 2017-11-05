package com.uctech.bitxchange.Interfaces;

import com.uctech.bitxchange.model.CoinResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by UcheAtSoftquest on 11/2/2017.
 */

public interface ApiInterface {


    @GET("pricemulti?fsyms=BTC,ETH&tsyms=USD,EUR,NGN,AUD,BRL,GBP,CAD,CLP,CNY,CZK,HKD,HUF,INR,IDR,ILS,JPY,KRW,MYR,MXN,NZD")
    Call<CoinResult> getExchangeRate();
}
