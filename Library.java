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
    
    public boolean deleteLoan(int isnb) {
        Iterator<Loan> iterator = this.loans.iterator();

        while(iterator.hasNext()) {
            Loan loan = iterator.next();        
            
            if(loan.getBook().getIsnb() == isnb) {
                loan.getLocator().deleteLoan(isnb);
                loan.getBook().setAvailable(true);  
                iterator.remove();
                return true;
            }
        }

        return false;
    }

	/* Returns: 
	 * 1  -> sucesso.
	 * 0  -> usuário já alugou o máximo de livros possíveis.
	 * -1 -> livro está alugado.
	 * -2 -> usuário não tem permissão para alugar esse livro.
	 */
	public int addLoan(CommunityMember locator, Book book, Loan loan) {
		if(locator.rentedMaxBooks())
			return 0;

		if(!book.isAvailable())
			return -1;
		
        if(!book.isAvailableForCommunityMember())
			return -2;

		locator.addLoan(loan);
		book.setAvailable(false); //livro fica indisponível para que outros aluguem
		this.addLoan(loan);		
		return 1;
    }
	
	/* Returns: 
	 * 1  -> sucesso.
	 * 0  -> usuário já alugou o máximo de livros possíveis.
	 * -1 -> livro está alugado.
	 */
    public int addLoan(User locator, Book book, Loan loan) {
		if(locator.rentedMaxBooks())
			return 0;

		if(!book.isAvailable())
			return -1;
	
        locator.addLoan(loan);
		book.setAvailable(false); //livro fica indisponível para que outros aluguem
		this.addLoan(loan);		
		return 1;
    }

	public void addUser(CommunityMember user) {
		this.users.add(user);
    }

	public void addUser(Student user) {
		this.users.add(user);
    }

	public void addUser(Professor user) {
		this.users.add(user);
    }

	public void addLoan(Loan loan) {
		this.loans.add(loan);
	}
    
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void printUsers() {
        GregorianCalendar calDate;
        int day, month, year;

        for(User user : this.users) {
            System.out.println(user.getName());
            calDate = user.getRentAvailabilityDay();
            day = calDate.get(GregorianCalendar.DAY_OF_MONTH); 
            month = calDate.get(GregorianCalendar.MONTH); 
            year = calDate.get(GregorianCalendar.YEAR); 
            System.out.println("data que pode fazer emprestimo: " + day + "/" +
                                month + "/" + year);
        }
    }
    
    public void updateLoans(GregorianCalendar today) {
        for(Loan loan : this.loans)
            loan.updateLocatorRentAvailability(today);
    }

    public void printBooks() {
        for(Book book : this.books)
            System.out.println(book.getTitle());
    }
    
    public void printLoans() {
        for(Loan loan : this.loans){
            System.out.print("Emprestimo: ");
            System.out.print(loan.getLocator());
            System.out.print(" " + loan.getBook());
        }
    }
    
    public User findUser(String id){
    	
    	for(User user : this.users){
            if(id.equals(user.getId())){
                return user;
            }
        }
    	
    	return null;
    }
    
    public Book findBook(String title){
    	
    	for(Book book : this.books){
            if(title.equals(book.getTitle())){
            	return book;
            }
        }
    	
    	return null;
    }

}
