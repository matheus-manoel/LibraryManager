import java.util.*;

public class Professor extends User {
    private String researcherID; 
    private static final int maxRentalDays = 60;
	private static final int maxRentalBooks = 6;

	public Professor(String name, String id, String telephoneNumber, String email, GregorianCalendar today, String researcherID) {
		super(name, id, telephoneNumber, email, true, today);
        this.researcherID = researcherID;
	}

    public String getResearcherID() {
        return this.researcherID;
    }

    public void setResearcherID(String researcherID) {
        this.researcherID = researcherID;
    }
}
