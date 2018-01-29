package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String payBeforeOrAfter;
        Scanner beforeOrAfterInput = new Scanner(System.in);
        System.out.println("\t\tWelcome to Trey's Place!\n1 -> Pay Before\n2 -> Pay After");
        payBeforeOrAfter = beforeOrAfterInput.next();

        String gastype;
        Scanner gastypeInput = new Scanner(System.in);
        System.out.println("What type of gas?\n1 -> Regular ($2.09)\n2 -> Mid-Grade ($2.19)\n3 -> Premium ($2.29");
        gastype = gastypeInput.next();
        }
}
