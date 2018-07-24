package Object;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

	private int healthPoint;
	private int manaPoint;
	private int damagePoint;

	private List<String> healthPotionList;
	private List<String> manaPotionList;

//	public void setHealthPoint(int healthPoint) {
//
//		if (healthPoint <= 10_000) {
//			this.healthPoint = healthPoint;
//		}
//
//	}
//
//	public void setManaPoint(int manaPoint) {
//
//		if (manaPoint <= healthPoint) {
//			this.manaPoint = manaPoint;
//		}
//
//	}

	public int getDamagePoint() {
		return damagePoint;
	}

	public void setDamagePoint(int damagePoint) {
		this.damagePoint = damagePoint;
	}

	public List<String> getHealthPotionList() {
		return healthPotionList;
	}

	public void setHealthPotionList(List<String> healthPotionList) {
		this.healthPotionList = new ArrayList<String>();
		this.healthPotionList.addAll(healthPotionList);
	}

	public List<String> getManaPotionList() {
		return manaPotionList;
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
}