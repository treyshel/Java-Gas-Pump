package com.company;

public class GasPump {
    public String typeOFgas;
    public Integer amountOFgallons;
    public Integer amountOFmoney;

    GasPump(String typeOFgas, Integer amountOFgallons, Integer amountOFmoney) {
        this.typeOFgas = typeOFgas;
        this.amountOFgallons = amountOFgallons;
        this.amountOFmoney = amountOFmoney;
    }

    public double prepay() {
        double gallons = 0.0;
        if (typeOFgas.equals("Regular")) {
            return Math.round(amountOFmoney / 2.09 * 100.00) / 100.00;
        } else if (typeOFgas.equals("Mid-Grade")) {
            return Math.round(amountOFmoney / 2.19 * 100.00) / 100.00;
        } else if (typeOFgas.equals("Premium")) {
            return Math.round(amountOFmoney / 2.29 * 100.00) / 100.00;
        } return gallons;
    }

    public double payafter() {
        double money = 0.0;
        if (typeOFgas.equals("Regular")) {
            return Math.round(amountOFgallons * 2.09 * 100.00) / 100.00;
        } else if (typeOFgas.equals("Mid-Grade")) {
            return Math.round(amountOFgallons * 2.19 * 100.00) / 100.00;
        } else if (typeOFgas.equals("Premium")) {
            return Math.round(amountOFgallons * 2.29 * 100.00) / 100.00;
        } return money;
    }


}
