/**
 *  File name     :  CalendarStuff.java
 *  Author        :  <Ayla>
 *  Description   :  This file provides the supporting methods for the CountTheDays program which will
 *                   calculate the number of days between two dates.  It shows the use of modularization
 *                   when writing Java code, and how the Java compiler can "figure things out" on its
 *                   own at "compile time".  It also provides examples of proper documentation, and uses
 *                   the source file header template as specified in the "Greeter.java" template program
 *                   file for use in CMSI 186, Spring 2017.
 */
public class CalendarStuff {

  /**
   * A listing of the days of the week, assigning numbers; Note that the week arbitrarily starts on Sunday
   */
   private static final int SUNDAY    = 0;
   private static final int MONDAY    = SUNDAY    + 1;
   private static final int TUESDAY   = MONDAY    + 1;
   private static final int WEDNESDAY = TUESDAY   + 1;
   private static final int THURSDAY  = WEDNESDAY + 1;
   private static final int FRIDAY    = THURSDAY  + 1;
   private static final int SATURDAY  = FRIDAY    + 1;

  // you can finish the rest on your own

  /**
   * A listing of the months of the year, assigning numbers; I suppose these could be ENUMs instead, but whatever
   */
   private static final int JANUARY    = 0;
   private static final int FEBRUARY   = JANUARY   + 1;
   private static final int MARCH      = FEBRUARY  + 1;
   private static final int APRIL      = MARCH     + 1;
   private static final int MAY        = APRIL     + 1;
   private static final int JUNE       = MAY       + 1;
   private static final int JULY       = JUNE      + 1;
   private static final int AUGUST     = JULY      + 1;
   private static final int SEPTEMBER  = AUGUST    + 1;
   private static final int OCTOBER    = SEPTEMBER + 1;
   private static final int NOVEMBER   = OCTOBER   + 1;
   private static final int DECEMBER   = NOVEMBER  + 1;
  // you can finish these on your own, too

  /**
   * An array containing the number of days in each month
   *  NOTE: this excludes leap years, so those will be handled as special cases
   *  NOTE: this is optional, but suggested
   */
   private static int[]    days        = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  /**
   * The constructor for the class
   */
   public CalendarStuff() {
      System.out.println( "constructor called." );  // replace this with the actual code
   }

  /**
   * A method to determine if the year argument is a leap year or not<br />
   *  Leap years are every four years, except for even-hundred years, except for every 400
   * @param    year  long containing four-digit year
   * @return         boolean which is true if the parameter is a leap year
   */
   public static boolean isLeapYear( long year ) {
      return ((year % 4 == 0) && (year %100 != 0) || (year % 400 == 0));
        // replace this with the actual code
   }

  /**
   * A method to calculate the days in a month, including leap years
   * @param    month long containing month number, starting with "1" for "January"
   * @param    year  long containing four-digit year; required to handle Feb 29th
   * @return         long containing number of days in referenced month of the year
   * notes: remember that the month variable is used as an indix, and so must
   *         be decremented to make the appropriate index value
   */
   public static long daysInMonth( long month, long year ) {
       if (month == 2 && isLeapYear(year)) {
           return 29;
       }
       return days[(int) month - 1];


      // if (month == 2 && ! isLeapYear (year)) {
      //    return 28;
      // } else if (month == 2 && isLeapYear (year)) {
      //   return 29;
      //   // replace this with the actual code
      // }
  }

  /**
   * A method to determine if two dates are exactly equal
   * @param    month1 long    containing month number, starting with "1" for "January"
   * @param    day1   long    containing day number
   * @param    year1  long    containing four-digit year
   * @param    month2 long    containing month number, starting with "1" for "January"
   * @param    day2   long    containing day number
   * @param    year2  long    containing four-digit year
   * @return          boolean which is true if the two dates are exactly the same
   */
   public static boolean dateEquals( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       // if (month1 == month2 && day1 == day2 && year1 == year2){
       //     return true;
       // } else {
       //     return false;
       // }

       return month1 == month2 && day1 == day2 && year1 == year2;
   }

  /**
   * A method to compare the ordering of two dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          int    -1/0/+1 if first date is less than/equal to/greater than second
   */
   public static int compareDate( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       if (dateEquals( month1, day1, year1, month2, day2, year2 )) {
           return 0;
       }
       if (year1 > year2 ) {
           return 1;
       } else if (year1 < year2) {
           return -1;
       } else {
           if (month1 > month2) {
               return 1;
           } else if (month1 < month2) {
               return -1;
           } else {
               if (day1 > day2) {
                   return 1;
               } else {
                   return -1;
               }
           }
       }
         // replace this with the actual code
   }

