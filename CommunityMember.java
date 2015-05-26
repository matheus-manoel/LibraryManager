import java.util.*;

public class CommunityMember extends User {
	private static final int maxRentalDays = 15;
	private static final int maxRentalBooks = 2;

	public CommunityMember(String name, String id, String telephoneNumber, String email, GregorianCalendar today) {
		super(name, id, telephoneNumber, email, true, today);
	}


	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}

	public int getMaxRentalBooks() {
		return this.maxRentalBooks;
	}
}
