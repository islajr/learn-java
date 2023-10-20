class interest {
    public static void main (String[] args) {
        double principal;
        double rate;
        double interest;

        principal = 30000;
        rate = 0.07;
        interest = principal * rate;

        principal = principal + interest;

        System.out.println("The interest earner is NGN" + interest + ".");
        System.out.println("The value of the investment after one year is NGN" + principal + ".");
    }
}