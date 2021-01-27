
public class cls_Employees {

	String name, em_id, phone, post;
	int salary, id;
	
	public cls_Employees() {
		
	}
	
	public cls_Employees(int id, String name, String em_id, String phone, String post, int salary){
		setId(id);
		setName(name);
		setEmId(em_id);
		setPhone(phone);
		setPost(post);
		setSalary(salary);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setEmId(String em_id){
		this.em_id = em_id;
	}
	
	public String getEmId(){
		return em_id;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPost(String post){
		this.post = post;
	}
	
	public String getPost(){
		return post;
	}
	
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	public int getSalary(){
		return salary;
	}
	
}
