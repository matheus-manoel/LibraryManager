public class Professor extends User {
	private static final int maxRentalDays = 60;
	private static final int maxRentalBooks = 6;


	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}

	public int getMaxRentalBooks() {
		return this.maxRentalBooks;
	}
}
