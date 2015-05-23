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
	
	public boolean addLoan(User locator, Book book, Loan loan) {
		//checa se o locador já não alugou o max de livros
		if(locator.rentedMaxBooks())
			return false;
		
		locator.addLoan(loan);
	    book.setAvailable(false); //livro fica indisponível para que outros aluguem
		this.addLoan(loan);		
		return true;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public void addLoan(Loan loan) {
		this.loans.add(loan);
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
