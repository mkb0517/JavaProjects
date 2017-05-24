
package lab2;

import java.io.*;

/**
   Instances of the CosPlayTrekkie class track represent nerds who are so 
   obsessed with the show that they are willing to dress up as Star Trek 
   characters and go out in public dressed as them. In addition to tracking the
   nerd's name, nerd factor, Klingon fluency, and choice of captain, (see the 
   documentation for the GenericNerd and Trekkie classes), a CosPlayTrekkie takes
   it all a step further and tries to become one with the Star Trek universe by
   dressing up as a Star Trek character. While there are many specific characters 
   that nerds like to dress up as (aside from Kirk and Picard, Spock, Ahura, 
   Wesley Crusher, Data, Bones, and Warf area few examples), they can be classified
   by race to make it easier for the bullies to handle. In general, you have
   Federation Officer, Klingon, Vulcan, and Borg drone. The costumes don't have
   any effect on the nerd factor of a nerd, instead, they change the harassment
   the bully enacts on the nerd. After all, what better way to destroy the heart 
   and soul of a cosplaying Trekkie than to ruin their costume? Thus the 
   harassment consists of varying degrees of water damage to the costume/nerd.
   @author Matthew Brown
 */
public class CosPlayTrekkie extends Trekkie {
    
    protected String prefCostume;
    
    /** Creates a new instance of CosPlayTrekkie - a nerd SO obsessed with Star Trek,
        that they're willing to dress up as them. 
        Precondition: name must not be null, nerdFactor must be between 1 & 10.
        If the CosPlayTrekkie speaks Klingon, nerdFactor must be 9 or 10 (only super
        Trekkie nerds bother to learn Klingon.)
        Postcondition: a new CosPlayTrekkie object is created with the given name
        and nerd factor with an indication of whether the CosPlayTrekkie thinks Captain
        Kirk is better than Captain Picard, and whether the CosPlayTrekkie speaks Klingon
        and what type of Star Trek character they like to dress up as.
        @param name The name of this nerd.
        @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
        @param klingonSpeaker Whether or not the nerd speaks Klingon
        @param kirkBetter Whether or not the nerd prefers Captain Kirk
        @param costume Which character the nerd likes dressing up as. 
     */
    public CosPlayTrekkie(String name, int nerdFactor, boolean klingonSpeaker, 
            boolean kirkBetter, String costume) 
    {
        super(name,nerdFactor, klingonSpeaker, kirkBetter);
        prefCostume = costume;
    }
    
    @Override
    public String toString()
    {
        String prev = super.toString();
        String cosplay = new String("and dresses up as a " + prefCostume + ". ");
        
        return new String(prev + cosplay);
    }
    
    /**
     * Public method to write the CosPlayTrekkie nerd and his stats to a file.
     * @param output file stream that we are writing to.
     * @throws IOException exception thrown if there is something wrong
     */
    @Override
    public void writeNerd(PrintWriter output) throws IOException{
        output.println("Type: CosplayTrekkie");
        output.println("Name: " + name);
        output.println("Nerd Level: " + nerdFactor);
        if(speaksKlingon)
            output.println("Speaks Klingon? Yes");
        else
            output.println("Speaks Klingon? No");
        if(kirkBetterThanPicard)
            output.println("Captain: Kirk");
        else
            output.println("Captain: Picard");
        output.println("Costume: " + prefCostume);
        output.println("------------------------------");

    }
    
    /**
       Harass this CosPlayTrekkie.  Harassment is based upon the 
       CosPlayTrekkie's nerd factor and costume type.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    @Override
    public void harass()
    {
        switch (prefCostume){
            case "Borg drone":
                System.out.println("You tell cosplaying trekkie " + name +
                        " to get assimilated by the borg toilet " + 
                        "(and then give him/her a " + getHarassment() + ") !");
                break;
            case "Klingon":
                System.out.println("You tell cosplaying trekkie " + name + 
                        " to put the mask back on because it makes their face "
                        + "bearable to look at (and then give him/her a "
                        + getHarassment() + ") !");
                break;
            case "Vulcan":
                System.out.println("You tell cosplaying trekkie " + name +
                        " to steel his/her vulcan resolve " +
                        "(and then give him/her a " + getHarassment() + ") !");
                break;
            case "Federation Officer":
                System.out.println("You tell cosplaying trekkie " + name +
                        " that Scotty better beam him/her up or else s/he is "
                        + "in for a world of hurt (and then give him/her a "
                        + getHarassment() + ") !");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized error code!!!");
                System.exit(3);
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
                harassment = new String("water balloon dousing");
                break;
            case 4:
            case 5:
            case 6:
                harassment = new String("5-gallon bucket soaking");
                break;
            case 7:
            case 8:
            case 9:
                harassment = new String("swirlie");
                break;
            case 10:  // case 10, code should never get here otherwise
                harassment = new String("GALACTIC BLACK HOLE SWIRLIE");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized error code!!!");
                System.exit(4);
        }
        return harassment;
    }
    
}
