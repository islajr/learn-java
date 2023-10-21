import java.util.Random;;

class MyFirstApp {
	public static void main (String[] args) {
		String[] wordlistOne = {"agnostic", "opinionated",
		"voice activated", "haptically driven", "extensible",
		"reactive", "agent based", "functional", "AI enabled",
		"strongly typed"};

		String[] wordlistTwo = {"loosely coupled", "six sigma",
		"asynchronous", "event driven", "pub-sub", "IoT", "cloud native", 
		"service oriented", "containerized", "serverless",
		"microservices", "distributed ledger"};
		String[] wordlistThree = {"framework", "library",
		"DSL", "REST API", "repository", "pipeline", "service mesh", 
		"architecture", "perspective", "design",
		"orientation"};

		int lengthOne = wordlistOne.length;
		int lengthTwo = wordlistTwo.length;
		int lengthThree = wordlistThree.length;

		// Generate three random numbers
		Random generator = new Random();
		int random1 = generator.nextInt(lengthOne);
		int random2 = generator.nextInt(lengthTwo);
		int random3 = generator.nextInt(lengthThree);

		// Build a phrase
		String Phrase = wordlistOne[random1] + " " + wordlistTwo[random2] + " " + wordlistThree[random3];

		// Print the phrase
		System.out.println(Phrase);
	}
}