import java.util.Scanner;

public class Chat{
	
	public Chat() { //constructor
		System.out.println("Start Baby Javis");
	}
	
	public void startChat() {
		
		Scanner scan = new Scanner(System.in);
		String userIn = "";
		String[] exitArr = {"exit", "quit", "close the program", "shutdown"};
		String[] greetArr = {"hi", "hello", "hey"};
		String [] gTimeArr = {"good morning", "good afternoon", "good noon", "good evening", "good night"};
		
		int infLoop = 0;
		while(infLoop>=0) {
			
			userIn = scan.nextLine().trim().toLowerCase();
			String firstWord = firstWord(userIn);
			String firstTwoWord = firstTwoWord(userIn);

			if(userIn.equals("baby javis")||userIn.equals("javis")||userIn.equals("babyjavis")) {
				Greetings greetings = new Greetings();
				System.out.println("Yes Boss");
			}
			
			for(int exitIndex=0; exitIndex<exitArr.length; exitIndex++) {
				if(userIn.equals(exitArr[exitIndex])) {
					exitProgram();
				}
			}
			
			for(int greetIndex=0; greetIndex<greetArr.length; greetIndex++) {
				if(firstWord.equals(greetArr[greetIndex])) {
					Greetings greetings = new Greetings();
					greetings.replyGreeting();
				}
			}
			
			for(int gTimeIndex=0; gTimeIndex<gTimeArr.length; gTimeIndex++) {
				if(firstTwoWord.equals(gTimeArr[gTimeIndex])) {
					Greetings greetings = new Greetings();
					greetings.replyGTime(firstTwoWord);
				}
			}
			
		}
		
	}
	
	private void exitProgram() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Are you sure to close the program? (y/n)");
		char input = scan.next().trim().toLowerCase().charAt(0);
		if(input == 'y')
			System.exit(0); //close the entire program
	}

	private String firstWord(String input) {
		
		for(int i=0; i<input.length(); i++) {
			
			if(input.charAt(i)==' ') {
				input = input.substring(0, i);
				break;
			}
			
		}
		
		return input;
	}
	
	private String firstTwoWord(String input) {
		
		int count = 0;
		for(int i=0; i<input.length(); i++) {
			
			if(input.charAt(i)==' ') {
				count++;
				if(count == 1)
					continue;
				
				input = input.substring(0, i);
				break;
			}
			
		}
		
		return input;
	}
	
}
