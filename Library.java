import java.util.*;
import java.text.*;

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

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.println("Insira a data: ");
		dateString = in.nextLine();

		{
			cmd = in.nextLine();


		}while(cmd != 0);

	}


}
