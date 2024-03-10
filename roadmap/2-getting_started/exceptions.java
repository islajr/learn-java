class exceptions {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        // here, this method will not run because of the possibility of the sleep being interrupted and hence, this expression needs to cater for the potential InterruptedException.
    }
}