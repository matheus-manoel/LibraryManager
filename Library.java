import java.util.*;
import java.text.*;

public class Library{
	private List<Book> books;
	private List<User> users; 
	private List<Loan> loans;

	public Library() {
		this.books = new ArrayList<Book>();
		this.users = new ArrayList<User>();
		this.loans = new ArrayList<Loan>();
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
		String dateString = in.nextLine();

		String cmd;

		{
			 cmd = in.nextLine();

			if(cmd == "1"){					//cadastrar student
				String nome = in.nextLine();

				Student newStudent = new Student(nome);

				addStudent(newStudent);

			}else if(cmd == "2"){			//cadastrar professor

			}else if(cmd == "3"){			//cadastrar communityMember

			}else if(cmd == "4"){			//cadastrar livro

			}else if(cmd == "5"){			//fazer emprestimo

			}else if(cmd == "6"){			//quitar emprestimo

			}else if(cmd == "7"){			//ver emprestimos

			}else if(cmd == "8"){			//ver livros

			}else if(cmd == "9"){			//ver usuarios

			}

		}while(cmd != "0");

	}


}