  /**
   * A method to return whether a date is a valid date
   * @param    month long    containing month number, starting with "1" for "January"
   * @param    day   long    containing day number
   * @param    year  long    containing four-digit year
   * @return         boolean which is true if the date is valid
   * notes: remember that the month and day variables are used as indices, and so must
   *         be decremented to make the appropriate index value
   */
   public static boolean isValidDate( long month, long day, long year ) {
       if (year < 0) {
           return false;
       }
       if (month < 1 || month > 12) {
           return false;
       }
       int daysOfTheMonth = (int) daysInMonth(month, year);
       if (day < 1 || day > daysOfTheMonth) {
           return false;
       }
       return true;

       /*
       if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ) && day <=31) {
          return true;
       }
       if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30) {
          return true;

       }
       if (year >= 0) {
           return true;
       }
       return false;
       */
   }

  /**
   * A method to return a string version of the month name
   * @param    month long   containing month number, starting with "1" for "January"
   * @return         String containing the string value of the month (no spaces)
   */
   public static String toMonthString( int month ) {
       String theMonth = "";
       switch( month - 1 ) {
           case JANUARY:
                theMonth = "January";
                break;
           case FEBRUARY:
                theMonth = "February";
                break;
           case MARCH:
                theMonth = "March";
                break;
           case APRIL:
                theMonth = "April";
                break;
           case MAY:
                theMonth = "May";
                break;
           case JUNE:
                theMonth = "June";
                break;
           case JULY:
                theMonth = "July";
                break;
           case AUGUST:
                theMonth = "August";
                break;
           case SEPTEMBER:
                theMonth = "September";
                break;
           case OCTOBER:
                theMonth = "October";
                break;
           case NOVEMBER:
                theMonth = "November";
                break;
           case DECEMBER:
                theMonth = "December";
                break;

           default: throw new IllegalArgumentException( "Illegal month value given to 'toMonthString()'." );
       }
       return theMonth;
   }

  /**
   * A method to return a string version of the day of the week name
   * @param    day int    containing day number, starting with "1" for "Sunday"
   * @return       String containing the string value of the day (no spaces)
   */
   public static String toDayOfWeekString( int day ) {
       String theDay = "";
       switch( day - 1 ) {
           case SUNDAY:
                theDay = "Sunday";
                break;
           case MONDAY:
                theDay = "Monday";
                break;
           case TUESDAY:
                theDay = "Tuesday";
                break;
           case WEDNESDAY:
                theDay = "Wednesday";
                break;
           case THURSDAY:
                theDay = "Thursday";
                break;
           case FRIDAY:
                theDay = "Friday";
                break;
           case SATURDAY:
                theDay = "Saturday";
                break;

           default       : throw new IllegalArgumentException( "Illegal day value given to 'toDayOfWeekString()'." );
       }
       return theDay;
   }

  /**
   * A method to return a count of the total number of days between two valid dates
   * @param    month1 long   containing month number, starting with "1" for "January"
   * @param    day1   long   containing day number
   * @param    year1  long   containing four-digit year
   * @param    month2 long   containing month number, starting with "1" for "January"
   * @param    day2   long   containing day number
   * @param    year2  long   containing four-digit year
   * @return          long   count of total number of days
   */
   public static long daysBetween( long month1, long day1, long year1, long month2, long day2, long year2 ) {
       if (compareDate( month1, day1, year1, month2, day2, year2 ) == 1) {
           long tempMonth = month1;
           month1 = month2;
           month2 = tempMonth;
           long tempDay = day1;
           day1 = day2;
           day2 = tempDay;
           long tempYear = year1;
           year1 = year2;
           year2 = tempYear;  // this is for if the first date is later than the second
       }
       long dayCount = 0;
       while (!dateEquals(month1, day1, year1, month2, day2, year2)) {
           dayCount++;
           // dayCount++; --> same as  dayCount = dayCount + 1; ++ means increase by 1
           day1++;
           if (!isValidDate(month1, day1, year1)) {
               month1++;
               day1 = 1;
               if (!isValidDate(month1, day1, year1)) {
                   year1++;
                   month1 =1;
                   // day1 = 1; -- You dont need it bc you already did it up there
               }
           }

       }
       return dayCount;
   }
}
