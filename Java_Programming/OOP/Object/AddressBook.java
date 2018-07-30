package Object;

import java.util.List;
import java.util.Scanner;

import javax.xml.ws.soap.Addressing;

public class AddressBook {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		AddressManager addressManager = new AddressManager();
		// List<Address> addressList = addressManager.getAddressList();
		
		// 메뉴 출력
		System.out.println("===============================");
		System.out.println(" 주소록 관리 프로그램 입니다. ");
		System.out.println("===============================");
		
		while( true ) {
			
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 전체 조회");
			System.out.println("2. 검색");
			System.out.println("3. 등록");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			
			// 메뉴 입력 받음
			int menu = input.nextInt();
			
			if ( menu == Menu.LISTING ) {
				System.out.println("===============================");
				System.out.println(" 주소록 전체 조회");
				System.out.println("===============================");
				
				
				try {
					List <Address> addressList = addressManager.getAddressList();
					
					for(int i =0; i<addressList.size(); i++) {
						Address address = addressList.get(i);
						System.out.println("이름 : " + address.getName() + 
											", 사진 : "+address.getPicture() + 
											", 번호 : "+address.getNumber());
					}
					
				} catch ( NullPointerException e ) {
					System.out.println("등록된 주소록이 없습니다.");
				}
				
				
			} else if ( menu == Menu.SEARCH ) {
				System.out.println("===============================");
				System.out.println(" 주소록 검색");
				System.out.println("===============================");
				
				
				try {
					System.out.print("검색할 이름을 입력하세요 : ");
					
					String name = input.next();
					Address address = addressManager.searchByName(name);
					System.out.println("이름 : " + address.getName() + 
							", 사진 : "+address.getPicture() + 
							", 번호 : "+address.getNumber());
				} catch (NullPointerException e) {
					System.out.println("검색 결과가 존재하지 않습니다.");
				}
				
			} else if ( menu == Menu.REGIST ) {
				System.out.println("===============================");
				System.out.println(" 주소록 등록");
				System.out.println("===============================");
				
				try {
					System.out.print("이름 : ");
					String name = input.next();
					System.out.print("사진 : ");
					String picture = input.next();
					System.out.print("번호 : ");
					String number = input.next();
					
					Address address = new Address(name , picture, number);
					
					addressManager.add(address);
				} catch ( NullPointerException e ) {
					System.out.println(e.getMessage());
				}
				
			} else if ( menu == Menu.MODIFY ) {
				System.out.println("===============================");
				System.out.println(" 주소록 수정");
				System.out.println("===============================");
				
				System.out.println("수정할 대상의 이름을 입력하세요 : ");
				String name = input.next();
				
				try {
					Address address = addressManager.searchByName(name);
					System.out.println("수정할 이름 : ");
					String modifyName = input.next();
					System.out.println("수정할 사진 : ");
					String modifyPicture = input.next();
					System.out.println("수정할 번호 : ");
					String modifyNumber = input.next();
					
					address.setName(modifyName);
					address.setPicture(modifyPicture);
					address.setNumber(modifyNumber);
					
					System.out.println("수정이 완료되었습니다.");
				} catch ( NullPointerException e ) {
					System.out.println("등록된 주소록이 없거나 이름을 잘못 적었습니다.");
				}
				
				
			} else if ( menu == Menu.REMOVE ) {
				System.out.println("===============================");
				System.out.println(" 주소록 삭제");
				System.out.println("===============================");
				
				System.out.println("삭제할 대상의 이름을 입력해주세요.");
				String name = input.next();
				
				addressManager.removeByName(name);
				System.out.println("삭제가 완료되었습니다.");
				
			} else if ( menu == Menu.QUIT ) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.\n다시 입력해주세요.");
			}
			
		}
		
	}

}
