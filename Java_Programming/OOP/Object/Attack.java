package Object;

public class Attack {
	
	int goal;
	
	void pass() {
		System.out.println("패스합니다.");
	}
	
	void throwPass() {
		System.out.println("전진 패스합니다.");
	}
	
	int shoot() {
		System.out.println("슛팅을 시도합니다.");
		System.out.println("골");
		
		goal += 1;
		
		return goal;
	}
	
	void inter() {
		System.out.println("공을 뺐겼습니다.");
	}

}
