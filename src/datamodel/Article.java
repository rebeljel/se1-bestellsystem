package datamodel;

public class Article {
	private String id;
	private String description;
	private long unitPrice;
	private int unitsInStore;
	
	protected Article(String id, String description, long price, int units) {
		if (description == null) {
			this.description = "";
		}
		else {
			this.description = description;
		}
		
		this.id = id;
		
		if (price < 0) {
			this.unitPrice = 0;
		}
		else {
			this.unitPrice = price;
		}

		if (units < 0) {
			this.unitsInStore = 0;
		}
		else {
			this.unitsInStore = units;
		}

	}
	
	public String getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if (description == null) {
			this.description = "";
		}
		else {
			this.description = description;
		}
	}
	
	public long getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(long price) {
		if (price == Long.MAX_VALUE || price < 0) {
			this.unitPrice = 0;
		}
		else {
			this.unitPrice = price;
		}
		
	}
	
	public int getUnitsInStore() {
		return unitsInStore;
	}
	
	public void setUnitsInStore(int number) {
		if (number == Integer.MAX_VALUE || number < 0) {
			this.unitsInStore = 0;
		}
		else {
			this.unitsInStore = number;
		}
	}
	
}
