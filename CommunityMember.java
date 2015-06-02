import java.util.*;

public class CommunityMember extends User {
	private String profession;
    private static final int maxRentalDays = 15;
	private static final int maxRentalBooks = 2;

	public CommunityMember(String name, String id, String telephoneNumber, String email, GregorianCalendar today, String profession) {
		super(name, id, telephoneNumber, email, true, today);
	    this.profession = profession;
    }

	public boolean rentedMaxBooks() {
		if (this.getLoans().size() < maxRentalBooks)
			return false;

		return true;
	}

    public int getMaxRentalDays() {
        return this.maxRentalDays;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    public String toString() {
        return "CommunityMember";
    }
}
