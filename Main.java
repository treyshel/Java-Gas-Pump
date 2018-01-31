package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //this makes the input of the number return the type in a string word
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

    public static ArrayList<GasPump> loadInventoryInFile() throws IOException {
        BufferedReader br = null;
        FileReader fr = null;

        //br = new BufferedReader(new FileReader(FILENAME));
        fr = new FileReader("/home/treyshel/IdeaProjects/Gas-Pump-Program/src/com/company/inventory.txt");
        br = new BufferedReader(fr);


        String CurrentLine = "";
        String[] reglist = br.readLine().toString().split(", ");
        String[] midlist = br.readLine().toString().split(", ");
        String[] premlist = br.readLine().toString().split(", ");

        GasPump regular =  new GasPump(reglist[0], Double.parseDouble(reglist[1]), Double.parseDouble(reglist[2]));
        GasPump midgrade = new GasPump(midlist[0], Double.parseDouble(midlist[1]), Double.parseDouble(midlist[2]));
        GasPump premium = new GasPump(premlist[0], Double.parseDouble(premlist[1]), Double.parseDouble(premlist[2]));

        return new ArrayList<GasPump>() {
            {
            add(regular);
            add(midgrade);
            add(premium);
            }
        };

    }


    public static void saveInventoryInFile(ArrayList<GasPump> inventory) throws IOException {
        FileWriter writer = new FileWriter("/home/treyshel/IdeaProjects/Gas-Pump-Program/src/com/company/inventory.txt");
        writer.write(inventory.get(0).typeOFgas + "," + inventory.get(0).amountOFgallons + "," +  inventory.get(0).amountOFmoney );
        writer.write(inventory.get(1).typeOFgas + "," + inventory.get(1).amountOFgallons + "," + inventory.get(1).amountOFmoney);
        writer.write(inventory.get(2).typeOFgas + "," + inventory.get(2).amountOFgallons + "," + inventory.get(2).amountOFmoney);
    }

    //this helps write each transaction into the transactions.txt file
    public static void appendDataToFile(String gastype, double printGallons, double printCost) throws IOException {
        FileWriter writer = new FileWriter("/home/treyshel/IdeaProjects/Gas-Pump-Program/src/com/company/transactions.txt",true);
            //once the file is opened and written into, it has to be closed also
            writer.write("\n" + gastype + ", " + printGallons + ", " + printCost);
            writer.close();
        }
    public static void main(String[] args) throws IOException {
        //gets the gas type input
        String gastype;
        Scanner gastypeInput = new Scanner(System.in);
        System.out.println("\t\tWelcome to Trey's Place!\nWhat type of gas?\n87 -> Regular ($2.09)\n89 -> Mid-Grade ($2.19)\n92 -> Premium ($2.29)\n");
        gastype = getType(gastypeInput.next());

        loadInventoryInFile();

        //this is figuring out whether the user is paying before or after
        String payBeforeOrAfter;
        Scanner beforeOrAfterInput = new Scanner(System.in);
        System.out.println("1 -> Pay Before\n2 -> Pay After\n");
        payBeforeOrAfter = beforeOrAfterInput.next();

        //if the user chooses to pay before, they must pay and receive the gallon amount in the end
        if (payBeforeOrAfter.equals("1")) {
            double total;
            Scanner cashInput = new Scanner(System.in);
            System.out.print("Money amount?\n$");
            total = Integer.parseInt(cashInput.next());

            GasPump printGallons = new GasPump(gastype, 0, total);
            double total_gallons = printGallons.prepay();

            System.out.println("********************************");
            System.out.println("Type of gas: " + gastype);
            System.out.println("Amount paid: $" + total);
            System.out.println("Total gallons received: " + total_gallons);
            System.out.println("********************************");

            //this is the function call to write to the file once the transaction is finished
            appendDataToFile(gastype, total_gallons, total);

        } //if ther user chooses to pay after, they must pump the gas and however many gallons they
        //received, the payment is then shown in the end
        else if (payBeforeOrAfter.equals("2")) {
            double total;
            Scanner gallonInput = new Scanner(System.in);
            System.out.println("How many gallons?\n");
            double total_gallons = Double.parseDouble(gallonInput.next());

            GasPump printCost = new GasPump(gastype, total_gallons, 0);
            double total_price = printCost.payafter();

            //prints receipt
            System.out.println("********************************");
            System.out.println("Type of gas: " + gastype);
            System.out.println("Amount pumped: " + total_gallons);
            System.out.println("Total cost: $" + total_price);
            System.out.println("********************************");

            //this is the function call to write to the file once the transaction is finished
            appendDataToFile(gastype, total_gallons, total_price);

        }
    }
}

