package Object;

import java.util.Random;

public class FIFAMain {

	public static void main(String[] args) throws InterruptedException {
		
		Random random = new Random();
		Thread th = new Thread();
		
		Attack akBall = new Attack();
		akBall.goal = 0;
		
		Defence dfBall = new Defence();
		
		int[] AD = new int[10];
		int ball = 0;
		boolean change = true;
		boolean match = true;
		
		for(int i = 0; i < AD.length; i++) {
			AD[i] = random.nextInt(10);
		}
		
		
		while( match ) {
			
			th.sleep(3000);
			
			try {
				
				if( change == true ) {
					akBall.pass();
					ball++;
					
					if ( AD[ball] % 2 == 0 ) {
						akBall.throwPass();
						ball++;
						
						if( AD[ball] % 2 == 0 ) {
							akBall.shoot();
							System.out.printf("현재 스코어 %d : 0\n", akBall.goal);
							ball++;
							change = false;
						} else {
							akBall.inter();
							change = false;
							ball++;
						}
						
					} else if ( AD[ball] % 2 == 1) { // 뺏길 때
						akBall.inter();
						change = false;
						ball++;
					}
					
				} else if ( change == false ) {
					dfBall.press();
					ball++;
					if ( AD[ball] % 2 == 0 ) {
						dfBall.Dpress();
						change = true;
					} else if ( AD[ball] % 2 == 1 ) {
						dfBall.keepDefence();
						change = true;
					}
					
				}
			}
			catch ( ArrayIndexOutOfBoundsException e ) {
				break;
			}
		}
		
		System.out.println("경기를 종료합니다.");
		System.out.println("최종 스코어 " + akBall.goal + " : 0 입니다.");
		
	}

}
