import java.util.*;

public class Professor extends User {
	private static final int maxRentalDays = 60;
	private static final int maxRentalBooks = 6;

	public Professor(String name, String id, String telephoneNumber, String email, GregorianCalendar today) {
		super(name, id, telephoneNumber, email, true, today);
	}

	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}

	public int getMaxRentalBooks() {
		return this.maxRentalBooks;
	}
}
