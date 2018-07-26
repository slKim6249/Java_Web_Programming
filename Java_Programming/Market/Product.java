
public class Product {

	private int quantity;
	private int price;
	private String name;
	
	public Product(int quantity, int price, String name) {
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
