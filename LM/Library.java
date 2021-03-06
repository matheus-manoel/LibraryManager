package LM;

import java.util.*;
import java.util.ArrayList;
import java.text.*;

public class Library{
	private ArrayList<Book> books;
	private ArrayList<User> users; 
	private ArrayList<Loan> loans;
    private GregorianCalendar today;
	private CSVManager csvm;
	
	public Library(GregorianCalendar today) {
		this.csvm = new CSVManager("Users.csv", "Books.csv", "Loans.csv", today);
		this.today = today;
        this.books = this.csvm.loadBooks(); 
		this.users = this.csvm.loadUsers();	
		this.loans = this.csvm.loadLoans();
		
		for(Loan loan : this.loans) {
			loan.setUser(findUser(loan.getUserId()));
			loan.setBook(findBook(loan.getBookId()));	
    	}
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
        this.loans.add(loan);		
		this.csvm.addLoan(loan);
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
		this.loans.add(loan);		
	    this.csvm.addLoan(loan);
        return 1;
    }

    /* Returns:
     * 1 -> Sucesso;
     * 0 -> Mesmo email;
     * -1 -> Mesmo ID;
     */
	public int addUser(User user) {
        for(User cmpUser : this.users) {
            if(user.getEmail().equals(cmpUser.getEmail()))
                return 0;

            if(user.getId().equals(cmpUser.getId()))
                return -1;
        }

		this.users.add(user);
        csvm.addUser(user);
        return 1;
    }
    
    /* Returns:
     * true -> Sucesso.
     * false -> ISNB igual.
     */
    public boolean addBook(Book book) {
        for(Book cmpBook : this.books) {

            if(book.getIsnb() == cmpBook.getIsnb())
                return false;
        
        }

        this.books.add(book);
        csvm.addBook(book);
        return true;
    }
    
    public void printUser(User user) {
        List<Loan> loans;
        GregorianCalendar calDate;
        int day, month, year;
       
        System.out.println("Nome: " + user.getName());
        System.out.println("RG: " + user.getId());
        System.out.println("Telefone: " + user.getTelephoneNumber());
        System.out.println("Email: " + user.getEmail());
        
        loans = user.getLoans();
        System.out.println("Numero de livros alugados: " + loans.size());
        
        if(loans.size() != 0) {
            System.out.print("Livros alugados: ");
            for(int i=0; i<loans.size(); i++) {
                Loan loan = loans.get(i);
                
                if(i != loans.size()-1)
                    System.out.print(loan.getBook().getTitle() + ", ");
                else
                    System.out.println(loan.getBook().getTitle() + ".");
            } 
        } 
        
        if(user.toString().equals("CommunityMember"))
            System.out.println("Profissao: " + user.getProfession());
        else if(user.toString().equals("Student")) {
            System.out.println("RA: " + user.getSchoolId());
            System.out.println("Grau Academico: " + user.getAcademicDegree());
        } else if(user.toString().equals("Professor"))
            System.out.println("ID de pesquisador: " + user.getResearcherID());

        System.out.print("Pode fazer novos imprestimos no momento: ");
        if(user.getCanRent())
            System.out.println("Sim!");
        else {
            System.out.println("Nao.");
            calDate = user.getRentAvailabilityDay();
            day = calDate.get(GregorianCalendar.DAY_OF_MONTH); 
            month = calDate.get(GregorianCalendar.MONTH); 
            year = calDate.get(GregorianCalendar.YEAR);
            System.out.println("Data que podera fazer um novo emprestimo: " + day + "/" + month + "/" + year);
        }

        System.out.println("----------------");
    }
    
	public void printBook(Book book) {
	    ArrayList<String> authors = book.getAuthors();

        System.out.println("Titulo: " + book.getTitle());  
        System.out.println("Subtitulo: " + book.getSubtitle()); 
       
        System.out.print("Autor(es): ");
        for(int i=0; i<authors.size(); i++)
            if(i != authors.size()-1)
                System.out.print(authors.get(i) + ", ");
            else
                System.out.println(authors.get(i) + ".");
        
        System.out.println("Edicao: " + book.getEdition()); 
        System.out.println("Ano: " + book.getYear()); 
        System.out.println("ID unico: " + book.getIsnb()); 
        System.out.println("Numero de paginas: " + book.getNumPages()); 
        
        System.out.print("Disponivel para membros da comunidade: ");
        if(book.isAvailableForCommunityMember())
           System.out.println("Sim!");
        else
           System.out.println("Nao.");

        System.out.print("Disponivel para emprestimo: ");
        if(book.isAvailable())
           System.out.println("Sim!");
        else
           System.out.println("Nao. Esta alugado.");
        
        System.out.println("-------------------");
    }

    public void printBooks() {
        for(Book book : this.books)
            printBook(book);
    }
    
