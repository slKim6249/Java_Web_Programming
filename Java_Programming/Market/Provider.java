import java.util.ArrayList;
import java.util.List;

public class Provider {

	private int money;
	private List<Product> productList;

	public Provider(int money, List<Product> productList) {
		this.money = money;
		this.setProductList(productList); // Copy List
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
	
	
	/**
	 * 판매자가 도매상에게 구매한다
	 * @param provider
	 * @param product
	 * @param quantity
	 */
	public void buy(Provider provider, Product product, int quantity) {
		/*
		 * this == member (멤버변수, 메소드)
		 * this == Instance (객체) == 자신
		 */
		int amountPrice = provider.sell(product, quantity);
		// 구매금액 차감
		this.money = this.money - amountPrice;
		// 판매물건 추가
		Product boughtProduct = new Product(quantity, product.getPrice(), 
											product.getName());
		this.productList.add( boughtProduct );
	}
	
	/**
	 * 도매상이 판매자에게 판매함
	 * @param provider = 도매상
	 * @param product
	 * @param quantity
	 * @return 판매금액
	 */
	public int sell(Product product, int quantity) {
		
		/*
		 * productList
		 * Product(수량, 가격, 이름)
		 * Product(10, 10000, 수박)
		 * Product(5, 5000, 수박)
		 * Product(2, 1000, 배)
		 * 
		 * Argument product
		 * Product(0, 10000, 수박)
		 * 
		 * Argument quantity
		 * 2
		 * 
		 */
		
		// 판매 물건 감소
		for (int i=0; i<this.productList.size(); i++) {
			// productList의 요소 하나
			Product oneProduct = this.productList.get(i);
			// 전달받은 정보와 같은 것을 가진 Product 확인(가격, 이름)
			if ( oneProduct.getName().equals(product.getName()) 
					&& oneProduct.getPrice() == product.getPrice()) {
				
				// 구매 수량만큼 재고 감소
				int productQuantity = oneProduct.getQuantity();
				productQuantity = productQuantity - quantity;
				oneProduct.setQuantity(productQuantity);
				
				// 판매 금액
				int amountPrice = product.getPrice() * quantity;
				// 판매자의 금액 증가
				this.money = this.money + amountPrice;
				
				// 구매금액 반환
				return amountPrice;
				
			}
		}
		// 없으면 0
		return 0;
	}
	
	public void showStock() {
		for (Product product : this.productList) {
			System.out.printf("제품명 : %s, 가격 : %d, 재고 : %d\n",
								product.getName(), product.getPrice(),
								product.getQuantity());
		}
		
		System.out.println("보유 금액 : " + this.money);
	}

}
