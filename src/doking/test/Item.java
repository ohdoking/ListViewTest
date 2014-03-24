package doking.test;

import java.util.Date;

public class Item {


	String name;
	Date addedDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Item(String name, Date addedDate) {
		super();
		this.name = name;
		this.addedDate = addedDate;
	}
	
	
}
