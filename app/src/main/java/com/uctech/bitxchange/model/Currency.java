package com.uctech.bitxchange.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Uche on 10/20/2017.
 */

public class Currency  implements Serializable{
    private String name;
    private String flag;
    private String code;
    private BigDecimal exchangeRate;

    public Currency(String name, String flag, String code, BigDecimal exchangeRate) {
        this.name = name;
        this.flag = flag;
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                ", code='" + code + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }


}
