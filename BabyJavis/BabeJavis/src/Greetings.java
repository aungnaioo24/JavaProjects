import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Greetings {
	
	Random generator;
	String[] greetReplies = {"Hello Boss", "Hi Boss", "Hello Sir", "Hi Sir"};
			
	public Greetings() {
		
		generator = new Random();
		
	}
	
	public void replyGreeting() {
		
		int replyIndex = generator.nextInt(greetReplies.length);
		System.out.println(greetReplies[replyIndex]);
		
	}
	
	public void replyGTime(String gTime) {
		
		if(gTime.equals("good morning")) {
			
			GregorianCalendar time = new GregorianCalendar();
			int hour = time.get(Calendar.HOUR_OF_DAY);
			
			if (hour < 12)
				   System.out.println("Good Morning Sir!");
			else if (hour < 17 && !(hour == 12))
				   System.out.println("Sir! it's afternoon. Good Afternoon Sir!");
			else if (hour == 12)
				   System.out.println("Sir! it's noon. Good Noon Sir!");
			else
				   System.out.println("Sir! it's evening. Good Evening Sir!");
		
		}
		
		if(gTime.equals("good noon")) {
			
			GregorianCalendar time = new GregorianCalendar();
			int hour = time.get(Calendar.HOUR_OF_DAY);
			
			if (hour < 12)
				   System.out.println("Sir! it's morning. Good Morning Sir!");
			else if (hour < 17 && !(hour == 12))
				   System.out.println("Sir! it's afternoon. Good Afternoon Sir!");
			else if (hour == 12)
				   System.out.println("Good Noon Sir!");
			else
				   System.out.println("Sir! it's evening. Good Evening Sir!");
		
		}
		
		if(gTime.equals("good afternoon")) {
			
			GregorianCalendar time = new GregorianCalendar();
			int hour = time.get(Calendar.HOUR_OF_DAY);
			
			if (hour < 12)
				   System.out.println("Sir! it's morning. Good Morning Sir!");
			else if (hour < 17 && !(hour == 12))
				   System.out.println("Good Afternoon Sir!");
			else if (hour == 12)
				   System.out.println("Sir! it's noon. Good Noon Sir!");
			else
				   System.out.println("Sir! it's evening. Good Evening Sir!");
		
		}
		
		if(gTime.equals("good evening")) {
			
			GregorianCalendar time = new GregorianCalendar();
			int hour = time.get(Calendar.HOUR_OF_DAY);
			
			if (hour < 12)
				   System.out.println("Sir! it's morning. Good Morning Sir!");
			else if (hour < 17 && !(hour == 12))
				   System.out.println("Sir! it's afternoon. Good Afternoon Sir!");
			else if (hour == 12)
				   System.out.println("Sir! it's noon. Good Noon Sir!");
			else
				   System.out.println("Good Evening Sir!");
		
		}
		
		if(gTime.equals("good night")) {
			
			GregorianCalendar time = new GregorianCalendar();
			int hour = time.get(Calendar.HOUR_OF_DAY);
			
			if (hour < 12)
				   System.out.println("Sir! it's morning. Good Morning Sir!");
			else if (hour < 17 && !(hour == 12))
				   System.out.println("Sir! it's afternoon. Good Afternoon Sir!");
			else if (hour == 12)
				   System.out.println("Sir! it's noon. Good Noon Sir!");
			else
				   System.out.println("Good Night Sir!");
		
		}
		
	}
	
}
