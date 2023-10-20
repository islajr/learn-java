class interest {
    public static void main (String[] args) {
        double principal;
        double rate;
        double interest;

        principal = 30000;
        rate = 0.07;
        interest = principal * rate;

        principal = principal + interest;

        System.out.print("The interest earned is NGN");
        System.out.println(interest);

        System.out.print("The value of the investment after one year is NGN");
        System.out.println(principal);
    }
}