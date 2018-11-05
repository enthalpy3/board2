package equipment;

import java.sql.Timestamp;

public class EquipInfo {
	private String equipname;
	private String username;
	private String model;
	private String state;
	private Timestamp reg_date;
	private int pk;
	
	public String getEquipname() {
		return equipname;
	}
	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
