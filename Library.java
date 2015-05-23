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

		System.out.println("Insira a data: ");
		String dateString = in.nextLine();

		String cmd;

		{
			 cmd = in.nextLine();

			if(cmd == "1"){					//cadastrar student

				Student newStudent = new Student(in.nextLine());

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
