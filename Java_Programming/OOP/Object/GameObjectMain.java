package Object;

public class GameObjectMain {

   public static void main(String[] args) {
      
	   // 캐릭터
      GameObject character = new GameObject(1000, 5000, 200); // 생성자 오버로딩 이용
      /*
       * 생성자를 호출하면서 생성자에 지정된 기본 값 사용 
       * 캐릭터의 HP = 30
       * 캐릭터의 MP = 50
       * 캐릭터의 DamagePoint = 2
       */
      
      // 몬스터
      GameObject monster = new GameObject();
      /*
       * 생성자를 호출하면서 생성자에 지정된 기본 값 사용 
       * 몬스터의 HP = 30
       * 몬스터의 MP = 50
       * 몬스터의 DamagePoint = 2
       */
      
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
