import java.util.*;

public class Student extends User {
	private String schoolId;
    private String academicDegree;
	private static final int maxRentalDays = 15;
	private static final int maxRentalBooks = 4;

	public Student(String name, String id, String telephoneNumber, String email, GregorianCalendar today, String schoolId, String academicDegree) {
		super(name, id, telephoneNumber, email, true, today);
		this.schoolId = schoolId;
        this.academicDegree = academicDegree;
	}

	public boolean rentedMaxBooks() {
		if (super.getLoans().size() < maxRentalBooks)
			return false;

		return true;
	}

    public int getMaxRentalDays() {
        return this.maxRentalDays;
    }

	public void setSchoolId(String schoolId){
		this.schoolId = schoolId;
	}

	public String getSchoolId(){
		return this.schoolId;
	}
    
    public String toString() {
        return "Student";
    }
}
