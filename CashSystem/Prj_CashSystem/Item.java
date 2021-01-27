
public class Item {

	String name, date;
	int code, qty, prize, discount, id;
	
	public Item(int pid, String pname, int pcode, int pqty, int pprize, int pdiscount, String pdate){
		id = pid;
		name = pname;
		code = pcode;
		qty = pqty;
		prize = pprize;
		discount = pdiscount;
		date = pdate;
	}
	
	public Item(String pname, int pcode, int pqty, int pprice, int pdiscount){
		name = pname;
		code = pcode;
		qty = pqty;
		prize = pprice;
		discount = pdiscount;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCode(){
		return code;
	}
	
	public int getQty(){
		return qty;
	}
	
	public int getPrize(){
		return prize;
	}
	
	public int getDiscount(){
		return discount;
	}
	
	public String getDate(){
		return date;
	}
	
}
