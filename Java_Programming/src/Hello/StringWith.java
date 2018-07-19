package Hello;

public class StringWith {

	public static void main(String[] args) {
		
		String news = "일본 J리그에 입성한 두 스페인 거물이 데뷔전을 앞두고 있다."
				+ " 페르난도 토레스와 안드레스 이니에스타는 다가오는 "
				+ "주말 J리그 경기를 통해 일본 데뷔전을 치른다.\r\n" + 
				"\r\n" + 
				"토레스는 2017-2018시즌을 마치고 새로운 팀으로 거취를 물색하던 중 "
				+ "지난 7월 10일 일본 J1리그에 속한 사간 도스행을 확정지었다. "
				+ "사간 도스는 부상으로 이렇다 할 활약을 펼치지 못한 안용우의 선수 등록을 말소하면서 "
				+ "토레스의 외국인 선수 등록 여지를 마련했다. "
				+ "또한 전반기 내내 조동건이 달았던 등번호 9번을 부여하며 큰 기대감을 보이고 있다.";
		
		boolean isStart = news.startsWith("일본 J리그에");
		boolean isEnd = news.endsWith("보이고 있다.");
		
		System.out.println(isStart);
		System.out.println(isEnd);
		
	}

}
