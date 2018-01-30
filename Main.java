package com.company;
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


    public static void main(String[] args) {

        String gastype;
        Scanner gastypeInput = new Scanner(System.in);
        System.out.println("\t\tWelcome to Trey's Place!\nWhat type of gas?\n87 -> Regular ($2.09)\n89 -> Mid-Grade ($2.19)\n92 -> Premium ($2.29)\n");
        gastype = getType(gastypeInput.next());

        String payBeforeOrAfter;
        Scanner beforeOrAfterInput = new Scanner(System.in);
        System.out.println("1 -> Pay Before\n2 -> Pay After\n");
        payBeforeOrAfter = beforeOrAfterInput.next();
        
        if (payBeforeOrAfter.equals("1")) {
            Integer total;
            Scanner cashInput = new Scanner(System.in);
            System.out.print("Money amount?\n$");
            total = Integer.parseInt(cashInput.next());

            GasPump printGallons = new GasPump(gastype, 0, total);
            System.out.println("Total gallons: " + printGallons.prepay());
        } else if (payBeforeOrAfter.equals("2")) {
            Integer total;
            Scanner gallonInput = new Scanner(System.in);
            System.out.println("How many gallons?\n");
            total = Integer.parseInt(gallonInput.next());

            GasPump printCost = new GasPump(gastype, total, 0);
            System.out.println("Total cost: $" + printCost.payafter());
        }
    }
}

