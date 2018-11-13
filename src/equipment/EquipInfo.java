package equipment;

import java.sql.Timestamp;

public class EquipInfo {
	private String equipname;
	private String username;
	private String model;
	private String state;
	private Timestamp reg_date;
	private String date;
	private String num;
	private Integer count;
	private String reg_date2;
	private String quantity;

	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getReg_date2() {
		return reg_date2;
	}
	public void setReg_date2(String reg_date2) {
		this.reg_date2 = reg_date2;
	}
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
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
