import java.io.*;
import java.util.*;

public class CSVManager {
	private File userFile;
	private File bookFile;
	private File loanFile;
	private GregorianCalendar today;

    public CSVManager(String userFileName, String bookFileName, String loanFileName, GregorianCalendar today) {
    	
    	this.today = today;	
    	this.userFile = new File(userFileName);
    	this.bookFile = new File(bookFileName);
    	this.loanFile = new File(loanFileName);
        
        if(!this.userFile.exists()) {
            try {
                this.userFile.createNewFile();        
            } catch (Exception e) {
                System.out.println("Nao foi possivel criar o arquivo de usuarios.");
            }   
        }
        if(!this.bookFile.exists()) {
            try {
                this.bookFile.createNewFile();        
            } catch (Exception e) {
                System.out.println("Nao foi possivel criar o arquivo de livros.");
            }   
        }
        if(!this.loanFile.exists()) {
            try {
                this.loanFile.createNewFile();        
            } catch (Exception e) {
                System.out.println("Nao foi possivel criar o arquivo de emprestimos.");
            }   
        }
    }

    public void addUser(User user) {
    	
    	try{
			FileWriter userWriter = new FileWriter(userFile, true);
			BufferedWriter userBuffer = new BufferedWriter(userWriter);
			
			userBuffer.write(user.toString());
			userBuffer.write(", ");
			userBuffer.write(user.getName());
			userBuffer.write(", ");
			userBuffer.write(user.getId());
			userBuffer.write(", ");
			userBuffer.write(user.getTelephoneNumber());
			userBuffer.write(", ");
			userBuffer.write(user.getEmail());
			userBuffer.write(", ");

			if(user.getCanRent() == true){
				userBuffer.write("true");
			}else{
				userBuffer.write("false");    	
			}
			
			userBuffer.write(", ");
			
			//grava o dia do aluguel
			GregorianCalendar rentDay = user.getRentAvailabilityDay();
			userBuffer.write(rentDay.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            rentDay.get(GregorianCalendar.MONTH) + "/" +
		                            rentDay.get(GregorianCalendar.YEAR));

			userBuffer.write(", ");
			
			if(user.toString().equals("Student")){
				userBuffer.write(user.getSchoolId());
				userBuffer.write(", ");
				userBuffer.write(user.getAcademicDegree());
				userBuffer.write(", ");
			
			}else if(user.toString().equals("Professor")){
				userBuffer.write(user.getResearcherID());
				userBuffer.write(", ");
			
			}else if(user.toString().equals("CommunityMember")){
				userBuffer.write(user.getProfession());
				userBuffer.write(", ");
			}
			
			//grava o dia de hj
			userBuffer.write(today.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            today.get(GregorianCalendar.MONTH) + "/" +
		                            today.get(GregorianCalendar.YEAR));

			userBuffer.write("\n");
			
			userBuffer.close();
			
        } catch (IOException ex){
        	System.out.println("Failed at writing in file");
        }    	

    }
    
    public void clearFile(String fileId) {
        try {
            PrintWriter writer;
            if(fileId.equals("book"))
                writer = new PrintWriter(bookFile);
            else if(fileId.equals("user"))
                writer = new PrintWriter(userFile);
            else
                writer = new PrintWriter(loanFile);     
                
            writer.print("");
            writer.close();
       } catch (Exception e) {
           System.out.println("Erro no clearFile.");
       }
    }

