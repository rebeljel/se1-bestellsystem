package datamodel;

public class Customer {
	
	private final String id;
	private String firstName;
	private String lastName;
	private String contact;
	
	
	protected Customer(String id, String name, String contact) {
		this.id = id;
		this.lastName = name;
		this.firstName = "";
		this.contact = contact;
	}
	
	
	public String getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
//	public String getName() {
//		return firstName + ", " + lastName;
//	}
//	
//	public void setName(String name) {
//		if (name.split("\\w+").length > 1) {
//			lastName = name.substring(name.lastIndexOf(" ")+1);
//			firstName = name.substring(0, name.lastIndexOf(' '));
//		}
//		else {
//			this.firstName = name;
//		}
//		
//		if (firstName.contains(",")) {
//			String temp = "";
//			temp = lastName; 
//			String sName = name.substring(0, name.indexOf(',')+1).trim();
//			this.firstName = firstName.replace(sName, "").trim() + " " + temp;
//			lastName = "" + sName;
//			this.lastName = lastName.replaceAll(",", "");
//		}
//		
//		if (firstName.startsWith(" ")) {
//			this.firstName = firstName.replace(" ", "");
//		}
//		
//	}
	
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
