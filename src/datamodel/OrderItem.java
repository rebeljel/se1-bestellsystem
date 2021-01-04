package datamodel;

public class OrderItem {
	private String description;
	private final Article article;
	private int unitsOrdered;
	
	protected OrderItem(String description, Article article, int unitsOrdered) {
		if (description == null) {
			this.description = "";
		}
		else {
			this.description = description;
		}
		this.article = article;
		if (unitsOrdered < 0) {
			this.unitsOrdered = 0;
		}
		else {
			this.unitsOrdered = unitsOrdered;
		}
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
	
	public Article getArticle() {
		return article;
	}
	
	public int getUnitsOrdered() {
		return unitsOrdered;
	}
	
	public void setUnitsOrdered(int number) {
		if (number < 0) {
			this.unitsOrdered = 0;
		}
		else {
			this.unitsOrdered = number;
		}
	}
	
}