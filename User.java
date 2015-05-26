import java.util.*;

public class User {
	private String name;
	private String id;
	private String telephoneNumber;
	private String email;
	private ArrayList<Loan> loans;
    private boolean canRent;
    private GregorianCalendar rentAvailabilityDay;
	
    //arbitrary constant
    private static int libID;
	private static final int maxRentalBooks = 500;
    private static final int maxRentalDays = 20;
	
	public User(String name, String id, String telephoneNumber, String email, boolean canRent, GregorianCalendar today) {
		this.loans = new ArrayList<Loan>();
		this.name = name;
		this.id = id;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
        this.canRent = true;
        this.rentAvailabilityDay = today;
    }

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setLibId(int libID){
		this.libID = libID;
	}

	public int getLibID(){
		return this.libID;
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
	
    public int getMaxRentalDays() {
        return maxRentalDays;
    }

    public boolean getCanRent(){
        return canRent;
    }

    public void setCanRent(boolean canRent) {
        this.canRent = canRent;
    }

	public boolean addLoan(Loan loan) {
		//checando se usuario já emprestou o máximo
		if(this.rentedMaxBooks())
			return false;

		this.loans.add(loan);
		return true;
	}

    public GregorianCalendar getRentAvailabilityDay() {
        return this.rentAvailabilityDay;
    }

    public void setRentAvailabilityDay(GregorianCalendar rentAvailabilityDay) {
        this.rentAvailabilityDay = rentAvailabilityDay;
    }

	public boolean rentedMaxBooks() {
		if (loans.size() < maxRentalBooks)
			return false;

		return true;
	}
}
