import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

    /**
    * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
    * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
    * it gets included.
    *
    * @param s String containing the data to be checked for &quot;vowel-ness&quot;
    * @return  boolean which is true if there is a vowel, or false otherwise
    */
    public static boolean containsVowel( String s ) {
        String s2 = s.toLowerCase();
        //s2 = s.toLowerCase(); -- dont fuck with the original param

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == 'a' || s2.charAt(i) == 'e' || s2.charAt(i) == 'i' ||
            s2.charAt(i) == 'o' || s2.charAt(i) == 'u' || s2.charAt(i) == 'y') {
                return true;
            }
        }
        return false;
//use the s2 so you dont have to check the cap letters

       // return !(s.indexOf('a') < 0 && s.indexOf('e') && s.indexOf('i') < 0 && s.indexOf('o') < 0 &&  s.indexOf('u') < 0 && s.indexOf('y') < 0);
    }
// make string all lowercase method
    /**
    * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
    * the first and last, second and last-but-one, etc. against each other.  If something doesn't
    * match that way, returns false, otherwise returns true.
    *
    * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
    * @return  boolean which is true if this a palindrome, or false otherwise
    */
    public static boolean isPalindrome( String s ) {
// two indexes --> front and back to move toowards each other
      if (s.length() == 0 || s.length() == 1)
        return false;
      int i = 0;
      int j = s.length() - 1;
      while (i != j && i < j ) {
        if (s.charAt(i) == s.charAt(j)) {
          i++; j--;
        }
        else
          return false;
      }
        return true;
    }

    /**
    * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
    * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
    * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
    *
    * @param s String containing the data to be parsed for &quot;even&quot; letters
    * @return  String containing the &quot;even&quot; letters from the input
    */
    public static String evensOnly( String s ) {
      String s2 = "";  //tkaing pieces of the string --> put it into s2 ean empty string
      for (int i = 0; i < s.length(); i++) {
        if ((int)s.charAt(i) % 2 == 0) // putting int infront truns it into the ascii value --> so you can check if its divisible by 2
            s2 = s2 + s.charAt(i); // add it to string
      }
      return s2;
      //  return new String( "HJHJHJ" );
    }

    /**
    * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
    * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
    * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
    *
    * @param s String containing the data to be parsed for &quot;odd&quot; letters
    * @return  String containing the &quot;odd&quot; letters from the input
    */
    public static String oddsOnly( String s ) {
      String s2 = "";
      for (int i = 0; i < s.length(); i++) {
        if ((int)s.charAt(i) % 2 == 1)
            s2 = s2 + s.charAt(i);
      }
      return s2;
      //  return new String( "IKIKIK" );
    }

    /**
    * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
    * numbers of the alphabet, but with no duplicate characters in the resulting string.
    *
    * @param s String containing the data to be parsed for &quot;even&quot; letters
    * @return  String containing the &quot;even&quot; letters from the input without duplicates
    */
    public static String evensOnlyNoDupes( String s ) {
      Set<Character> h = new LinkedHashSet<Character>();  //--initializing the hashset
      String s2 = "";  //tkaing pieces of the string --> put it into s2 ean empty string

      for (int i = 0; i < s.length(); i++) {
        if ((int)s.charAt(i) % 2 == 0) {
          if (!h.contains(s.charAt(i))) {
            s2 += s.charAt(i); // a += b means a + b so youre adding the chracter to the s2 string
            h.add(s.charAt(i));   // a set contains a bunch of characters and you need to add the character to the set so that it can tell you if it has showed up or not yet in the set
          }
      }
    }
      return s2;
  }

      //  return new String( "HJ" );


    /**
    * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
    * numbers of the alphabet, but with no duplicate characters in the resulting string.
    *
    * @param s String containing the data to be parsed for &quot;odd&quot; letters
    * @return  String containing the &quot;odd&quot; letters from the input without duplicates
    */
    public static String oddsOnlyNoDupes( String s ) {
      Set<Character> h = new LinkedHashSet<Character>();  //--initializing the hashset
      String s2 = "";  //tkaing pieces of the string --> put it into s2 ean empty string

      for (int i = 0; i < s.length(); i++) {
        if ((int)s.charAt(i) % 2 == 1) {
          if (!h.contains(s.charAt(i))) {
            s2 += s.charAt(i); // a += b means a + b so youre adding the chracter to the s2 string
            h.add(s.charAt(i));   // a set contains a bunch of characters and you need to add the character to the set so that it can tell you if it has showed up or not yet in the set
          }
      }
    }
    return s2;
  }

    /**
    * Method to return the reverse of a string passed as an argument
    *
    * @param s String containing the data to be reversed
    * @return  String containing the reverse of the input string
    */
    public static String reverse( String s ) {
      String s2 = "";
      for (int i = s.length() -1; i >= 0; i--) { // start at the end of the string; keep going while i>= 0; decriment i
        s2 = s2 += s.charAt(i);
      }
      return s2;
    }

    /**
    * Main method to test the methods in this class
    *
    * @param args String array containing command line parameters
    */
    public static void main( String args[] ) {
        String blah = new String( "Blah blah blah" );
        String woof = new String( "BCDBCDBCDBCDBCD" );
        String pal1 = new String( "a" );
        String pal2 = new String( "ab" );
        String pal3 = new String( "aba" );
        String pal4 = new String( "amanaplanacanalpanama" );
        String pal5 = new String( "abba" );
        System.out.println( containsVowel( blah ) );
        System.out.println( containsVowel( woof ) );
        System.out.println( isPalindrome( pal1 ) );
        System.out.println( isPalindrome( pal2 ) );
        System.out.println( isPalindrome( pal3 ) );
        System.out.println( isPalindrome( pal4 ) );
        System.out.println( isPalindrome( pal5 ) );
        System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
        System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
        System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearSALsz" ) );
        System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
        System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
        System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYloPHonES" ) );
        System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
    }
}
