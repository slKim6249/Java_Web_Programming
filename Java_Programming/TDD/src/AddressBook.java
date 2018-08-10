import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<Address> addressList;
	
	public AddressBook() {
		addressList = new ArrayList<>();
	}
	
	public void add(Address address) {
		addressList.add(address);
	}

	public List<Address> getAddresses() {
		List<Address> addressListTemp = new ArrayList<Address>();
		addressListTemp.addAll(addressList);
		return addressListTemp;
	}

	public void remove(String name, String phone) {
		for (Address address : addressList) {
			if ( address.getName().equals(name) &&
					address.getPhone().equals(phone) ) {
				addressList.remove(address);
				break;
			}
		}
	}

}
