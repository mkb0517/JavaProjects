
package lab2;

import java.io.*;

/**
   Instances of the GamerGeek class track represent nerds who are way too into
   playing video games.  In addition to tracking the gamergeek's name and nerd
   factor, it also tracks the preferred platform of the gamergeek. 
   @author Matthew Brown
 */
public class GamerGeek extends GenericNerd {
    
    protected String prefPlatform;
    
    /** Creates a new instance of GamerGeek - a nerd obsessed with gaming.
        Precondition: name must not be null, nerdFactor must be between 1 & 10.
        If the GamerGeek plays on a PC, his nerd factor must be 5 or higher. If 
        a GamerGeek plays on an XB1, his nerd factor must be between 1 and 6.
        PS4 GamerGeeks may have any nerd factor.
        Postcondition: a new GamerGeek object is created with the given name
        and nerd factor with an indication of which platform the GamerGeek games on.
        @param name The name of this nerd.
        @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
        @param platform The preferred platform that a gamer geek likes to game on
     */
    public GamerGeek(String name, int nerdFactor, String platform) 
    {
        super(name,nerdFactor);
        if(name == null)
        {
            System.out.println("Error: GenericNerd constructor - name is null!");
            System.exit(1);
        }
        
        // the setNerdFactor method handles parameter range checking
        setNerdFactor(nerdFactor);
        
        this.name = name;
        prefPlatform = platform;
        
        if(prefPlatform == "XB1"){
            if(nerdFactor>6){
                System.out.println("WARNING! " + name + " is not as nerdy for playing "
                        + "on an XBone. (setting nerd factor to 6).");
                setNerdFactor(6);
            }
        }
        else if(prefPlatform == "PC"){
            if(nerdFactor<5){
                System.out.println("WARNING! " + name + " plays on a PC! "
                        + "(Setting nerd factor to 7).");
                setNerdFactor(7);
            }
        }
    }

    public String toString()
    {
        String trekkie = new String(name + " is a level " +
                nerdFactor + " GamerGeek nerd ");
        String Platform = "";
        switch(prefPlatform){
            case "PC":
                Platform = new String("who likes to GAME on a PC");
                break;
            case "PS4":
                Platform = new String("who likes to GAME on a PS4");
                break;
            case "XB1":
                Platform = new String("who likes to GAME on a XB1");
                break;
            default:
                System.out.println("Wtf how did you get by without a platform");
                System.exit(1);
        }
        return new String(trekkie + Platform);
    }
    
    /**
     * Public method to write the GamerGeek nerd and his stats to a file.
     * @param output file stream that we are writing to.
     * @throws IOException exception thrown if there is something wrong
     */
    @Override
    public void writeNerd(PrintWriter output) throws IOException{
        output.println("Type: GamerGeek");
        output.println("Name: " + name);
        output.println("Nerd Level: " + nerdFactor);
        output.println("Platform: " + prefPlatform);
        output.println("------------------------------");
    }
    
    /**
       Harass this GamerGeek.  Harassment is based upon the GamerGeek's nerd factor
       and Platform preference.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    @Override
    public void harass()
    {
        switch(prefPlatform){
            case "PC":
                System.out.println("You tell GamerGeek " + name +
                        " your PC must stand for Piece (of) Crap!!! GET AN UPGRADE!! " +
                        "(and then give him/her a " + getHarassment() + ")!");
                break;  
            case "PS4":
                System.out.println("You tell GamerGeek " + name + 
                        " YOU CAN'T EVEN MOD SKYRIM ON PS4!!! " +
                        "(and then give him/her a " + getHarassment() + ")!");
                break;
            case "XB1":
                System.out.println("You tell GamerGeek " + name + 
                            " after this you're gonna give his/her XBone a RRoD!!! " +
                            "(and then give him/her a " + getHarassment() + ")!");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized error code!!!");
                System.exit(5);
        }
    }
    
    /**
       Determine how to harass the nerd based on the nerd's nerd factor.  Higher
       nerd factors result in worse harassment.  NOTE: THIS IS NOT A PUBLIC
       METHOD.  IT IS A HELPER METHOD FOR THE HARASS METHOD.
     */
    @Override
    protected String getHarassment()
    {
        String harassment = null;
        switch (nerdFactor)
        {
            case 1:
            case 2:
            case 3:
                harassment = new String("cord binding");
                break;
            case 4:
            case 5:
            case 6:
                harassment = new String("cord whipping");
                break;
            case 7:
            case 8:
            case 9:
                harassment = new String("cord wedgie");
                break;
            case 10:  // case 10, code should never get here otherwise
                harassment = new String("SUPER ATOMIC CORD WEDGIE");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized error code!!!");
                System.exit(6);
        }
        return harassment;
    }
    
}
