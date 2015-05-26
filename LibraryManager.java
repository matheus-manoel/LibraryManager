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

		System.out.println("Insira a data: ");
		day = in.nextInt();
		month = in.nextInt();
		year = in.nextInt();
        today = new GregorianCalendar(year, month, day);


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
                    
				Student newStudent = new Student(name, id, telephoneNumber, email, today, schoolId, academicDegree);

				library.addUser(newStudent);

			} else if(option == 2){			System.out.println("Option 2 selected. Add professor");

/*				System.out.println("register: nome, id, telephoneNumber, email");

				in.nextLine();			//this works like a fflush

				//nome, id, telephoneNumber, email
		    	Professor newProfessor = new Professor(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), today);

		    	//System.out.println(newProfessor.getName() + ", " + newProfessor.getId() + ", " + newProfessor.getTelephoneNumber() + ", " + newProfessor.getEmail());
		    	
		    	//addUser(newProfessor);
*/
			}else if(option == 3){		System.out.println("Option 3 selected. Add CommunityMember");
/*
				System.out.println("register: nome, id, telephoneNumber, email");

				in.nextLine();			//this works like a fflush

				//nome, id, telephoneNumber, email
		    	CommunityMember newCommunityMember = new CommunityMember(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), today);

		    	//System.out.println(newCommunityMember.getName() + ", " + newCommunityMember.getId() + ", " + newCommunityMember.getTelephoneNumber() + ", " + newCommunityMember.getEmail());
		    	
		    	//addUser(newCommunityMember);
*/		
			}else if(option == 4){		System.out.println("Option 4 selected. Add Book");
/*
				System.out.println("register: title, subtitle, edition, year, publisher, numPages, availableForCommunityMember");

				in.nextLine();

				//title, subtitle, edition, year, publisher, numPages, availableForCommunityMember
				Book newBook = new Book(in.nextLine(), in.nextLine(), in.nextInt(), in.nextInt(), in.nextLine(), in.nextInt(), in.nextBoolean());

				//addBook(newBook);
*/
			}else if(option == 5){		System.out.println("Option 5 selected. Register Loan");

				//User locator, Book book, GregorianCalendar current_cal
				//Loan newLoan = new Loan();

			}else if(option == 6){		System.out.println("Option 6 selected. List Books");

			}else if(option == 7){		System.out.println("Option 7 selected. List Users");

			}else if(option == 8){		System.out.println("Option 7 selected. List Loans");

			}else if(option == 0){		System.out.println("Exit selected");}

		}
	}
}
