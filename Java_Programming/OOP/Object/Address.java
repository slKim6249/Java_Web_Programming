package Object;

public class Address {

	private String name;
	private String picture;
	private String number;

	public Address(String name, String picture, String number) {
		
		this.name = name;
		this.setPicture(picture);
		this.setNumber(number);
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		if ( picture.toLowerCase().endsWith(".jpg") ) {
			this.picture = picture;
		}
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if ( number.length() == 13 ) {
			
			String[] numberArray = number.split("-");
			if ( numberArray.length == 3 &&
					numberArray[0].length() == 3 &&
					numberArray[1].length() == 4 &&
					numberArray[2].length() == 4 ) {
				
				this.number = number;
				
			}
			
		}
	}

}