    public void addBook(Book book) {
		try{
		
			FileWriter bookWriter = new FileWriter(bookFile, true);
			BufferedWriter bookBuffer = new BufferedWriter(bookWriter);
			
			bookBuffer.write(book.getTitle());
			bookBuffer.write(", ");
			bookBuffer.write(book.getSubtitle());
			bookBuffer.write(", ");
			
			ArrayList<String> authors = book.getAuthors();
			
			bookBuffer.write(String.valueOf(authors.size()));
			bookBuffer.write(", ");

			int i;

			for(i = 0; i < authors.size(); i++){
			
				bookBuffer.write(authors.get(i));
				bookBuffer.write(", ");
						
			}

			bookBuffer.write(String.valueOf(book.getEdition()));
			bookBuffer.write(", ");
			bookBuffer.write(String.valueOf(book.getYear()));
			bookBuffer.write(", ");
			bookBuffer.write(book.getPublisher());
			bookBuffer.write(", ");
			bookBuffer.write(String.valueOf(book.getNumPages()));
			bookBuffer.write(", ");
		
			if(book.isAvailableForCommunityMember()){
				bookBuffer.write("true");
			} else{
				bookBuffer.write("false");		
			}
		    bookBuffer.write(", ");
            
            if(book.isAvailable())
                bookBuffer.write("true");
            else
                bookBuffer.write("false");

			bookBuffer.write(", ");
			bookBuffer.write(String.valueOf(book.getIsnb()));

			bookBuffer.write(", ");
			//salva a data de criação
			bookBuffer.write(today.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            today.get(GregorianCalendar.MONTH) + "/" +
		                            today.get(GregorianCalendar.YEAR));

			bookBuffer.write("\n");
			
			bookBuffer.close();
			
        } catch (IOException ex){
        	System.out.println("Failed at writing in file");
        }
    }
    
    public void addLoan(Loan loan) {
    
    	try{
			FileWriter loanWriter = new FileWriter(loanFile, true);
			BufferedWriter loanBuffer = new BufferedWriter(loanWriter);
			
			loanBuffer.write(String.valueOf(loan.getBook().getIsnb()));
			loanBuffer.write(", ");
			loanBuffer.write(loan.getLocator().getId());
			loanBuffer.write(", ");
		
			GregorianCalendar initialCal = loan.getInitialCal();
			
			loanBuffer.write(initialCal.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            initialCal.get(GregorianCalendar.MONTH) + "/" +
		                            initialCal.get(GregorianCalendar.YEAR));
			
			loanBuffer.write(", ");
		
			GregorianCalendar deliveryCal = loan.getDeliveryCal();
			
			loanBuffer.write(deliveryCal.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            deliveryCal.get(GregorianCalendar.MONTH) + "/" +
		                            deliveryCal.get(GregorianCalendar.YEAR));
		                            
		    loanBuffer.write("\n");

            loanBuffer.close();

        } catch (IOException ex){
        	System.out.println("Failed at writing in file");
        }

	}
	
	public ArrayList<Book> loadBooks(){
		
		ArrayList<Book> books = new ArrayList<Book>();

		try{
			
			BufferedReader bookBuffer = new BufferedReader(new FileReader(bookFile));
			
			String line = bookBuffer.readLine();

			while(line != null){
				
				String data[] = line.split(", ");
			
				String ftitle = data[0];
				String fsubtitle = data[1];
				int fnumOfAuthors = Integer.parseInt(data[2]);
				
				//para ler os autores
				ArrayList<String> authors = new ArrayList<String>();
				int i;
				for(i=0; i<fnumOfAuthors; i++){
					authors.add(data[3+i]);
				}
				
				int fedition = Integer.parseInt(data[3+i]);
				int fyear = Integer.parseInt(data[4+i]);
				String fpublisher = data[5+i];
				int fnumOfPages = Integer.parseInt(data[6+i]);
				
				//para ler o boolean
				boolean favailableForCommunityMember;
				if(data[7+i].equals("true")){
					favailableForCommunityMember = true;
				}else {
					favailableForCommunityMember = false;
				}
			    
                boolean fAvailable;
                if(data[8+i].equals("true"))
                    fAvailable = true;
                else
                    fAvailable = false;
                
				int fisnb = Integer.parseInt(data[9+i]);

				//para ler a data
				String date[] = data[10+i].split("/");
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);				
				int year = Integer.parseInt(date[2]);				
				
				GregorianCalendar fdate = new GregorianCalendar(year, month, day, 0, 0, 0);
				
				Book fbook = new Book(ftitle, fsubtitle, fedition, fyear, fpublisher, fnumOfPages, favailableForCommunityMember, fisnb, authors);
		        fbook.setAvailable(fAvailable);		
                books.add(fbook);
				line = bookBuffer.readLine();
				
			}
			
			
		} catch (IOException ex) {
			System.out.println("Failed at reading the file");
		}
		
