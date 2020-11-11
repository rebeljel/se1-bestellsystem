package datamodel;

public class Article {
	private String id;
	private String description;
	private long unitPrice;
	private int unitsInStore;
	
	protected Article(String id, String description, long price, int units) {
		this.description = description;
		this.id = id;
		this.unitPrice = price;
		this.unitsInStore = units;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(long price) {
		this.unitPrice = price;
	}
	
	public int getUnitsInStore() {
		return unitsInStore;
	}
	
	public void setUnitsInStore(int number) {
		this.unitsInStore = number;
	}
	
}
