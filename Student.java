import java.util.*;

public class Student extends User {
	private int schoolId;

	private static final int maxRentalDays = 15;
	private static final int maxRentalBooks = 4;

	public Student(String name, String id, String telephoneNumber, String email, int schoolId, GregorianCalendar today) {
		super(name, id, telephoneNumber, email, true, today);

		this.schoolId = schoolId;
	}


	public void setSchoolId(int schoolId){
		this.schoolId = schoolId;
	}

	public int getSchoolId(){
		return this.schoolId;
	}

	public int getMaxRentalDays() {
		return this.maxRentalDays;
	}

	public int getMaxRentalBooks() {
		return this.maxRentalBooks;
	}


}
