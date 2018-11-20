package post;

import java.sql.Timestamp;

public class PostInfo {
	private String id;
	private String name;
	private String title;
	private String text;
	private Timestamp reg_date;
	private String pk;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPk() {
		return pk;
	}

	public void setPk(String string) {
		this.pk = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	/*public PostInfo(String id, String name, String title, String text, Timestamp reg_date, String pk) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.text = text;
		this.reg_date = reg_date;
		this.pk = pk;
	}*/
}
