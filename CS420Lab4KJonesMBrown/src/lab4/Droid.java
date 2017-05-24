

package lab4;

/**
 * This is the Droid class. It keeps track of the name and cost of the droid.
 * @author Matthew Brown and Kailani Jones
 */
public class Droid implements Comparable<Droid> {
    
    private String name;
    private double cost;
    
    /**
     * Default Constructor
     * @param n A string representing the name
     * @param c A double representing the cost
     */
    Droid(String n, double c){
        name=n;
        cost=c;
    }
    
    /**
     * Returns the droid's name
     * @return the droid name
     */
    public String getname(){
        return name;
    }
    
    /**
     * Returns the cost of the droid
     * @return the cost
     */
    public double getcost(){
        return cost;
    }
    
    /**
     * Sets the droid name
     * @param n Accepts a String that sets the droid's name
     */
    public void setname(String n) {
        name=n;
    }
    
    /**
     * Sets the droid cost
     * @param c Accepts a double representing cost
     */
    public void setcost(double c){
        cost=c;
    }

    /**
     * Function to compare droids through cost
     * @param obj Accepts a Droid object to compare to the current droid
     * @return an int representing if current droid's cost is less or greater than the compared droid
     */
    @Override
    public int compareTo(Droid obj) {
        if(this.cost < obj.cost)
            return -1;
        else return 1;
    }
    
    /**
     * Outputs the a string containing the droid's name and cost
     * @return A string representing the name and cost
     */
    @Override
    public String toString()
    {
        return ( " " + name + "\t\t" + String.format("%.2f", cost) + " Cr");
    }
}

