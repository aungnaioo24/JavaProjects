
public class PositionGetSet {
	
	String pos, posID;
	int posSal, posTBonus, posLBonus, id;
	
	PositionGetSet(int id, String pos, String posID, int posSal, int posTBonus, int posLBonus){
		setId(id);
		setPosition(pos);
		setPosId(posID);
		setPosSal(posSal);
		setPosTBonus(posTBonus);
		setPosLBonus(posLBonus);
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setPosition(String pos){
		this.pos = pos;
	}
	
	public String getPosition(){
		return pos;
	}
	
	public void setPosId(String posID){
		this.posID = posID;
	}
	
	public String getPosId(){
		return posID;
	}
	
	public void setPosSal(int posSal){
		this.posSal = posSal;
	}
	
	public int getPosSal(){
		return posSal;
	}
	
	public void setPosTBonus(int posTBonus){
		this.posTBonus = posTBonus;
	}
	
	public int getPosTBonus(){
		return posTBonus;
	}
	
	public void setPosLBonus(int posLBonus){
		this.posLBonus = posLBonus;
	}
	
}
