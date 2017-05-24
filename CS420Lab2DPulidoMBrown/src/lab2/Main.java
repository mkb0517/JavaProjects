
package lab2;
import java.util.*;
import java.io.*;
import java.nio.file.Paths;

/**
   Starter code for the CS 420 Lab 1 assignment Part 2 with extended classes.  
   This code demonstrates the use of polymorphism with relation to the 
   GenericNerd and Trekkie classes. All objects are treated as Generic Nerds 
   after they are created.  The main routine creates several nerds of both 
   GenericNerd and Trekkie types.  The nerds are each added to an ArrayList 
   after they are created.  After all of the nerds are created and added to the 
   list, a printout shows all of the nerds present in the list.  Finally, all 
   of the nerds are harassed.
   
   @author Matthew Brown, Danielle Pulido
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    
    /**
       Print a list of nerds.
       @param list A list containing GenericNerd objects.
     */
    public static void showNerdList(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*             List of Known Nerds              *");
        System.out.println("************************************************");
        System.out.println();
        
        if(list.isEmpty())
        {
            System.out.println("\tThere are no nerds.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            // note implicit call to nerd.toString() below.
            System.out.println("\t" + nerd);
        }
        
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*               End of Nerd List               *");
        System.out.println("************************************************");
        System.out.println();
    }
    
    /**
       Harass all of the nerds in the list.
       @param list A  list containing GenericNerd objects.
     */
    public static void harassNerds(ArrayList<GenericNerd> list)
    {
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*               Harassing Nerds                *");
        System.out.println("************************************************");
        System.out.println();
        
        if(list.isEmpty())
        {
            System.out.println("\tThere are no nerds to harass.");
        }
        
        for(int i = 0; i < list.size(); i++)
        {
            GenericNerd nerd = list.get(i);
            nerd.harass();
        }
        
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*   Finished Harassing Nerds (that was fun!)   *");
        System.out.println("************************************************");
        System.out.println();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("<<< CS 420 Lab 2 Test Code. >>>");
        
        // write the list of nerds to a file. All Nerd types should be accounted for
        PrintWriter outputFile = null;
        try {
            // open the file with FileWriter. False so that it always creates a new file
            FileWriter fwriter = new FileWriter("nerdRoster.txt", false);
            outputFile = new PrintWriter(fwriter);
            GenericNerd nerd = new GenericNerd("Bugger McNosePicker", 9);
            // write the nerd to a file after we're done creating it.
            nerd.writeNerd(outputFile);
            nerd = new GenericNerd("Lame-o Lamerson", 12);
            nerd.writeNerd(outputFile);
            nerd = new Trekkie("Captain Spazz", 3,false,true);
            nerd.writeNerd(outputFile);
            nerd = new GamerGeek("XBone Commando", 1, "XB1");
            nerd.writeNerd(outputFile);
            nerd = new CosPlayTrekkie("Captain", 10,true,true, "Federation Officer");
            nerd.writeNerd(outputFile);
            nerd = new GamerGeek("Rambo Wannabe", 10, "XB1");
            nerd.writeNerd(outputFile);
            nerd = new CosPlayTrekkie("Deanna Troi fanboy", 6,true,false, "Borg drone");
            nerd.writeNerd(outputFile);
            nerd = new Trekkie("Trekking Trekster", 2, false, false);
            nerd.writeNerd(outputFile);
            nerd = new CosPlayTrekkie("Warf Luver", 1, true, true, "Klingon");
            nerd.writeNerd(outputFile);
            nerd = new GamerGeek("Baron Ron von Dorkenstein", 1, "PC");
            nerd.writeNerd(outputFile);
            Trekkie t = new CosPlayTrekkie("Donnie Doofus", 8, false, true, "Vulcan");
            t.writeNerd(outputFile);
            nerd = new GamerGeek("Stationary Playstationer", 10, "PS4");
            nerd.writeNerd(outputFile);
        }
        // Catches an IOException if the file is not opened or stream is corrupted
        catch (IOException e) {
            System.err.println("Error: Filfe failed to open or got corrupted");
            System.exit(0);
        }
        // Here just in case the file doesn't close for whatever reason.
        finally {
            if (outputFile!=null){
                outputFile.close();
            }
        }
        
        // Pause the program so that the user can verify the file creation.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nerd Roster created, strike any key to continue...");
        String s = keyboard.nextLine();
        
        // Create an array list of GenericNerds to read the data into from the file.
        ArrayList<GenericNerd> nerdList = new ArrayList<>();
        
        // Open the file to be read from
        try (Scanner inputFile = new Scanner(Paths.get("nerdRoster.txt"))){
            // if the file doesn't open, throw an exception.
            if (inputFile==null) throw new IOException();

            String line;
            // Tell the split command how to parse the current file line.
            String delims;
            delims = "(: )|(\\? )";
            ArrayList<String> nerdStats = new ArrayList<>();
            // continue to read from the file while there are lines to be read
            while(inputFile.hasNext()){
                line = inputFile.nextLine();
                int count = 0;
                // Toss the headers and only keep the data
                for (String item : line.split(delims)) {
                    if (count > 0) nerdStats.add(item);
                    else {
                        switch (item) {
                            case "Type":
                                count++;
                                break;
                            case "Name":
                                count++;
                                break;
                            case "Nerd Level":
                                count++;
                                break;
                            case "Platform":
                                count++;
                                break;
                            case "Speaks Klingon":
                                count++;
                                break;
                            case "Captain":
                                count++;
                                break;
                            case "Costume":
                                count++;
                                break;
                            case "------------------------------":
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            inputFile.close();
            
            // create new nerd objects to store the data properly
            for(int i=0; i<nerdStats.size(); i++){
                GenericNerd nerd;
                String name;
                int nerdFactor;
                boolean speaksKlingon;
                boolean kirkBetter;
                String costume;
                String platform;
                // Since we know the data require for each nerd, we can cycle 
                // through switch cases to recreate them, then add them to
                // the nerdList.
                switch(nerdStats.get(i)){
                    case "GenericNerd":
                        i++;
                        name = nerdStats.get(i);
                        i++;
                        nerdFactor = Integer.parseInt(nerdStats.get(i));
                        nerd = new GenericNerd(name, nerdFactor);
                        nerdList.add(nerd);
                        break;
                    case "Trekkie":
                        i++;
                        name = nerdStats.get(i);
                        i++;
                        nerdFactor = Integer.parseInt(nerdStats.get(i));
                        i++;
                        speaksKlingon = "Yes".equals(nerdStats.get(i));
                        i++;
                        kirkBetter = "Kirk".equals(nerdStats.get(i));
                        nerd = new Trekkie(name, nerdFactor, speaksKlingon, kirkBetter);
                        nerdList.add(nerd);
                        break;
                    case "CosplayTrekkie":
                        i++;
                        name = nerdStats.get(i);
                        i++;
                        nerdFactor = Integer.parseInt(nerdStats.get(i));
                        i++;
                        speaksKlingon = "Yes".equals(nerdStats.get(i));
                        i++;
                        kirkBetter = "Kirk".equals(nerdStats.get(i));
                        i++;
                        costume = nerdStats.get(i);
                        nerd = new CosPlayTrekkie(name, nerdFactor, speaksKlingon, kirkBetter, costume);
                        nerdList.add(nerd);
                        break;
                    case "GamerGeek":
                        i++;
                        name = nerdStats.get(i);
                        i++;
                        nerdFactor = Integer.parseInt(nerdStats.get(i));
                        i++;
                        platform = nerdStats.get(i);
                        nerd = new GamerGeek(name, nerdFactor, platform);
                        nerdList.add(nerd);
                        break;
                    default:
                        break;
                }
            }
        }
        catch (IOException e){
            System.err.println("Error: File failed to open or got corrupted for read");
            System.exit(1);
        }
        
        // print out a list of the nerds:
        showNerdList(nerdList);

        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("*Nerd Roster read into memory, strike any key to continue...*");
        System.out.println("*************************************************************");
        System.out.println();        
        // Pause and wait for the user to continue
        s = keyboard.nextLine();
        
        // reopen the File in a try block so it can throw if there is an error
        // and close when we exit the try scope.
        try (FileWriter fwriter = new FileWriter("nerdRoster.txt", false)){
            outputFile = new PrintWriter(fwriter);
            // modify nerd 3 and 7 according to requirement
            nerdList.get(2).name="Phineas Q. Arbuckle";
            nerdList.get(6).name="Booger McStickyfingers";
            // rewrite the nerds to a new file because it's a sequential access
            for(int i=0;i<nerdList.size();i++){
                nerdList.get(i).writeNerd(outputFile);
            }
        }
        catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        finally{
            if(outputFile!=null)
                outputFile.close();
        }
        
        System.out.println();
        System.out.println("************************************************");
        System.out.println("*        Finished modifying Nerd Roster        *");
        System.out.println("************************************************");
        System.out.println();        
    }
}