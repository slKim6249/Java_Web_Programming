import java.util.ArrayList;
import java.util.List;

public class Market {
	
	public static void main(String[] args) {
		
		List<Product> wholesalerProductList = new ArrayList<Product>();
		wholesalerProductList.add( new Product(1000, 500, "자두") );
		wholesalerProductList.add( new Product(1500, 1000, "참외") );
		wholesalerProductList.add( new Product(1100, 1100, "사과") );
		
		// 판매자
		Provider wholesaler = new Provider(100_000_000, wholesalerProductList);
		// 구매자
		Provider fruitSeller = new Provider(10_000_000, new ArrayList<Product>());
		
		fruitSeller.buy(wholesaler, new Product(0,  500, "자두"), 100);
		fruitSeller.buy(wholesaler, new Product(0,  1000, "참외"), 200);
		fruitSeller.buy(wholesaler, new Product(0,  1100, "사과"), 500);
		
		wholesaler.showStock();
		fruitSeller.showStock();
		
		Consumer consumer = new Consumer(5_000_000);
		consumer.buy(fruitSeller, new Product(0, 500, "자두"), 5);
		
		fruitSeller.showStock();
		consumer.showCart();
		
	}
	
}
