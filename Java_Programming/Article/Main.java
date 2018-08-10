import article.controller.ArticleController;
import member.controller.MemberController;
import utils.Common;

public class Main {

	private ArticleController articleController;
	private MemberController memberController;
	
	public Main() {
		articleController = new ArticleController();
		memberController = new MemberController();
	}
	
	public void run() {
		while ( true ) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 회원");
			System.out.println("2. 게시물");
			System.out.println("0. 종료");
			
			int menu = Common.INPUT.nextInt();
			if ( menu == 1 ) {
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 회원 등록");
				System.out.println("2. 회원 조회");
				System.out.println("3. 회원 검색");
				menu = Common.INPUT.nextInt();
				if ( menu == 1 ) {
					boolean isRegist = 
							memberController.registOneMember();
				}
				else if ( menu == 2 ) {
					memberController.printAllMembers();
				}
				else if ( menu == 3 ) {
					memberController.printOneMember();
				}
			}
			else if ( menu == 2 ) {
				System.out.println("메뉴를 선택하세요.");
				System.out.println("1. 게시물 등록");
				System.out.println("2. 게시물 조회");
				System.out.println("3. 게시물 검색");
				menu = Common.INPUT.nextInt();
				if ( menu == 1 ) {
					boolean isRegist = 
							articleController.registOneArticle();
				}
				else if ( menu == 2 ) {
					articleController.printAllArticles();
				}
				else if ( menu == 3 ) {
					articleController.printOnearticle();
				}
			}
			else if ( menu == 0 ) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}
