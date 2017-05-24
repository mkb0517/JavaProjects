/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import javax.swing.*;       //For JFileChooser
import javax.swing.filechooser.FileNameExtensionFilter; //For JFileChooser

/**
 * Code for CS420 lab 4. The purpose of this lab is to sort through data in a
 * file and locate the names of droids for sale. This is accomplished by using
 * regex. If a droid is for sale, a price follows in the same line. If a price
 * is not found, the droid is not for sale and is ignored. For easy readability,
 * this program outputs every possible droid by organizing the list through
 * model and alphabetically listing each droid.  *
 * @author Matthew Brown and Kailani Jones
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Obligatory Star Wars Choose-Your-Own-Adventure Book reference
        System.out.println("Dang it Luke,");
        System.out.println("You owe me a 6-pack for this.");
        System.out.println("Signed You"); // You are Luke's Best Friend!
        System.out.println();
        
        // Create an array of the Types of Droids in the array list
        String[] DroidType = {"R2","R3","R4","R5","P2","R4-P","BB","3PO","TC","IG"};
        
        // Create an array of lists to hold all the droids
        // Index corresponds to our droid type list
        ArrayList[] DroidList = new ArrayList[10];
        for(int i=0; i<10; i++){
            DroidList[i] = new ArrayList<>();
        }
        
        //Open file
        Scanner inputFile;

        String name; //holds the current name
        double cost; //holds the current cost
        Droid droid; //holds the current droid

        //Regex for searching through the file
        String droidSearch = "((R4\\-P\\d{2}|R[2-5]\\-?[A-Z]\\d|P2\\-?[A-Z]\\d|"
                + "BB\\-\\d([A-Z]\\d?)?|[A-Z]\\d?\\-3PO|TC\\-\\d{2}|"
                + "IG\\-[0-9A-Z]{2}).*?\\>(\\d{3,5}(\\.\\d{2})?)){1,2}?";
        
        try {

            //JFILECHOOSER to open the needed file
            JFileChooser chooser = new JFileChooser();
            
            chooser.setCurrentDirectory(new java.io.File("."));
            //Filters files so the user only sees text files
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Text Files", "txt");

            //Sets the filter
            chooser.setFileFilter(filter);

            //Opens the user interface
            System.out.println("Opening JFileChooser... Please select your input file:");
            int returnVal = chooser.showOpenDialog(chooser.getParent());

            // If a file is selected, confirm it's selection
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You chose to open this file: "
                        + chooser.getSelectedFile().getName());
            } else {
                //If the user doesn't choose a file, the program exits 
                System.out.println("You did not choose a file. Will exit now.");
                System.exit(2);
            }

            // Open the file stream to read data from it
            inputFile = new Scanner(chooser.getSelectedFile());
            //Create the regex pattern object to search the file with
            Pattern pattern = Pattern.compile(droidSearch);
            while (inputFile.hasNext()) { //For each line of the file
                Matcher matcher = pattern.matcher(inputFile.nextLine());
                while (matcher.find()) {    // While a string match was found
                    //use the group matches to populate droids
                    name = matcher.group(2);
                    /* The following if-else block checks the matched regex. 
                     * The type of droid is identified and an object is created
                     * with the name and cost of the droid.  We add dashes to 
                     * the names of the droids who didn't have dashes. The object
                     * is stored in the appropriate array. 
                     */
                     if (name.matches("R4\\-P\\d{2}")) { 
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);    
                        DroidList[5].add(droid); 
                    } else if (name.matches("R2\\-?[A-Z]\\d")) {
                        name = name.replaceAll("(R2)\\-?([A-Z]\\d)", "$1\\-$2");
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[0].add(droid);
                    } else if (name.matches("R3\\-?[A-Z]\\d")) {
                        name = name.replaceAll("(R3)\\-?([A-Z]\\d)", "$1\\-$2");
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[1].add(droid);
                    } else if (name.matches("R4\\-?[A-Z]\\d")) {
                        name = name.replaceAll("(R4)\\-?([A-Z]\\d)", "$1\\-$2");
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[2].add(droid);
                    } else if (name.matches("R5\\-?[A-Z]\\d")) {
                        name = name.replaceAll("(R5)\\-?([A-Z]\\d)", "$1\\-$2");
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[3].add(droid);
                    } else if (name.matches("P2\\-?[A-Z]\\d")) {
                        name = name.replaceAll("(P2)\\-?([A-Z]\\d)", "$1\\-$2");
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[4].add(droid);
                    } else if (name.matches("BB\\-\\d([A-Z]\\d?)?")) {
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[6].add(droid);
                    } else if (name.matches("[A-Z]\\d?\\-3PO")) {
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[7].add(droid);
                    } else if (name.matches("TC\\-\\d{2}")) {
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[8].add(droid);
                    } else if (name.matches("IG\\-[0-9A-Z]{2}")) {
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);
                        DroidList[9].add(droid);
                    }
                }
            }
            inputFile.close(); //Closes the file
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        // Sorts all of the lists by ascending cost using the Droid overloaded 
        // compareTo method from Comparable.
        for (int i=0; i<10; i++){
            Collections.sort(DroidList[i]);
        }

        //Once done, output accordingly
        FileWriter fwriter;
        try {
            //Creates the file for output
            fwriter = new FileWriter("droids_out.in", false);
            PrintWriter outputFile = new PrintWriter (fwriter);
            
            // Loop through the DroidList and print all the droids to a file.
            for (int i=0; i<10; i++){
                // Droid Type Header
                outputFile.println("*****************************************");
                outputFile.println("* " + DroidType[i] + " Droids \t\t\t\t*");
                outputFile.println("*****************************************");
                // Droid count line
                outputFile.println(DroidList[i].size() + " "
                        + DroidType[i] + " units available");
                outputFile.println();
                // Droid header
                outputFile.println("--Name-----------Price-----");
                // Droid list
                for (int j = 0; j < DroidList[i].size(); j++) {
                    outputFile.println(DroidList[i].get(j));
                }
                outputFile.println("---------------------------");
                outputFile.println();
            }
            outputFile.close();
            fwriter.close();
        } catch (Exception e) {
            System.err.println("Error something went wrong: " + e.getMessage());
        }

        System.out.println("Finished outputting file.");
    }
}
