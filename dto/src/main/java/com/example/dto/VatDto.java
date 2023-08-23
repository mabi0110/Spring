package com.example.dto;

public class VatDto {

    private double netto;
    private double vat;
    private double brutto;

    public VatDto(double netto, double vat, double brutto) {
        this.netto = netto;
        this.vat = vat;
        this.brutto = brutto;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }
}
