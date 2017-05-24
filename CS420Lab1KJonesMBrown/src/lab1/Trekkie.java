
package lab1;

/**
   Instances of the Trekkie class track represent nerds who are huge Star Trek
   fans (to the detriment of their social lives).  In addition to tracking the
   nerd's name and nerd factor (see the documentation for the GenericNerd class),
   a Trekkie prefers either Captain Kirk from the original series (TOS) or
   Captain Picard from Star Trek: The Next Generation (TNG).  No Trekkie is
   neutral on this issue.  It is always one captain or the other with these
   people!  The biggest Star Trek nerds may actually be fluent in Klingon.
   Rather than spending their time learning a useful language like Spanish or
   Japanese, they have spent years of their lives learning a fake language (sad
   but true fact, Klingon speakers now outnumber native Navajo speakers in our
   modern world)!  Due to the huge nerd level required to master Klingon,
   Trekkies who speak Klingon fluently must have a nerd factor of 9 or higher.
   When harassing a Trekkie, Klingon fluency and imaginary captain preference
   are considered along with the Trekkie's base nerd factor.
   @author Michael Peterson
 */
public class Trekkie extends GenericNerd {
    
    protected boolean speaksKlingon;
    protected boolean kirkBetterThanPicard;
    
    /** Creates a new instance of Trekkie - a nerd obsessed with Star Trek.
        Precondition: name must not be null, nerdFactor must be between 1 & 10.
        If the Trekkie speaks Klingon, nerdFactor must be 9 or 10 (only super
        Trekkie nerds bother to learn Klingon.)
        Postcondition: a new Trekkie object is created with the given name
        and nerd factor with an indication of whether the Trekkie thinks Captain
        Kirk is better than Captain Picard, and whether the Trekkie speaks Klingon.
        @param name The name of this nerd.
        @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
        @param klingonSpeaker True if the new Trekkie can speak Klingon.
        @param kirkBetter True if The Trekkie prefers Captain Kirk to Captain Picard.
     */
    public Trekkie(String name, int nerdFactor, boolean klingonSpeaker, boolean kirkBetter) 
    {
        super(name,nerdFactor);
        if(klingonSpeaker)
        {
            speaksKlingon = true;
            // make sure Klingon speakers have a high enough nerd factor!
            if(nerdFactor < 9)
            {
                System.out.println("Warning: " + name + 
                        " speaks Klingon! (setting nerdFactor to 9).");
                setNerdFactor(9);
            }
        }
        kirkBetterThanPicard = kirkBetter;
    }
    
    /**
       Indicates whether this Trekkie speaks Klingon.
       @return True if this Trekkie speaks Klingon, false otherwise.
     */
    public boolean klingonSpeaker()
    {
        return speaksKlingon;
    }
    
    /**
       Set this Trekkie's status as a Klingon speaker.
       Postcondition: This Trekkie's Klingon speaking status is updated to the
       provided value.
       @param klingonSpeaker The new status of this Trekkie's Klingon fluency.
     */
    public void setKlingonSpeaker(boolean klingonSpeaker)
    {
        speaksKlingon = klingonSpeaker;
    }
    
    /**
       Set this Trekkie's preference of Captain Kirk or Captain Picard
       Postcondition: this Trekkie's captain preference is updated
       @param kirkBetter True if this Trekkie prefers Kirk to Picard, false
       otherwise.
     */
    public void setCaptainPreference(boolean kirkBetter)
    {
        kirkBetterThanPicard = kirkBetter;
    }
    
    /**
       Indicates if this Trekkie prefers Captain Kirk over Captian Picard
       @return true if this Trekkie prefers Kirk to Picard, false otherwise.
     */
    public boolean ThinksKirkIsBetter()
    {
        return kirkBetterThanPicard;
    }
    
    /**
       Constructs and returns a String describing the various nerd qualities of
       this trekkie.
       @return a String indicating the nerd statistics of this Trekkie.
     */

    @Override
    public String toString()
    {
        String trekkie = new String(name + " is a level " +
                nerdFactor + " Star Trek nerd ");
        String klingon;
        if(speaksKlingon)
            klingon = new String("who speaks Klingon ");
        else klingon = new String("who does not speak Klingon ");
        String captain;
        if(kirkBetterThanPicard)
            captain = new String("and thinks Captain Kirk is better than Captain Picard.");
        else captain = new String("and thinks Captain Picard is better than Captain Kirk.");
        
        return new String(trekkie + klingon + captain);
    }
    
    
    /**
       /**
       Harass this Trekkie.  Harassment is based upon the Trekkie's nerd factor,
       Star Trek captain preference, and Klingon fluency.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    public void harass()
    {
        if(speaksKlingon)
        {
            System.out.println("You ask trekkie " + name +
                    " if there is a word in Klingon for loneliness " +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        if(kirkBetterThanPicard)
        {
            System.out.println("You tell trekkie " + name + 
                    " that Captian Kirk is better than Captain Picard " +
                    "(and then give him/her a " + getHarassment() + ")!");
            return;
        }
        System.out.println("You tell trekkie " + name + 
                    " that Captian Picard is better than Captain Kirk " +
                    "(and then give him/her a " + getHarassment() + ")!");
    }
    
    /**
       Determine how to harass the nerd based on the nerd's nerd factor.  Higher
       nerd factors result in worse harassment.  NOTE: THIS IS NOT A PUBLIC
       METHOD.  IT IS A HELPER METHOD FOR THE HARASS METHOD.
     */
    private String getHarassment()
    {
        String harassment = null;
        switch (nerdFactor)
        {
            case 1:
            case 2:
            case 3:
                harassment = new String("wet willy");
                break;
            case 4:
            case 5:
            case 6:
                harassment = new String("purple nurple");
                break;
            case 7:
            case 8:
            case 9:
                harassment = new String("wedgie");
                break;
            case 10:  // case 10, code should never get here otherwise
                harassment = new String("SUPER ATOMIC WEDGIE");
                break;
            default: // this should never happen!
                System.out.println("Error: unrecognized error code!!!");
                System.exit(2);
        }
        return harassment;
    }
    
}
