package com.company;
import java.util.Scanner;

public class Main {

    public String getType(String gas) {
        String type = "";
        if (gas.equals(87)) {
            return "Regular";
        } else if (gas.equals(89)) {
            return "Mid-Grade";
        } else if (gas.equals(92)) {
            return "Premium";
        } return type;
    }


    public static void main(String[] args) {

        String payBeforeOrAfter;
        Scanner beforeOrAfterInput = new Scanner(System.in);
        System.out.println("\t\tWelcome to Trey's Place!\n1 -> Pay Before\n2 -> Pay After");
        payBeforeOrAfter = beforeOrAfterInput.next();

        if (payBeforeOrAfter.equals("1")) {
            String gastype;
            Scanner gastypeInput = new Scanner(System.in);
            System.out.println("What type of gas?\n87 -> Regular ($2.09)\n89 -> Mid-Grade ($2.19)\n92 -> Premium ($2.29)");
            gastype = gastypeInput.next();
        } else {
            System.out.println("NOPE");
        }
    }
}

