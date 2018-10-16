import java.util.Scanner;

public class Lab7validator {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String userPrompt = "Y";

		do {

			getStringMatchingRegex(scan, "Please enter your name starting with a capital letter: ",
					"^[A-Z]{1}[a-z]{1,29}$");
			//This gets the user's name. Capital letter to start and up to 29 additional lower case letters.
			getStringMatchingRegex(scan, "Please enter your phone number ###-###-####: ", "^\\d{3}\\-\\d{3}\\-\\d{4}$");
			//This gets the user's phone #. Each group of numbers is separated with a -.
			getStringMatchingRegex(scan, "Please enter your email email@domain.abc: ",
					"^[A-Za-z0-9]{5,30}\\@[A-Za-z0-9]{5,10}\\.[a-z]{2,3}$");
			//This gets the user's email address. 5-30 alphanumeric characters for the name, 5-10 for the domain and 2-3 for the .com.
			getStringMatchingRegex(scan, "Please enter the date in the following format YYYY/MM/DD: ",
					"^(\\d{4})\\/(0?[1-9]|1[012])\\/(0?[1-9]|[12][0-9]|3[01])$");
			//This gets the date. All numbers are acceptable for year while date is limited to 31 and month to 12.
			getStringMatchingRegex(scan, "Please enter a valid HTML element: ", "^\\<[a-z]\\>$");
			//This gets an HTML key.
			System.out.println("Press Y to repeat. Press any other key to quit.");
			//Prompts the user to continue.
			userPrompt = scan.nextLine();

		} while (userPrompt.equalsIgnoreCase("y"));

	}

	public static String getStringMatchingRegex(Scanner scan, String prompt, String regex) {
		//Each method call above has a scanner, user prompt and regex that corresponds here to validate the data.
		boolean isValid = false;
		String input;

		do {
			input = getString(scan, prompt); //Calls getString() which ensures that the user is inputing a String.
			if (input.matches(regex)) { //If the input matches the corresponding regex it will pass thru 'true' which will return the user to the next prompt.
				isValid = true;
			} else { //If the users input doesn't correspond it will spit out this prompt and continue the do/while loop.
				System.out.println("Input must match the right format, please try again.");
				isValid = false;
			}
		} while (!isValid);

		return input;
	}

	public static String getString(Scanner sc, String prompt) {
		//This confirms that the input is a String.
		System.out.print(prompt); 
		String s = sc.next(); 
		sc.nextLine(); 
		return s;
	}

}
