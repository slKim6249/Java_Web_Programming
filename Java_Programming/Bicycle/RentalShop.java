
import java.util.ArrayList;
import java.util.List;

public class RentalShop {
	
	private final int PRICE = 1000;
	
	private List<Bicycle> bicycleList;
	
	public RentalShop( int size ) { // Shop의 bicycle 수
		bicycleList = new ArrayList<Bicycle>();
		
		for(int i=0; i < bicycleList.size(); i++) {
			Bicycle bicycle = new Bicycle();
			bicycle.setName("따릉이 " + (i + 1));
			this.bicycleList.add(bicycle);
		}
		
	}
	
	/**
	 * 대여
	 * @return
	 */
	public Bicycle rent() {
		Bicycle bicycle = bicycleList.get( bicycleList.size() - 1 );
		bicycleList.remove( bicycleList.size() - 1 );
		return bicycle;
	}
	
	/**
	 * 반납
	 */
	public void returnBycle() {
		Bicycle bicycle = new Bicycle();
		bicycle.setName("따릉이 " + bicycleList.size() + 1);
		bicycleList.add(bicycle);
	}
	
	/**
	 * 정산
	 * @param usageTime 시간단위
	 * @return
	 */
	public int billing( int usageTime ) {
		return usageTime * PRICE;
	}
	
	public boolean isPossible() {
		Bicycle bicycle = bicycleList.get( bicycleList.size() - 1 );
		if( bicycle == null ) {
			return false;
		} else {
			return true;
		}
	}
}
