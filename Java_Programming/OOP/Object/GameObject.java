package Object;

import java.util.List;

public class GameObject {

	   int healthPoint;
	   int manaPoint;
	   int damagePoint;
	   
	   List<String> healthPotionList;
	   List<String> manaPotionList;
	   
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
	   int beAttack ( int damage ) {
	      System.out.println("상대에게 맞습니다.");
	      healthPoint = healthPoint - damage;
	      return healthPoint;
	   }
	   
	   /**
	    * MP 물약을 먹는다
	    */
	   void useManaPotion() {
	      if ( manaPotionList.size() >  0) {
	         manaPotionList.remove(0);
	         manaPoint = manaPoint + 20;
	      }
	   }
	   
	   /**
	    * HP 물약을 먹는다
	    */
	   void useHealthPotion() {
	      if ( healthPotionList.size() > 0 ) {
	         healthPotionList.remove(0);
	         healthPoint = healthPoint + 20;
	      }
	   }
	   
	   /**
	    * 죽었을 때, 아이템 하나를 떨어트린다
	    */
	   String dropItem() {
	      if ( healthPotionList.size() > 0 ) {
	         String healthPotion = healthPotionList.get(0);
	         healthPotionList.remove(0);
	         return healthPotion;
	      }
	      else {
	         return "";
	      }
	   }
	}