public class Student extends User {
	private int schoolId;

	private static final int maxRentalDays = 15;
	private static final int maxRentalBooks = 4;

	public Student(String nome){
		this.nome = nome;
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
