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
    
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void printUsers() {
        for(User user : this.users)
            System.out.println(user.getName());
    }

    public void printBooks() {
        for(Book book : this.books)
            System.out.println(book.getTitle());
    }

}
