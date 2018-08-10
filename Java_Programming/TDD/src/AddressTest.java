import java.util.List;

public class AddressTest {

	public static void main(String[] args) {
		
		// 등록 테스트
		AddressBook book = new AddressBook();
		
		Address address = new Address();
		address.setName("장민창");
		address.setPhone("1234");
		
		book.add(address);
		
		address = new Address();
		address.setName("장민창");
		address.setPhone("4567");
		
		book.add(address);
		
		// 조회 테스트
		List<Address> addressList = book.getAddresses();
		System.out.println("조회테스트");
		for (Address address2 : addressList) {
			
			System.out.println(address2.getName());
			System.out.println(address2.getPhone());
			
		}
		
		// 삭제 테스트
		book.remove("장민창", "4567");
		
		addressList = book.getAddresses();
		System.out.println("삭제테스트");
		for (Address address2 : addressList) {
			
			System.out.println(address2.getName());
			System.out.println(address2.getPhone());
			
		}
		
	}
	
}
