import java.util.ArrayList;
import java.util.List;

public class Drink {
	
	static DrinkConsumer customer = new DrinkConsumer(5000);
	static List<DrinkProduct> drinkSellar = new ArrayList<DrinkProduct>();
	static DrinkProvider drinkStore = new DrinkProvider(1000, drinkSellar);
	
	public static void showBeforeTranscationStatus() {
		
		drinkSellar.add( new DrinkProduct(1200, "스프라이트") );
		drinkSellar.add( new DrinkProduct(1200, "스프라이트") );
		drinkSellar.add( new DrinkProduct(1200, "스프라이트") );
		drinkSellar.add( new DrinkProduct(1200, "코카콜라") );
		drinkSellar.add( new DrinkProduct(1200, "코카콜라") );
		drinkSellar.add( new DrinkProduct(1200, "코카콜라") );
	}
	
	public static void showAfterTransacrionStatus() {
		customer.showCart();
		drinkStore.showStock();
	}
	
	public void run() {
		
		showBeforeTranscationStatus();
		
		customer.buy(this.drinkStore, 1200, "코카콜라");
		customer.buy(this.drinkStore, 1200, "코카콜라");
		
		showAfterTransacrionStatus();
	}

	public static void main(String[] args) {
		
		new Drink().run();
		
	}

}