		return books;
	}
	
	public ArrayList<User> loadUsers(){

		ArrayList<User> users = new ArrayList<User>();
		User fuser;
		
		try{
		
			BufferedReader userBuffer = new BufferedReader(new FileReader(userFile));
			
			String line = userBuffer.readLine();

			while(line != null){
				
				String data[] = line.split(", ");
			
				String ftype = data[0];
								
				if(ftype.equals("Student")){
					fuser = loadStudent(data);
					
				} else if (ftype.equals("Professor")){
					fuser = loadProfessor(data);
					
				} else {
					fuser = loadCommunityMember(data);
					
				}

                users.add(fuser);
				line = userBuffer.readLine();
			}
		
		} catch (IOException ex){
			System.out.println("Failed at reading the file");
		}
		
		
		return users;
	}
	
	private Student loadStudent(String[] data){

		String fname = data[1];
		String fid = data[2];
		String ftelephoneNumber = data[3];
		String femail = data[4];
	
		//para ler o boolean
		boolean fcanrent;
		if(data[5].equals("true")){
			fcanrent = true;
		}else {
			fcanrent = false;
		}
	
		//para ler a data
		String date[] = data[6].split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);				
		int year = Integer.parseInt(date[2]);				
	
		GregorianCalendar fdate = new GregorianCalendar(year, month, day, 0, 0, 0);
		
		String fschoolId = data[7];
		String facademicDegree = data[8];
		
		Student student = new Student(data[1], data[2], data[3], data[4], fdate, fschoolId, facademicDegree);
		
		return student;
	}
	
	private Professor loadProfessor(String[] data){

		String fname = data[1];
		String fid = data[2];
		String ftelephoneNumber = data[3];
		String femail = data[4];
	
		//para ler o boolean
		boolean fcanrent;
		if(data[5].equals("true")){
			fcanrent = true;
		}else {
			fcanrent = false;
		}
	
		//para ler a data
		String date[] = data[6].split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);				
		int year = Integer.parseInt(date[2]);				
	
		GregorianCalendar fdate = new GregorianCalendar(year, month, day, 0, 0, 0);
		
		String fresearcherId = data[7];
		
		Professor professor = new Professor(data[1], data[2], data[3], data[4], fdate, fresearcherId);
		
		return professor;
	}
	
	
	private CommunityMember loadCommunityMember(String[] data){

		String fname = data[1];
		String fid = data[2];
		String ftelephoneNumber = data[3];
		String femail = data[4];
	
		//para ler o boolean
		boolean fcanrent;
		if(data[5].equals("true")){
			fcanrent = true;
		}else {
			fcanrent = false;
		}
	
		//para ler a data
		String date[] = data[6].split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);				
		int year = Integer.parseInt(date[2]);				
	
		GregorianCalendar fdate = new GregorianCalendar(year, month, day, 0, 0, 0);
		
		String fprofession = data[7];
		
		CommunityMember comMember = new CommunityMember(data[1], data[2], data[3], data[4], fdate, fprofession);
		
		return comMember;
	}
	
	
	public ArrayList<Loan> loadLoans(){

		ArrayList<Loan> loans = new ArrayList<Loan>();
		
		try{
		
			BufferedReader loanBuffer = new BufferedReader(new FileReader(loanFile));
			
			String line = loanBuffer.readLine();

			while(line != null){
				
				String data[] = line.split(", ");
			
				String fuserId = data[0];
				int fbookIsnb = Integer.parseInt(data[1]);
				
				//para ler a data
				String date[] = data[2].split("/");
				int day = Integer.parseInt(date[0]);
				int month = Integer.parseInt(date[1]);				
				int year = Integer.parseInt(date[2]);
				GregorianCalendar finitialDate = new GregorianCalendar(year, month, day, 0, 0, 0);
				
				date = data[3].split("/");
				day = Integer.parseInt(date[0]);
				month = Integer.parseInt(date[1]);				
				year = Integer.parseInt(date[2]);
				GregorianCalendar fdeliveryDate = new GregorianCalendar(year, month, day, 0, 0, 0);
				
				User fuser = new User("null", "null", "null", "null", true, fdeliveryDate);
				Book fbook = new Book("null", "null", 0, 0, "null", 0, true, 0, new ArrayList<String>());
				
				Loan floan = new Loan(fuser, fbook, finitialDate);
				floan.setDeliveryCal(fdeliveryDate);
				floan.setUserId(fuserId);
				floan.setBookId(fbookIsnb);
				
				line = loanBuffer.readLine();
			}
		
		} catch (IOException ex){
			System.out.println("Failed at reading the file");
		}
		
		
		return loans;
	}

}
