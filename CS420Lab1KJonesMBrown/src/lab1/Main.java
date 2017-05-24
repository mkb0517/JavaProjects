
package lab1;
import java.util.*;

/**
   Starter code for the CS 420 Lab 1 assignment.  This code demonstrates
   the use of polymorphism with relation to the GenericNerd and Trekkie classes.
   All objects are treated as Generic Nerds after they are created.  The main
   routine creates several nerds of both GenericNerd and Trekkie types.  The
   nerds are each added to an ArrayList after they are created.  After all of
   the nerds are created and added to the list, a printout shows all of the
   nerds present in the list.  Finally, all of the nerds are harassed.  If you
   have successfully modified the GenericNerd and Trekkie classes according to
   the instructions in the lab assignment, this code will run correctly.
   
   @author Michael Peterson
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
       @param list A list containing GenericNerd objects.
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
        
        System.out.println("<<< CS 420 Lab 1 Test Code. >>>");
        
        // List to keep a few nerds in
        ArrayList<GenericNerd> nerdList = new ArrayList(10);
        
        // create a few nerds and add them to the list
        GenericNerd nerd = new GenericNerd("Bugger McNosePicker", 9);
        nerdList.add(nerd);
        // This will generate a warning message:
        nerd = new GenericNerd("Lame-o Lamerson", 12);
        nerdList.add(nerd);
        
        // POLYMORPHISM IN ACTION!!!
        nerd = new Trekkie("Captain Spazz", 3,false,true);
        nerdList.add(nerd);
        nerd = new Trekkie("Lt. Commander Loser", 10,true,true);
        nerdList.add(nerd);
        // generate another warning (Klingon speaker of a low level)
        nerd = new Trekkie("Deanna Troi fanboy", 6,true,false);
        nerdList.add(nerd);
        // round out the list with a few more various nerds
        nerd = new GenericNerd("Baron Ron von Dorkenstein", 10);
        nerdList.add(nerd);
        nerd = new GenericNerd("Donnie Doofus", 8);
        nerdList.add(nerd);
        
        
        // print out a list of the nerds:
        showNerdList(nerdList);
        
        // harass all of the nerds
        harassNerds(nerdList);
        
    }
    
}
