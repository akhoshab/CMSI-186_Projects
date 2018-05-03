/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangeMaker.java
 * Purpose    :  outputs optimal way of making change using certain denominations
 * @author    :  Ayla Khoshaba
 * Date       :  Spring 2018
 * Description:  Solves the general problem of making change with dynamic programing
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

 public class DynamicChangeMaker {
     public static void main(String[] args) {
         if (args.length != 2){
             System.out.println("you need two arguments!!!");
             return;
            ///2 args coin denoimnations and amount of change ur making
        }
        int amount = 0;
        int[] denominations = new int[0];
        //no negative amounts or denominations, duplicated denominations
        //rejct bad data
         try {
             amount = Integer.parseInt(args[1]);
             if (amount < 0) {
                 System.out.println( "No negative amounts!!!" );
                 return;
              }
              String[] dString = args[0].split(",");
              denominations = new int[dString.length];
              for (int i = 0; i < denominations.length; i++){
                  denominations[i] = Integer.parseInt(dString[i]);
                  if (denominations[i] < 1) {
                      System.out.println( "No negative denominations!!!" );
                      return;
                  }
              }
              for (int i = 0; i < denominations.length - 1; i++){
                  for(int d = i+1; d < denominations.length; d++){
                      if (denominations[d] == denominations[i] && d != i){
                          System.out.println("No Duplicate Denominations!!!");
                      }
                  }
              }

         } catch(NumberFormatException e) {
             System.out.println("Can only make change with numbers!!!");
         }
         Tuple change = makeChangeWithDynamicProgramming (denominations, amount);
         if (change.isImpossible()){
             System.out.println("Its impossible!!!");
         } else {
             int coinTotal = change.total();
             System.out.println(amount + " cents can be made with " + coinTotal + " coins!!!");

         }
    }

    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount){
        //need 2d array, how many rows and collumns
        int rowCount = denominations.length;
        int columnCount = amount + 1;
        Tuple[][] tupleArray = new Tuple[rowCount][columnCount];
        //optimal solution always int he last cell
        int coin;
        //int difference; //TODO replace column - coin
        Tuple currentRC;
        for (int r = 0; r < rowCount; r++) {
            coin = denominations[r];
            for (int c = 0; c < columnCount; c++){
                currentRC = new Tuple(columnCount);
                if (c == 0){
                    tupleArray[r][c] = new Tuple(rowCount);
                } else {
                    if (r == 0){
                        if (coin > c || c % coin != 0){
                            tupleArray[r][c] = Tuple.IMPOSSIBLE;
                        } else {
                            currentRC.setElement(r, 1);
                            tupleArray[r][c] = currentRC.add(tupleArray[r][c - coin]);
                        }
                    } else {
                        if (coin > c) {
                            tupleArray[r][c] = tupleArray[r - 1][c];
                        } else {
                            if (tupleArray[r][c - coin].equals(Tuple.IMPOSSIBLE)){
                                tupleArray[r][c] = Tuple.IMPOSSIBLE;
                            }
                            else{
                                currentRC.setElement(r,1);
                                tupleArray[r][c] = currentRC.add(tupleArray[r][c - coin]);
                            }
                        }
                        if ((tupleArray[r - 1][c].total() < tupleArray[r][c].total() && !(tupleArray[r-1][c].equals(Tuple.IMPOSSIBLE)))
                            || (tupleArray[r][c].equals(Tuple.IMPOSSIBLE) && tupleArray[r-1][c].total() > 0)){
                            tupleArray[r][c] = tupleArray[r-1][c];
                        }
                    }
                }
            }
        }
        return tupleArray[rowCount - 1][columnCount - 1];
    }
 }
