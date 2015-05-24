import java.util.*;

public class User {
	private String name;
	private String id;
	private String telephoneNumber;
	private String email;
	private ArrayList<Loan> loans;

	//arbitrary constant
	int maxRentalBooks = 500;

	
	public User(String name, String id, String telephoneNumber, String email) {
		this.loans = new ArrayList<Loan>();
		this.name = name;
		this.id = id;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setTelephoneNumber(String telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}

	public String getTelephoneNumber(){
		return this.telephoneNumber;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}
	
	public boolean addLoan(Loan loan) {
		//checando se usuario já emprestou o máximo
		if(this.rentedMaxBooks())
			return false;

		this.loans.add(loan);
		return true;
	}

	public boolean rentedMaxBooks() {
		if (loans.size() < maxRentalBooks)
			return false;

		return true;
	}
}
