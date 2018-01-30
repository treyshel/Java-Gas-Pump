package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String getType(String gas) {
        String type = "";
        if (gas.equals("87")) {
            return "Regular";
        } else if (gas.equals("89")) {
            return "Mid-Grade";
        } else if (gas.equals("92")) {
            return "Premium";
        } return type;
    }

    public static void appendDataToFile(String gastype, double printGallons, double printCost) throws IOException {
        FileWriter writer = new FileWriter("/home/treyshel/IdeaProjects/Gas-Pump-Program/src/com/company/transactions.txt",true);
            writer.write("\n" + gastype + ", " + printGallons + ", " + printCost);
            writer.close();
        }
    public static void main(String[] args) throws IOException {

        String gastype;
        Scanner gastypeInput = new Scanner(System.in);
        System.out.println("\t\tWelcome to Trey's Place!\nWhat type of gas?\n87 -> Regular ($2.09)\n89 -> Mid-Grade ($2.19)\n92 -> Premium ($2.29)\n");
        gastype = getType(gastypeInput.next());

        String payBeforeOrAfter;
        Scanner beforeOrAfterInput = new Scanner(System.in);
        System.out.println("1 -> Pay Before\n2 -> Pay After\n");
        payBeforeOrAfter = beforeOrAfterInput.next();

        if (payBeforeOrAfter.equals("1")) {
            double total;
            Scanner cashInput = new Scanner(System.in);
            System.out.print("Money amount?\n$");
            total = Integer.parseInt(cashInput.next());

            GasPump printGallons = new GasPump(gastype, 0, total);
            double total_gallons = printGallons.prepay();
            System.out.println("Total gallons: " + printGallons.prepay());
            appendDataToFile(gastype, total_gallons, total);
        } else if (payBeforeOrAfter.equals("2")) {
            double total;
            Scanner gallonInput = new Scanner(System.in);
            System.out.println("How many gallons?\n");
            double total_gallons = Double.parseDouble(gallonInput.next());

            GasPump printCost = new GasPump(gastype, total_gallons, 0);
            double total_price = printCost.payafter();
            System.out.println("Total cost: $" + total_price);
            appendDataToFile(gastype, total_gallons, total_price);

        }
    }
}

