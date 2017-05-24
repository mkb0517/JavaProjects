
package lab3;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;




/**
   Starter code for the CS 420 Lab 1 assignment Part 2 with extended classes.  
   This code demonstrates the use of polymorphism with relation to the 
   GenericNerd and Trekkie classes. All objects are treated as Generic Nerds 
   after they are created.  The main routine creates several nerds of both 
   GenericNerd and Trekkie types.  The nerds are each added to an ArrayList 
   after they are created.  After all of the nerds are created and added to the 
   list, a printout shows all of the nerds present in the list.  Finally, all 
   of the nerds are harassed.
   
   @author Matthew Brown, Kailani Jones
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
     * 
     * @param data 
     */
    static void task2_write(double[][] data){
        try {
            FileOutputStream outFile = new FileOutputStream("new.txt",false);
            DataOutputStream outs = new DataOutputStream(outFile);
            for(double[] row : data){
                for (double datum: row){
                    outs.writeDouble(datum);
                }
            }
            outs.close();   //Close the file
            outFile.close();
        } 
        catch (FileNotFoundException ex) {
            System.err.println("ERROR: File not found");
        }
        catch (IOException ex){
            System.err.println("Error: Problem writing to file");
        }
    }
    
    /**
     * 
     * @param data
     */
    static void task2_read(ArrayList<Double> data){
        
        // Open the file to be read from
        double num;
        
        try {
            //USE JFILECHOOSER! NEEDS TO BE CHANGED*************************
            FileInputStream fileIn = new FileInputStream("new.txt");
            DataInputStream in = new DataInputStream(fileIn);
               while(true){
                    num=in.readDouble(); //read doubles from file
                    data.add(num);//output doubles to screen
                }
        }
        catch(EOFException e){
            System.out.println("Finished reading objects from file...");
            }
        catch (IOException e){
            System.err.println("Error: File failed to open or got corrupted for read");
            System.exit(1);
        }
    }
    
    /**
     * 
     */
    static void task3(){
        //Writes integers to a file and closes it
        try{
            //NEED TO OPEN WITH JFILECHECKER
            RandomAccessFile fileW= new RandomAccessFile("Data1.dat","rw");
            for(int i=10;i<=100;i+=10){
                fileW.writeInt(i);
                
            }
        fileW.close();
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        
        //Opens the file and changes the 5th and 10th item with negative values
        try{
            final int SIZE_OF_INT_IN_BYTES = 4;
            RandomAccessFile file= new RandomAccessFile("Data1.dat","rw");
            file.seek(4*SIZE_OF_INT_IN_BYTES);  //Seeks to the fifth integer
            file.writeInt(-50); //Change 50 to -50
            file.seek(9*SIZE_OF_INT_IN_BYTES); 
            file.writeInt(-100);
            file.close();
        }
        catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
        
        
        try{
            int storage;
            RandomAccessFile file=new RandomAccessFile("Data1.dat", "rw");
            for(int i=0;i<10;i++){
                storage=file.readInt();
                System.out.println(storage);
            }
        }catch(IOException e){
            System.err.println("Error" + e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // TODO code application logic here
        
        System.out.println("<<< CS 420 Lab 2 Test Code. >>>");
        
        GenericNerd nerd;
        
        // write the list of nerds to a file. All Nerd types should be accounted for
        try {
            FileOutputStream fileOut = new FileOutputStream("nerdRoster.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            nerd = new GenericNerd("Bugger McNosePicker", 9);
            out.writeObject(nerd);
            nerd = new GenericNerd("Lame-o Lamerson", 12);
            out.writeObject(nerd);
            nerd = new Trekkie("Captain Spazz", 3,false,true);
            out.writeObject(nerd);
            nerd = new GamerGeek("XBone Commando", 1, "XB1");
            out.writeObject(nerd);
            nerd = new CosPlayTrekkie("Captain", 10,true,true, "Federation Officer");
            out.writeObject(nerd);
            nerd = new GamerGeek("Rambo Wannabe", 10, "XB1");
            out.writeObject(nerd);
            nerd = new CosPlayTrekkie("Deanna Troi fanboy", 6,true,false, "Borg drone");
            out.writeObject(nerd);
            nerd = new Trekkie("Trekking Trekster", 2, false, false);
            out.writeObject(nerd);
            nerd = new CosPlayTrekkie("Warf Luver", 1, true, true, "Klingon");
            out.writeObject(nerd);
            nerd = new GamerGeek("Baron Ron von Dorkenstein", 1, "PC");
            out.writeObject(nerd);
            Trekkie t = new CosPlayTrekkie("Donnie Doofus", 8, false, true, "Vulcan");
            out.writeObject(t);
            nerd = new GamerGeek("Stationary Playstationer", 10, "PS4");
            out.writeObject(nerd);
            
            out.close();
            fileOut.close();
        }
        // Catches an IOException if the file is not opened or stream is corrupted
        catch (IOException e) {
            System.err.println("Error: File failed to open or got corrupted");
            System.exit(1);
        }
        
        // Pause the program so that the user can verify the file creation.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nerd Roster created, strike any key to continue...");
        String s = keyboard.nextLine();
        
        // Open the file to be read from
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try {
            fileIn = new FileInputStream("nerdRoster.ser");
            in = new ObjectInputStream(fileIn);
            while(true){
                nerd = (GenericNerd) in.readObject();
                System.out.println(nerd.toString());
            }
        }
        catch(EOFException e){
            System.out.println("Finished reading objects from file...");
        }
        catch (IOException e){
            System.err.println("Error: File failed to open or got corrupted for read");
            System.exit(1);
        }
        catch (ClassNotFoundException e){
            System.err.println("Nerd class not found...");
        }
        finally{
            if(in!=null) in.close();
            if(fileIn!=null) fileIn.close();
        }
        
        System.out.println();
        System.out.println("*************************************************************");
        System.out.println("*                   Nerd List Read from File                *");
        System.out.println("*************************************************************");
        System.out.println();        
        System.out.println("Strike any key to continue...");
        s = keyboard.nextLine();
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(new JFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } 
        
        double[][] x =  {{10.34,23.567,61.2}, {-12.0,200.34,30e2}};
        task2_write(x);
        
        ArrayList<Double> y=new ArrayList(2);
        task2_read(y);
        
        //output onto screen
        for(int i=0; i<y.size(); i++){
            System.out.println(y.get(i));
        }
        
        //Task 3
        task3();
        
    }
}