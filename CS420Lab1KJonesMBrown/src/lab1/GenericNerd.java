

package lab1;

/**
   Instances of the GenericNerd class represents nerds who do not have a
   specific type of nerdity, they are just generic nerds.  They are defined by
   their name and an overall level of nerdiness.  This level, ranging from 1 to
   10, can be used to harass the nerds.
   @author Michael Peterson
 */
public class GenericNerd {
    
    protected String name;
    protected int nerdFactor;
    
    /** Creates a new instance of GenericNerd 
        Precondition: name must not be null, nerdFactor must be between 1 & 10
        Postcondition: a new GenericNerd object is created with the given name
        and nerd factor.
        @param name The name of this nerd.
        @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
     */
    public GenericNerd(String name, int nerdFactor) {
        if(name == null)
        {
            System.out.println("Error: GenericNerd constructor - name is null!");
            System.exit(1);
        }
        
        // the setNerdFactor method handles parameter range checking
        setNerdFactor(nerdFactor);
        
        this.name = name;
    }
    
    /**
       Returns a string containing this nerd's name.
       @return The nerd's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
       Returns this nerd's nerd factor.
       @return This nerd's nerd factor.
     */
    public int getNerdFactor()
    {
        return nerdFactor;
    }
    
    /**
       Sets this nerd's factor to the provided value.
       Precondition: provided nerdFactor must be between 1 and 10.
       Postcondition: This nerd's nerdFactor is set to the provided value.
       @param nerdFactor On a scale of 1 to 10, how nerdy this nerd is.
     */
    public void setNerdFactor(int nerdFactor)
    {
        if((nerdFactor < 1) || (nerdFactor > 10))
        {
            System.out.println("Warning: Nerd factor must be between 1 & 10 (using default 1)!");
            this.nerdFactor = 1;
        }
        else this.nerdFactor = nerdFactor;
    }
    
    /**
       Creates and returns a string indicating this nerd's name and nerd factor
       @return String containing nerd's name and nerdFactor.
     */
    public String toString()
    {
        return new String(name + " is a level " + nerdFactor + " nerd.");
    }
    
    /**
       Harass this nerd.  Harassment is based upon the nerd's nerd factor.
       Postcondition: A message indicating how to harass this nerd is printed.
     */
    public void harass()
    {
        System.out.println("You give nerd " + name + " a " + getHarassment() +
                "!");
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
