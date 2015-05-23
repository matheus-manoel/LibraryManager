public class Student extends User {
	private int schoolId;

	public Student(String nome){
		super.nome = nome;
	}


	void setSchoolId(int schoolId){
		this.schoolId = schoolId;
	}

	int getSchoolId(){
		return this.schoolId;
	}


}
