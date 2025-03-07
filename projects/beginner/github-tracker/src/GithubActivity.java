public class GithubActivity {
    public static ActivityTracker tracker = new ActivityTracker();
    public static void main(String[] args) {
        if (args.length < 1)
            System.out.println("Usage GithubActivity <username>");
        else {
            try {
                tracker.fetchData(args[0]);
            } catch (Exception e) {
                System.out.println("I'll tend to you later");
            }
        }
    }
}
