import java.util.*;
import java.util.ArrayList;
import java.text.*;

public class Library{
	private ArrayList<Book> books;
	private ArrayList<User> users; 
	private ArrayList<Loan> loans;
    private GregorianCalendar today;

	public Library(GregorianCalendar today) {
		this.today = today;
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
    
    public void updateLoans() {
        for(Loan loan : this.loans)
            loan.updateLocatorRentAvailability(this.today);
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

	public void start() {
        Scanner in = new Scanner(System.in);
        int option = -1;
        updateLoans();    
		
        while(option != 0){

            option = in.nextInt();
			in.nextLine();				//this works like a fflush
			
            if(option == 1){

                String name, id, telephoneNumber, email, schoolId, academicDegree;
                System.out.println("Adicione um estudante:");
				System.out.print("Nome: ");
                name = in.nextLine();
				System.out.print("RG: ");
                id = in.nextLine();
				System.out.print("Telefone: ");
                telephoneNumber = in.nextLine();
				System.out.print("Email: ");
                email = in.nextLine();
				System.out.print("RA: ");
                schoolId = in.nextLine();
				System.out.print("Grau Academico: ");
                academicDegree = in.nextLine();
                    

				addUser(new Student(name, id, telephoneNumber, email, today, schoolId, academicDegree));

			} else if(option == 2){

                String name, id, telephoneNumber, email, researcherID;
                System.out.println("Adicione um professor:");
				System.out.print("Nome: ");
                name = in.nextLine();
				System.out.print("RG: ");
                id = in.nextLine();
				System.out.print("Telefone: ");
                telephoneNumber = in.nextLine();
				System.out.print("Email: ");
                email = in.nextLine();
				System.out.print("Researcher ID: ");
                researcherID = in.nextLine();
                    
				Professor newProfessor = new Professor(name, id, telephoneNumber, email, today, researcherID);

				addUser(newProfessor);

			}else if(option == 3){
                
                String name, id, telephoneNumber, email, profession;
                System.out.println("Adicione um membro da comunidade:");
				System.out.print("Nome: ");
                name = in.nextLine();
				System.out.print("RG: ");
                id = in.nextLine();
				System.out.print("Telefone: ");
                telephoneNumber = in.nextLine();
				System.out.print("Email: ");
                email = in.nextLine();
				System.out.print("Profissao: ");
                profession = in.nextLine();
                    
				CommunityMember newCommunityMember = new CommunityMember(name, id, telephoneNumber, email, today, profession);

				addUser(newCommunityMember);

			}else if(option == 4){

				String author, title, subtitle, publisher, availible;
				int edition, bookYear, numPages, isnb, n_authors; 
				boolean availableForCommunityMember;
                ArrayList<String> authors = new ArrayList<String>();
            
                System.out.println("Adicione um livro:");
				System.out.print("Titulo: ");
                title = in.nextLine();
				System.out.print("SubTitulo: ");
                subtitle = in.nextLine();
				System.out.print("Edicao: ");
                edition = in.nextInt();
				System.out.print("Ano: ");
                bookYear = in.nextInt();
				System.out.print("ISNB: ");
                isnb = in.nextInt();
				System.out.print("Numero de autores: ");
                n_authors = in.nextInt();

                in.nextLine();
                
                for(int i=0; i<n_authors; i++) {
                    System.out.print("Autor " + (i+1) + ": ");
                    authors.add(in.nextLine());
                }
				System.out.print("Editora: ");
                publisher = in.nextLine();
                System.out.print("Numero de paginas: ");
                numPages = in.nextInt();
				System.out.print("Este livro esta disponivel para a comunidade? (true/false)");
				availableForCommunityMember = in.nextBoolean();

				Book newBook = new Book(title, subtitle, edition, bookYear, publisher, numPages, availableForCommunityMember, isnb, authors);

			    addBook(newBook);

			}else if(option == 5){		System.out.println("Option 5 selected. Register Loan");
				
				//pegar user
				System.out.print("Digite o RG do usuario: ");
				String id = in.nextLine();
				User user = findUser(id);
				
				//pegar book
				System.out.print("Digite o titulo do livro: ");
				String title = in.nextLine();
				Book book = findBook(title);
			    	
				//criar loan
				Loan loan = new Loan(user, book, today);

				if(user instanceof CommunityMember)
                    addLoan((CommunityMember)user, book, loan);
                else 
                    addLoan(user, book, loan);

			}else if(option == 6){		System.out.println("Option 6 selected. List Books");

				printBooks();

			}else if(option == 7){		System.out.println("Option 7 selected. List Users");

				printUsers();

			}else if(option == 8){		System.out.println("Option 8 selected. List Loans");
			
				printLoans();

			}else if(option == 0){		
                System.out.println("Exit selected");
            }else if(option == 9) {
                int isnb;

                System.out.println("Retorno de livro.");
                System.out.print("ISNB do livro: ");
                isnb = in.nextInt();

                deleteLoan(isnb);
	        }
        }
	}

}
