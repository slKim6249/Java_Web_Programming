package Object;

import java.util.ArrayList;
import java.util.List;

public class GameObjectMain {

   public static void main(String[] args) {
      
      GameObject character = new GameObject();
      
      List<String> characterHPList = new ArrayList<String>();
      characterHPList.add("HP물약");
      characterHPList.add("HP물약");
      characterHPList.add("HP물약");
      characterHPList.add("HP물약");
      
      List<String> characterMPList = new ArrayList<String>();
      characterMPList.add("MP물약");
      characterMPList.add("MP물약");
      characterMPList.add("MP물약");
      characterMPList.add("MP물약");
      
      character.setDamagePoint(30);
      character.setHealthPotionList(characterHPList);
      character.setManaPotionList(characterMPList);
      
      List<String> characterHPList2 = character.getHealthPotionList();
      characterHPList2.clear(); // 모든 데이터 삭제
      
      // 몬스터
      GameObject monster = new GameObject();
      
      List<String> monsterHPList = new ArrayList<String>();
      monsterHPList.add("몬스터 HP 물약");
      monsterHPList.add("몬스터 HP 물약");
      
      monster.setDamagePoint(10);
      monster.setHealthPotionList(monsterHPList);
      monster.setManaPotionList(new ArrayList<String>());
      
      while ( true ) {
         monster.attack();
         int characterHP = character.beAttack(monster.getDamagePoint());
         
         if ( characterHP <= 0 ) {
            System.out.println("캐릭터가 사망하였습니다.");
            String item = character.dropItem();
            System.out.println(item + "을 드랍하였습니다.");
            break;
         }
         else if ( characterHP <= 30 ) {
            character.useHealthPotion();
         }
         
         character.attack();
         int monsterHP = monster.beAttack(character.getDamagePoint());
         
         if ( monsterHP <= 0 ) {
            System.out.println("몬스터가 사망했습니다.");
            String item = monster.dropItem();
            System.out.println(item + "을 드랍하였습니다.");
            break;
         }
         
         
      }
      
   }
   
}
