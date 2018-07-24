package Object;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

	private int healthPoint;
	private int manaPoint;
	private int damagePoint;

	private List<String> healthPotionList;
	private List<String> manaPotionList;

	public GameObject() {
		System.out.println("생성자 호출");
		this.healthPoint = 30;
		this.manaPoint = 50;
		this.damagePoint = 2;
		
		this.healthPotionList = new ArrayList<String>();
		this.healthPotionList.add("HP 포션");
		this.healthPotionList.add("HP 포션");
		this.healthPotionList.add("HP 포션");
		this.healthPotionList.add("HP 포션");
		
		this.manaPotionList = new ArrayList<String>();
		this.manaPotionList.add("MP 포션");
		this.manaPotionList.add("MP 포션");
		this.manaPotionList.add("MP 포션");
		this.manaPotionList.add("MP 포션");
		
	}
	
	
	/**
	 * Constructer Overloading
	 * 생성자 오버로딩 => 같은 이름을 가진 메소드이지만,
	 * 아큐먼츠가 다른 경우다
	 * @param healthPoint
	 * @param manaPoint
	 * @param damagePoint
	 */
	public GameObject(int healthPoint, 
						int manaPoint,
						int damagePoint) {
		
		this(); // 기본 생성자 호출
		this.healthPoint = healthPoint;
		this.manaPoint = manaPoint;
		this.damagePoint = damagePoint;
		
	}

	public int getDamagePoint() {
		return damagePoint;
	}

	public void setDamagePoint(int damagePoint) {
		this.damagePoint = damagePoint;
	}

	public List<String> getHealthPotionList() {
		
		List<String> healthPotionListCopy = 
				new ArrayList<String>();
		healthPotionListCopy.addAll(this.healthPotionList);
		
		return healthPotionListCopy;
	}

	public void setHealthPotionList(List<String> healthPotionList) {
		this.healthPotionList = new ArrayList<String>();
		this.healthPotionList.addAll(healthPotionList);
	}

	public List<String> getManaPotionList() {
		List<String> manaPotionListCopy = 
				new ArrayList<String>();
		manaPotionListCopy.addAll(this.manaPotionList);
		return manaPotionListCopy;
	}

	public void setManaPotionList(List<String> manaPotionList) {
		this.manaPotionList = new ArrayList<String>();
		this.manaPotionList.addAll(manaPotionList);
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	public int getManaPoint() {
		return manaPoint;
	}

	/**
	 * 피해간다
	 */
	void run() {
		System.out.println("피해가기");
	}

	/**
	 * 때린다 ( 일반 공격 )
	 */
	void attack() {
		System.out.println(damagePoint + "만큼 공격합니다.");
	}

	/**
	 * 때린다 ( 스킬 공격 )
	 */
	int skillAttack() {
		System.out.println("마나를 사용해 스킬 공격을 합니다.");
		manaPoint = manaPoint - 10;
		return manaPoint;
	}

	/**
	 * 맞는다
	 */
	int beAttack(int damage) {
		System.out.println("상대에게 맞습니다.");
		healthPoint = healthPoint - damage;
		return healthPoint;
	}

	/**
	 * MP 물약을 먹는다
	 */
	void useManaPotion() {
		if (manaPotionList.size() > 0) {
			manaPotionList.remove(0);
			manaPoint = manaPoint + 20;
		}
	}

	/**
	 * HP 물약을 먹는다
	 */
	void useHealthPotion() {
		if (healthPotionList.size() > 0) {
			healthPotionList.remove(0);
			healthPoint = healthPoint + 20;
		}
	}

	/**
	 * 죽었을 때, 아이템 하나를 떨어트린다
	 */
	String dropItem() {
		if (healthPotionList.size() > 0) {
			String healthPotion = healthPotionList.get(0);
			healthPotionList.remove(0);
			return healthPotion;
		} else {
			return "";
		}
	}

	public void setHealthPoint(int i) {
		this.healthPoint = i;
	}
}