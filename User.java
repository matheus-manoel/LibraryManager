public class User {
	private String name;
	private String id;
	private String telephoneNumber;
	private String email;
	private List<Loan> loans;
	
	private static final int maxRentalDays = 5;
	private static final int maxRentalBooks = 5;
	
	public User(String name, String id, String telephoneNumber, String email) {
		this.loans = new List<Loan>();
		this.name = name;
		this.id = id;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
	}

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

	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}
}
