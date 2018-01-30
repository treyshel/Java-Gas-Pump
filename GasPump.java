package com.company;

public class GasPump {
    public String typeOFgas;
    public Integer amountOFgallons;
    public Integer priceOFgas;

    GasPump(String gasType, Integer gallonAmount, Integer gasPrice) {
        typeOFgas = gasType;
        amountOFgallons = gallonAmount;
        priceOFgas = gasPrice;
    }

    public double prepay(double money) {
        double gallons = 0.0;
        if (typeOFgas.equals("Regular")) {
            return money / 2.09;
        } else if (typeOFgas.equals("Mid-Grade")) {
            return money / 2.19;
        } else if (typeOFgas.equals("Premium")) {
            return money / 2.29;
        } return gallons;
    }

    public double payafter(double gallons) {
        double money = 0.0;
        if (typeOFgas.equals("Regular")) {
            return gallons * 2.09;
        } else if (typeOFgas.equals("Mid-Grade")) {
            return gallons * 2.19;
        } else if (typeOFgas.equals("Premium")) {
            return gallons * 2.29;
        } return money;
    }


}
