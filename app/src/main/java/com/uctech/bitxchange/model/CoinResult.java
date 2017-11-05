package com.uctech.bitxchange.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Uche on 11/2/2017.
 */

public class CoinResult implements Serializable {
    @SerializedName("BTC")
    private Coin bitCoin;
    @SerializedName("ETH")
    private Coin ethereum;

    public CoinResult() {
    }

    public CoinResult(Coin bitCoin, Coin ethereum) {
        this.bitCoin = bitCoin;
        this.ethereum = ethereum;
    }

    public Coin getBitCoin() {
        return bitCoin;
    }
    public void setBitCoin(Coin bitCoin) {
        this.bitCoin = bitCoin;
    }

    public Coin getEthereum() {
        return ethereum;
    }

    public void setEthereum(Coin ethereum) {
        this.ethereum = ethereum;
    }

    @Override
    public String toString() {
        return "CoinResult{" +
                "bitCoin=" + bitCoin +
                ", ethereum=" + ethereum +
                '}';
    }
}
