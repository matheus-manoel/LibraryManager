import java.util.*;
import java.util.ArrayList;
import java.text.*;

public class Library{
	private ArrayList<Book> books;
	private ArrayList<User> users; 
	private ArrayList<Loan> loans;

	public Library() {
		this.books = new ArrayList<Book>();
		this.users = new ArrayList<User>();
		this.loans = new ArrayList<Loan>();
	}
	
	/* Returns: 
	 * 1  -> sucesso.
	 * 0  -> usuário já alugou o máximo de livros possíveis.
	 * -1 -> livro está alugado.
	 * -2 -> usuário não tem permissão para alugar esse livro.
	 */
	public int addLoan(User locator, Book book, Loan loan) {
		if(locator.rentedMaxBooks())
			return 0;

		if(!book.isAvailable())
			return -1;
	
		if((locator instanceof CommunityMember) && !book.isAvailableForCommunityMember())
			return -2;

		locator.addLoan(loan);
		book.setAvailable(false); //livro fica indisponível para que outros aluguem
		this.addLoan(loan);		
		return 1;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int swValue = -1;

		System.out.println("Insira a data: ");

		String dateString = in.nextLine();

		System.out.println("okei: " + dateString);

		while(swValue != 0){

			swValue = in.nextInt();

			//System.out.println("swvalue = " + swValue);


			if(swValue == 1){		System.out.println("Option 1 selected. Add student");

				System.out.println("register: nome, id, telefone, email, schoolId");

				in.nextLine();				//this works like a fflush

				Student newStudent = new Student(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextInt());

				//System.out.println(newStudent.getName() + ", " + newStudent.getId() + ", " + newStudent.getTelephoneNumber() + ", " + newStudent.getEmail() + ", " + newStudent.getSchoolId());

				//addUser(newStudent);

			} else if(swValue == 2){			System.out.println("Option 2 selected. Add professor");

				System.out.println("register: nome, id, telephoneNumber, email");

				in.nextLine();			//this works like a fflush

				//nome, id, telephoneNumber, email
		    	Professor newProfessor = new Professor(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());

		    	//System.out.println(newProfessor.getName() + ", " + newProfessor.getId() + ", " + newProfessor.getTelephoneNumber() + ", " + newProfessor.getEmail());
		    	
		    	//addUser(newProfessor);

			}else if(swValue == 3){		System.out.println("Option 3 selected. Add CommunityMember");

				System.out.println("register: nome, id, telephoneNumber, email");

				in.nextLine();			//this works like a fflush

				//nome, id, telephoneNumber, email
		    	CommunityMember newCommunityMember = new CommunityMember(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());

		    	//System.out.println(newCommunityMember.getName() + ", " + newCommunityMember.getId() + ", " + newCommunityMember.getTelephoneNumber() + ", " + newCommunityMember.getEmail());
		    	
		    	//addUser(newCommunityMember);
		
			}else if(swValue == 4){		System.out.println("Option 4 selected. Add Book");

				System.out.println("register: title, subtitle, edition, year, publisher, numPages, availableForCommunityMember");

				in.nextLine();

				//title, subtitle, edition, year, publisher, numPages, availableForCommunityMember
				Book newBook = new Book(in.nextLine(), in.nextLine(), in.nextInt(), in.nextInt(), in.nextLine(), in.nextInt(), in.nextBoolean());

				//addBook(newBook);

			}else if(swValue == 5){		System.out.println("Option 5 selected. Register Loan");

				//User locator, Book book, GregorianCalendar current_cal
				//Loan newLoan = new Loan();

			}else if(swValue == 6){		System.out.println("Option 6 selected. List Books");

			}else if(swValue == 7){		System.out.println("Option 7 selected. List Users");

			}else if(swValue == 8){		System.out.println("Option 7 selected. List Loans");

			}else if(swValue == 0){		System.out.println("Exit selected");}

		}

	}
}
