public class Professor extends User {
	private static final int maxRentalDays = 60;
	private static final int maxRentalBooks = 6;

	public Professor(String name, String id, String telephoneNumber, String email) {
		super(name, id, telephoneNumber, email);
	}

	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}

	public int getMaxRentalBooks() {
		return this.maxRentalBooks;
	}
}
