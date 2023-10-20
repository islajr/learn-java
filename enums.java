class test 
{
    enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
    enum Month {JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC};
    public static void main (String[] args) {
        Day tgif = Day.FRIDAY;
        Month taurus = Month.MAY;

        System.out.println("My sign is taurus, since i was born in " + taurus + ".");
        System.out.println("That's the " + taurus.ordinal() + "th month of the year.");
       
    }
}

/**
 * Enums are some sort of outdated list or arrays that i still can't find a need for.
 * However, java seems to think they are useful and i have to trust that.
 * 
 * They are to be defined outside of the "main" function and do not contain an assignment operator (=).
 * By convention, their values are written in all caps and while the values themselves are not variables (they are constants), they can be attached to variables and when they are printed, they provide the literal value of the enum value they represent (not surprising!).
 * 
 * What's more interesting about this is that the index number of the referenced enum value can be obtained by calling the .ordinal() function attached automatically to every variable referencing an enum value.
 */