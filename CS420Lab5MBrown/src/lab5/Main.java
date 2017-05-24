/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

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

    public static void parseFile(ArrayList[] DroidList, Scanner inputFile){
        String name; //holds the current name
        double cost; //holds the current cost
        Droid droid; //holds the current droid

        //Regex for searching through the file
        String droidSearch = "(((R4\\-P\\d{2})|(R[2-5]\\-?[A-Z]\\d)|(P2\\-?[A-Z]\\d)|"
                + "(BB\\-\\d([A-Z]\\d?)?)|([A-Z]\\d?\\-3PO)|(TC\\-\\d{2})|"
                + "(IG\\-[0-9A-Z]{2})).*?\\>(\\d{3,5}(\\.\\d{2})?)){1,2}?";
        
        // Regex string for sorting droids into respective lists
        String[] DroidRegex = {"(R2)\\-?([A-Z]\\d)","(R3)\\-?([A-Z]\\d)",
            "(R4)\\-?([A-Z]\\d)","(R5)\\-?([A-Z]\\d)","(P2)\\-?([A-Z]\\d)",
            "(R4)\\-(P\\d{2})","(BB)\\-(\\d([A-Z]\\d?)?)","([A-Z]\\d?)\\-(3PO)",
            "(TC)\\-(\\d{2})","(IG)\\-([0-9A-Z]{2})"
        };
        
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
                for(int i=0; i<10; i++){
                    if(name.matches(DroidRegex[i])){
                        name = name.replaceAll(DroidRegex[i], "$1\\-$2");
                        cost = Double.parseDouble(matcher.group(4));
                        droid = new Droid(name, cost);    
                        DroidList[i].add(droid);
                    }
                }
            }
        }
    }
    
    public static void writeXML(ArrayList[] DroidList, PrintWriter outputFile){
        Droid droid; // container for droid objects
        
        // Create an array of the Types of Droids in the array list
        String[] DroidType = {"R2","R3","R4","R5","P2","R4_P","BB","TPO","TC","IG"};

        // Output the XML header and set the root to Droid
        outputFile.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        outputFile.println("<Droid>");

        // Loop through the DroidList and print all the droids to a file.
        for (int i=0; i<10; i++){
            // Droid header
            switch (i){
                case 0:
                    if(DroidList[0].size()+DroidList[1].size()
                            +DroidList[2].size()+DroidList[3].size()
                            +DroidList[4].size()+DroidList[5].size()>0){
                        outputFile.println("\t<Astromech>");
                    }
                    if(DroidList[0].size()+DroidList[1].size()
                            +DroidList[2].size()+DroidList[3].size()>0){
                        outputFile.println("\t\t<R_Series>");
                    }
                    break;
                case 4:
                    if(DroidList[0].size()+DroidList[1].size()
                            +DroidList[2].size()+DroidList[3].size()>0){
                        outputFile.println("\t\t</R_Series>");
                    }
                    if(DroidList[4].size()>0){
                        outputFile.println("\t\t<P2_Series>");
                    }
                    break;
                case 5:
                    if(DroidList[4].size()>0){
                        outputFile.println("\t\t</P2_Series>");
                    }
                    if(DroidList[5].size()>0){
                        outputFile.println("\t\t<R4_Prototype>");
                    }
                    break;
                case 6:
                    if(DroidList[5].size()>0){
                        outputFile.println("\t\t</R4_Prototype>");
                    }
                    if(DroidList[0].size()+DroidList[1].size()
                            +DroidList[2].size()+DroidList[3].size()
                            +DroidList[4].size()+DroidList[5].size()>0){
                        outputFile.println("\t</Astromech>");
                    } 
                    if(DroidList[6].size()>0){
                        outputFile.println("\t<BB_Series>");
                    }
                    break;
                case 7:
                    if(DroidList[6].size()>0){
                        outputFile.println("\t</BB_Series>");
                    }
                    if(DroidList[7].size()+DroidList[8].size()>0){
                        outputFile.println("\t<Protocol>");
                    }
                    if(DroidList[7].size()>0){
                        outputFile.println("\t\t<TPO_Series>");
                    }
                    break;
                case 8:
                    if(DroidList[7].size()>0){
                        outputFile.println("\t\t</TPO_Series>");
                    }
                    if(DroidList[8].size()>0){
                        outputFile.println("\t\t<T2_Series>");
                    }
                    break;
                case 9:
                    if(DroidList[8].size()>0){
                        outputFile.println("\t\t</T2_Series>");
                    }
                    if(DroidList[7].size()+DroidList[8].size()>0){
                        outputFile.println("\t</Protocol>");
                    }
                    if(DroidList[9].size()>0){
                        outputFile.println("\t<IG_Assassin>");
                    }
                default:
                    break;
            }
            // Droid list
            for (int j = 0; j < DroidList[i].size(); j++) {
                if(i==6||i==9){
                    outputFile.println("\t\t<"+DroidType[i]+">");
                    droid = (Droid) DroidList[i].get(j);
                    outputFile.println("\t\t\t<ID>" + droid.getname() + "</ID>");
                    outputFile.println("\t\t\t<Price Currency='Imperial Credits'>" + String.format("%.2f",droid.getcost()) + "</Price>");
                    outputFile.println("\t\t</"+DroidType[i]+">");
                }
                else{
                    outputFile.println("\t\t\t<"+DroidType[i]+">");
                    droid = (Droid) DroidList[i].get(j);
                    outputFile.println("\t\t\t\t<ID>" + droid.getname() + "</ID>");
                    outputFile.println("\t\t\t\t<Price Currency='Imperial Credits'>" + String.format("%.2f",droid.getcost()) + "</Price>");
                    outputFile.println("\t\t\t</"+DroidType[i]+">");
                }
            }
        }
        if(DroidList[9].size()>0){
            outputFile.println("\t</IG_Assassin>");
        }
        outputFile.println("</Droid>");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        // Create an array of lists to hold all the droids
        // Index corresponds to our droid type list
        ArrayList[] DroidList = new ArrayList[10];
        for(int i=0; i<10; i++){
            DroidList[i] = new ArrayList<>();
        }
        
        //Open file
        Scanner inputFile;

        try {

            //JFILECHOOSER to open the needed file
            JFileChooser chooser = new JFileChooser();
            
            // set the file chooser to the local directory
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
            // send the file and the list to be parsed
            parseFile(DroidList, inputFile);
            //Close the file
            inputFile.close(); 
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
            fwriter = new FileWriter("droids_out.xml", false);
            PrintWriter outputFile = new PrintWriter (fwriter);
            // Write the droids to an XML file
            writeXML(DroidList, outputFile);
            // close the file
            outputFile.close();
            fwriter.close();
        } catch (Exception e) {
            System.err.println("Error something went wrong: " + e.getMessage());
        }
        

        System.out.println("Finished outputting file.");
    }
}
