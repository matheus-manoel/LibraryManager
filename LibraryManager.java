//package

import java.util.*;
import java.util.ArrayList;
import java.text.*;

public class LibraryManager{

	public static void main(String[] args){
        Library library = new Library();
		Scanner in = new Scanner(System.in);
		int option = -1;
        GregorianCalendar today;
        int day, month, year;



		while(option != 0){

		    System.out.println("Insira a data: ");
		    day = in.nextInt();
		    month = in.nextInt();
		    year = in.nextInt();
            today = new GregorianCalendar(year, month, day);
	    
            library.updateLoans(today);    

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
                    
				Student newStudent = new Student(name, id, telephoneNumber, email, today, schoolId, academicDegree);

				library.addUser(newStudent);

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

				library.addUser(newProfessor);

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

				library.addUser(newCommunityMember);

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

				library.addBook(newBook);

			}else if(option == 5){		System.out.println("Option 5 selected. Register Loan");
				
				//pegar user
				System.out.print("Digite o RG do usuario: ");
				String id = in.nextLine();
				User user = library.findUser(id);
				
				//pegar book
				System.out.print("Digite o titulo do livro: ");
				String title = in.nextLine();
				Book book = library.findBook(title);
			    	
				//criar loan
				Loan loan = new Loan(user, book, today);

				if(user instanceof CommunityMember)
                    library.addLoan((CommunityMember)user, book, loan);
                else 
                    library.addLoan(user, book, loan);

			}else if(option == 6){		System.out.println("Option 6 selected. List Books");

				library.printBooks();

			}else if(option == 7){		System.out.println("Option 7 selected. List Users");

				library.printUsers();

			}else if(option == 8){		System.out.println("Option 8 selected. List Loans");
			
				library.printLoans();

			}else if(option == 0){		System.out.println("Exit selected");
            }else if(option == 9) {
                int isnb;

                System.out.println("Retorno de livro.");
                System.out.print("ISNB do livro: ");
                isnb = in.nextInt();

                library.deleteLoan(isnb);
	        }
        }
	}
	
}
