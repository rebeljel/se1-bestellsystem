package datamodel;

public class Customer {
	
	private final String id;
	private String firstName;
	private String lastName;
	private String contact;
	
	
	protected Customer(String id, String name, String contact) {
		this.id = id;
		if (name == null) {
			lastName = "";
		}
		else {
			this.lastName = name;
		}
		this.firstName = "";
		if (contact == null) {
			this.contact = "";
		}
		else {
			this.contact = contact;
		}
	}
	
	
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null) {
			this.firstName = "";
		}
		else {
			this.firstName = firstName;
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null) {
			this.lastName = "";
		}
		else {
			this.lastName = lastName;
		}
		
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
		if (contact == null) {
			this.contact = "";
		}
		else {
			this.contact = contact;
		}
	}
	
	
}
