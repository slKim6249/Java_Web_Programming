import java.util.ArrayList;
import java.util.List;

public class Consumer {

	private int money;
	private List<Product> productList;
	
	public Consumer(int money) {
		this.money = money;
		this.productList = new ArrayList<Product>();
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Product> getProductList() {
		List<Product> productListCopy = new ArrayList<Product>();
		productListCopy.addAll(this.productList);
		return productListCopy;
	}

	public void setProductList(List<Product> productList) {
		this.productList = new ArrayList<Product>();
		this.productList.addAll(productList);
	}
	
	public void buy(Provider provider, Product product, int quantity) {
		int amountPrice = provider.sell(product, quantity);
		
		this.money -= amountPrice;
		
		Product boughtProduct = new Product(quantity, product.getPrice(),
											product.getName());
		
		this.productList.add(boughtProduct);
	}
	
	
	public void showCart() {
		for (Product product : this.productList) {
			System.out.printf("제품명 : %s, 가격 : %d, 재고 : %d\n",
								product.getName(), product.getPrice(),
								product.getQuantity());
		}
		
		System.out.println("보유 금액 : " + this.money);
	}

}
