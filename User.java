public class User {
	private String name;
	private String id;
	private String telephoneNumber;
	private String email;


	void setName(String name){
		this.name = name;
	}

	String getName(){
		return this.name;
	}

	void setID(String id){
		this.id = id;
	}

	String getID(){
		return this.id;
	}

	void setTelephoneNumber(String telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}

	String getTelephoneNumber(){
		return this.telephoneNumber;
	}

	void setEmail(String email){
		this.email = email;
	}

	String getEmail(){
		return this.email;
	}

}
