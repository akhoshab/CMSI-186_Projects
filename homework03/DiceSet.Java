/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet{

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
     // the count cant be negative or zero
     if (count < 1 || sides < 4) {
         throw new IllegalArgumentException ();
     } else {
         this.count = count;
         this.sides = sides;
         this.ds = new Die[count];
         for (int i = 0; i < count; i++) {
             ds[i] = new Die(sides);
         }
     }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     int currentSum=0;
     for (int i=0; i < count; i++){
       currentSum += ds[i].getValue();
        //currentSum = ds.[i].pips;
     }
     // get the value at i until count and then add it to sum i++
     // return the sum
      return currentSum;
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {
   //  if (count < 1 || sides < 4)
   //     throw new IllegalArgumentException ();
   //  else
   //  ds.roll();
   //  ds.toString
   for (int i=0; i < count; i++){
       System.out.println(ds[i].roll());
   }
}
     // roll all of the dice in the dice set ... can use a for loop
     // call the roll methid from die.java ...


  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     if (dieIndex < 0 || dieIndex >= count) {
         throw new IllegalArgumentException ();
     } else {
         //  return ds[dieIndex].roll();
         ds[dieIndex].roll();
         return ds[dieIndex].getValue();
         // roll one of the dice
         // roll at the position of die index ... ``
     }
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     if ((dieIndex < 0)||(dieIndex >= count)) {
         throw new IllegalArgumentException ();
     } else {
         return ds[dieIndex].getValue();
     }
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
     //String result = null;
     String result = "";
    for (int i=0; i < count; i++) {
    //  result = result + ds[i] + "";
     result = result + ds[i].toString();
    }
     return result;
     // needs to be a for loop ....
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
       return ds.toString();
      // String s = "";
      // for (int i = 0; i < ds.count; i++) {
      //     s = s + "[" + ds.ds[i].getValue() + "]";
      // }
      // return s;
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   // ds1.isIdentical(ds2)
   public boolean isIdentical( DiceSet ds ) {
     if (this.count != ds.count) {
       return false;
     }
     if (this.sides != ds.sides){
      return false;
    }
    return true;
//check if the count sides are the same
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
     System.out.println( "Hello world from the DiceSet..." );
     if(args.length < 2) {
         throw new IllegalArgumentException();
     }
     int c = Integer.parseInt(args[0]);
     int s = Integer.parseInt(args[1]);
     DiceSet ds = new DiceSet(c, s);
     for (int x = 0; x < c; x++) {
       ds.ds[x].roll();
       System.out.println(ds.toString());
     }
   }
}
