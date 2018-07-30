import java.util.ArrayList;
import java.util.List;

public class DrinkConsumer {

	private int money;
	private List<DrinkProduct> drinkProductList;
	
	public DrinkConsumer(int money) {
		this.money = money;
		this.drinkProductList = new ArrayList<DrinkProduct>();
		System.out.println("구매 전 고객 상황");
		System.out.println("보유 금액 : " + this.money + "\n");
	}
	
	public void buy(DrinkProvider drinkProvider, int price, String name) {
		DrinkProduct drinkProduct = new DrinkProduct(price, name);
		int amountPrice = drinkProvider.sell(drinkProduct);
		// 구매금액 차감
		this.money -= amountPrice;
		// 판매물건 추가
		DrinkProduct boughtProduct = new DrinkProduct( drinkProduct.getPrice(), 
											drinkProduct.getName() );
		this.drinkProductList.add( boughtProduct );
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<DrinkProduct> getDrinkProductList() {
		List<DrinkProduct> drinkProductListCopy = new ArrayList<DrinkProduct>();
		drinkProductListCopy.addAll(this.drinkProductList);
		return drinkProductListCopy;
	}

	public void setDrinkProductList(List<DrinkProduct> drinkProductList) {
		this.drinkProductList = new ArrayList<DrinkProduct>();
		this.drinkProductList.addAll(drinkProductList);
	}
	
	public void showCart() {
		System.out.println("구매 후 고객 상황");
		for (DrinkProduct drinkProduct : drinkProductList) {
			System.out.printf("음료명 : %s, 가격 : %d\n",
								drinkProduct.getName(),
								drinkProduct.getPrice());
		}
		System.out.println("보유 금액 : " + this.money + "\n");
	}

}
