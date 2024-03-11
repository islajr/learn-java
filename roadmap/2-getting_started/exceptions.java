class exceptions {
    public static void main(String[] args)  {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException i) {
            System.out.println(i.getMessage());
        }
        // here, this method will not run because of the possibility of the sleep being interrupted and hence, this expression needs to cater for the potential InterruptedException.
    }
}