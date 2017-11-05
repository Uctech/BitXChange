package com.uctech.bitxchange.model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UcheAtSoftquest on 11/2/2017.
 */

public class Coin {
    @SerializedName("USD")
    private BigDecimal usd;
    @SerializedName("EUR")
    private BigDecimal eur;
    @SerializedName("NGN")
    private BigDecimal ngn;
    @SerializedName("AUD")
    private BigDecimal aud;
    @SerializedName("BRL")
    private BigDecimal brl;
    @SerializedName("GBP")
    private BigDecimal gbp;
    @SerializedName("CAD")
    private BigDecimal cad;
    @SerializedName("CLP")
    private BigDecimal clp;
    @SerializedName("CNY")
    private BigDecimal cny;
    @SerializedName("CZK")
    private BigDecimal czk;
    @SerializedName("HKD")
    private BigDecimal hkd;
    @SerializedName("HUF")
    private BigDecimal huf;
    @SerializedName("INR")
    private BigDecimal inr;
    @SerializedName("IDR")
    private BigDecimal idr;
    @SerializedName("ILS")
    private BigDecimal ils;
    @SerializedName("JPY")
    private BigDecimal jpy;
    @SerializedName("KRW")
    private BigDecimal krw;
    @SerializedName("MYR")
    private BigDecimal myr;
    @SerializedName("MXN")
    private BigDecimal mxn;
    @SerializedName("NZD")
    private BigDecimal nzd;

    public Coin(BigDecimal usd, BigDecimal eur, BigDecimal ngn, BigDecimal aud, BigDecimal brl, BigDecimal gbp, BigDecimal cad, BigDecimal clp, BigDecimal cny, BigDecimal czk, BigDecimal hkd, BigDecimal huf, BigDecimal inr, BigDecimal idr, BigDecimal ils, BigDecimal jpy, BigDecimal krw, BigDecimal myr, BigDecimal mxn, BigDecimal nzd) {
        this.usd = usd;
        this.eur = eur;
        this.ngn = ngn;
        this.aud = aud;
        this.brl = brl;
        this.gbp = gbp;
        this.cad = cad;
        this.clp = clp;
        this.cny = cny;
        this.czk = czk;
        this.hkd = hkd;
        this.huf = huf;
        this.inr = inr;
        this.idr = idr;
        this.ils = ils;
        this.jpy = jpy;
        this.krw = krw;
        this.myr = myr;
        this.mxn = mxn;
        this.nzd = nzd;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    public BigDecimal getEur() {
        return eur;
    }

    public void setEur(BigDecimal eur) {
        this.eur = eur;
    }

    public BigDecimal getNgn() {
        return ngn;
    }

    public void setNgn(BigDecimal ngn) {
        this.ngn = ngn;
    }

    public BigDecimal getAud() {
        return aud;
    }

    public void setAud(BigDecimal aud) {
        this.aud = aud;
    }

    public BigDecimal getBrl() {
        return brl;
    }

    public void setBrl(BigDecimal brl) {
        this.brl = brl;
    }

    public BigDecimal getGbp() {
        return gbp;
    }

    public void setGbp(BigDecimal gbp) {
        this.gbp = gbp;
    }

    public BigDecimal getCad() {
        return cad;
    }

    public void setCad(BigDecimal cad) {
        this.cad = cad;
    }

    public BigDecimal getClp() {
        return clp;
    }

    public void setClp(BigDecimal clp) {
        this.clp = clp;
    }

    public BigDecimal getCny() {
        return cny;
    }

    public void setCny(BigDecimal cny) {
        this.cny = cny;
    }

    public BigDecimal getCzk() {
        return czk;
    }

    public void setCzk(BigDecimal czk) {
        this.czk = czk;
    }

    public BigDecimal getHkd() {
        return hkd;
    }

    public void setHkd(BigDecimal hkd) {
        this.hkd = hkd;
    }

    public BigDecimal getHuf() {
        return huf;
    }

    public void setHuf(BigDecimal huf) {
        this.huf = huf;
    }

    public BigDecimal getInr() {
        return inr;
    }

    public void setInr(BigDecimal inr) {
        this.inr = inr;
    }

    public BigDecimal getIdr() {
        return idr;
    }

    public void setIdr(BigDecimal idr) {
        this.idr = idr;
    }

    public BigDecimal getIls() {
        return ils;
    }

    public void setIls(BigDecimal ils) {
        this.ils = ils;
    }

    public BigDecimal getJpy() {
        return jpy;
    }

    public void setJpy(BigDecimal jpy) {
        this.jpy = jpy;
    }

    public BigDecimal getKrw() {
        return krw;
    }

    public void setKrw(BigDecimal krw) {
        this.krw = krw;
    }

    public BigDecimal getMyr() {
        return myr;
    }

    public void setMyr(BigDecimal myr) {
        this.myr = myr;
    }

    public BigDecimal getMxn() {
        return mxn;
    }

    public void setMxn(BigDecimal mxn) {
        this.mxn = mxn;
    }

    public BigDecimal getNzd() {
        return nzd;
    }

    public void setNzd(BigDecimal nzd) {
        this.nzd = nzd;
    }


    public Currency[] getData() {
        Currency[] currencyList = {new Currency("Nigerian Naira", "ng", "NGN", ngn),
                new Currency("United States Dollar", "us", "USD", usd),
                new Currency("Euro", "eu", "EUR", eur),
                new Currency("Japanese Yen", "jp", "JPY", jpy),
                new Currency("Australian Dollar", "au", "AUD", aud),
                new Currency("Brazilian Real", "br", "BRL", brl),
                new Currency("British Pound", "gb", "GBP", gbp),
                new Currency("Canadian Dollar", "ca", "CAD", cad),
                new Currency("Chilean Peso", "cl", "CLP", clp),
                new Currency("Chinese Yuan Renminbi", "cn", "CNY", cny),
                new Currency("Czech Koruna", "cz", "CZK", czk),
                new Currency("Hong Kong Dollar", "hk", "HKD", hkd),
                new Currency("Hungarian Forint", "hu", "HUF", hkd),
                new Currency("Indian Rupee", "in", "INR", inr),
                new Currency("Indonesian Rupiah", "id", "IDR", idr),
                new Currency("Israeli New Shekel", "il", "ILS", ils),
                new Currency("Korean Won", "kr", "KRW", krw),
                new Currency("Malaysian Ringgit", "my", "MYR", myr),
                new Currency("Mexican Peso", "mx", "MXN", mxn),
                new Currency("New Zealand Dollar", "nz", "NZD", nzd)};
        return currencyList;
    }
}