    public void printLoans() {
        for(Loan loan : this.loans){
            System.out.print("Emprestimo: ");
            System.out.print(loan.getLocator());
            System.out.print(" " + loan.getBook());
        }
    }

    public void printUsers() {
        for(User user : this.users) {
            printUser(user); 
        }
    }
    
    public void updateLoans() {
        for(Loan loan : this.loans)
            loan.updateLocatorRentAvailability(this.today);
    }

    public User findUser(String id){
    	
    	for(User user : this.users){
            if(id.equals(user.getId())){
                return user;
            }
        }
    	
    	return null;
    }
    
    public Book findBook(int isnb){
    	
    	for(Book book : this.books){
            if(book.getIsnb() == isnb){
            	return book;
            }
        }
    	
    	return null;
    }
    
    public void updateUsers() {
        for(User user : this.users) {
            if(!user.getCanRent()) {
                if(this.today.compareTo(user.getRentAvailabilityDay()) >= 0)
                    user.setCanRent(true);
            }
        }
    }
    
    public void updateBookFile() {
        this.csvm.clearFile("book");
        for(Book book : this.books)
            this.csvm.addBook(book);
    }

    public void exiting() {
        updateBookFile();    
    }

	public void start() {
        Scanner in = new Scanner(System.in);
        int option = -1, control;
        updateUsers();
        updateLoans();    
		
        while(option != 0){
			clearConsole();
        	System.out.println("\t\tLibrary Manager");
        	System.out.println("1. Adicionar aluno!");
        	System.out.println("2. Adicionar professor!");
        	System.out.println("3. Adicionar membro da comunidade!");
        	System.out.println("4. Adicionar livro!");
        	System.out.println("5. Fazer empréstimo!");
        	System.out.println("6. Listar livros!");
        	System.out.println("7. Listar usuarios!");
        	System.out.println("8. Listar emprestimos!");
        	System.out.println("9. Devolever livro!");
			
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
                    

				control = addUser(new Student(name, id, telephoneNumber, email, today, schoolId, academicDegree));

                if(control == 1)
                    System.out.println("Usuario adicionando com sucesso!");
                else if(control == 0) //email e id
                    System.out.println("Erro: ja existe um usuario com esse email cadastrado.");
                else if(control == -1)
                    System.out.println("Erro: ja existe um usuario com esse ID cadastrado.");

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

				control = addUser(newProfessor);
                
                if(control == 1)
                    System.out.println("Usuario adicionando com sucesso!");
                else if(control == 0) //email e id
                    System.out.println("Erro: ja existe um usuario com esse email cadastrado.");
                else if(control == -1)
                    System.out.println("Erro: ja existe um usuario com esse ID cadastrado.");

			} else if(option == 3){
                
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

				control = addUser(newCommunityMember);
                
                if(control == 1)
                    System.out.println("Usuario adicionando com sucesso!");
                else if(control == 0) //email e id
                    System.out.println("Erro: ja existe um usuario com esse email cadastrado.");
                else if(control == -1)
                    System.out.println("Erro: ja existe um usuario com esse RG cadastrado.");

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
				System.out.print("ID unico: ");
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

			    Boolean controlBool = addBook(newBook);
                
                if(controlBool)
                    System.out.println("Livro adicionado com sucesso!\n---------------------");
                else
                    System.out.println("Ja existe um livro adicionado com esse ISNB!\n---------------------");

			}else if(option == 5){		System.out.println("Option 5 selected. Register Loan");
				
				//pegar user
				System.out.print("Digite o RG do usuario: ");
				String id = in.nextLine();
				User user = findUser(id);
			        
				//pegar book
				System.out.print("Digite o ID unico do livro: ");
				int isnb = in.nextInt();
				Book book = findBook(isnb);
			    
                if(user == null) 
                    System.out.println("Usuario nao encontrado.");
                else if(book == null)
                    System.out.println("Livro nao encontrado.");
				else {
                    Loan loan = new Loan(user, book, today);

                    if(user instanceof CommunityMember)
                        addLoan((CommunityMember)user, book, loan);
                    else 
                        addLoan(user, book, loan);
                }

			}else if(option == 6){		System.out.println("Option 6 selected. List Books");

				printBooks();

			}else if(option == 7){		System.out.println("Option 7 selected. List Users");

				printUsers();

			}else if(option == 8){		System.out.println("Option 8 selected. List Loans");
			
				printLoans();

            }else if(option == 9) {
                int isnb;

                System.out.println("Retorno de livro.");
                System.out.print("ID unico do livro: ");
                isnb = in.nextInt();

                deleteLoan(isnb);
	        }else if(option == 0){		
                System.out.println("Exit selected");
                exiting();
            }
        }
	}
	
	private final static void clearConsole(){
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e) {
            System.out.println("Error while clearing terminal.");
        }
    }

}
