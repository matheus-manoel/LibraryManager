import java.util.*;

public class Library{
	private List<Book> books;
	private List<User> users; 
	private List<Loan> loans;

	public Library() {
		this.books = new List<Book>();
		this.users = new List<User>();
		this.loans = new List<Loan>();
	}

	public void addStudent(Student student) {
		this.users.add(student);
	}

	public void addProfessor(Professor professor) {
		this.users.add(professor); 
	}

	public void addCommunityMember(CommunityMember comMember) {
		this.users.add(comMember);
	}
}
