public class CommunityMember extends User {
	private static final int maxRentalDays = 15;
	private static final int maxRentalBooks = 2;

	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}

	public int getMaxRentalBooks() {
		return this.maxRentalBooks;
	}
}
