import java.text.NumberFormat;


public class test {

	public static void main(String[] args) {
		
		String str = "55";
		
		String i = NumberFormat.getCurrencyInstance().format(Integer.parseInt(str));
		System.out.println(i);
	}

}
