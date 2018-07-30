import java.util.ArrayList;
import java.util.List;

public class DrinkProvider {

	private int money;
	private List<DrinkProduct> drinkProductList;

	public DrinkProvider(int money, List<DrinkProduct> drinkProduct) {
		this.money = money;
		this.setProductList(drinkProduct);
		System.out.println("구매 전 자판기 상황");
		showStock();
		System.out.println("\n");
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<DrinkProduct> getProductList() {
		List<DrinkProduct> drinkProductListCopy = new ArrayList<DrinkProduct>();
		drinkProductListCopy.addAll(this.drinkProductList);
		return drinkProductListCopy;
	}

	public void setProductList(List<DrinkProduct> drinkProductList) {
		this.drinkProductList = new ArrayList<DrinkProduct>();
		this.drinkProductList.addAll(drinkProductList);
	}
	
	
	public void buy(DrinkProvider drinkProvider, DrinkProduct drinkProduct) {
		
		int amountPrice = drinkProvider.sell(drinkProduct);
		// 구매금액 차감
		this.money -= amountPrice;
		// 판매물건 추가
		DrinkProduct boughtProduct = new DrinkProduct( drinkProduct.getPrice(), 
											drinkProduct.getName() );
		this.drinkProductList.add( boughtProduct );
		
	}
	
	public int sell( DrinkProduct drinkProduct ) {
		for(int i=0; i < this.drinkProductList.size(); i++) {
			DrinkProduct oneDrinkProduct = this.drinkProductList.get(i);
			
			if( oneDrinkProduct.getName().equals(drinkProduct.getName())
					&& oneDrinkProduct.getPrice() == drinkProduct.getPrice()) {
				
				// 판매자의 금액 증가
				this.money += drinkProduct.getPrice();
				
				// 구매금액 반환
				return drinkProduct.getPrice();
				
			}
			
		}
		return 0;
	}
	
	public void showStock() {
		System.out.println("구매 후 자판기 상황");
		for (DrinkProduct drinkProduct : this.drinkProductList) {
			System.out.printf("음료명 : %s, 가격 : %d\n",
								drinkProduct.getName(), drinkProduct.getPrice());
		}
		System.out.println("보유 금액 : " + this.money);
	}
	

}
