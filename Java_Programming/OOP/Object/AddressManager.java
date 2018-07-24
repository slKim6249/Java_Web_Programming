package Object;

import java.util.ArrayList;
import java.util.List;

public class AddressManager {

	private List<Address> addressList;
	
	/**
	 * 전체조회
	 * @return
	 */
	public List<Address> getAddressList() {
		List<Address> addressListCopy = new ArrayList<Address>();
		addressListCopy.addAll(this.addressList);
		return addressListCopy;
	}
	
	
	public void setAddressList(List<Address> addressList) {
		this.addressList = new ArrayList<Address>();
		this.addressList.addAll(addressList);
	}
	
	/**
	 * 검색
	 * @param name
	 * @return
	 */
	public Address searchByName( String name ) {
		for ( int i=0; i < this.addressList.size(); i++ ) {
			Address address = this.addressList.get(i);
			
			if ( address.getName().equals(name) ) {
				return address;
			}
		}
		
		return null;
	}
	
	/**
	 * 등록
	 * @param address
	 */
	public void add( Address address ) {
		this.addressList.add(address);
	}
	
	/**
	 * 삭제
	 * @param name
	 */
	public void removeByName( String name ) {
		Address address = this.searchByName(name);
		if ( address != null ) {
			this.addressList.remove(address);
		}
		
	}
	
	/**
	 * 수정 절차
	 * 1. 이름을 이용해 Address 조회
	 * 2. 조회된 Address의 정보 수정
	 * 3. List의 Address 정보 변경
	 * @param address
	 */
	
}
