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
		System.out.println("okei " + dateString);

		while(swValue != 0){

			swValue = in.nextInt();

			System.out.println("swvalue = " + swValue);


			if(swValue == 1){			System.out.println("Option 1 selected. Add professor");

					in.nextLine();			//this works like a fflush

					String nome = in.nextLine();
					String id = in.nextLine();
					String telefone = in.nextLine();
					String email = in.nextLine();

			    	Professor newProfessor = new Professor(nome, id, telefone, email);

			    	//System.out.println(nome + ", " + id + ", " + telefone + ", " + email);
			    	//System.out.println("okei ");
			    	//addUser(newProfessor);

			}else if(swValue == 2){		System.out.println("Option 2 selected");
			
			}else if(swValue == 0)		System.out.println("Exit selected");

		}

	}
}
