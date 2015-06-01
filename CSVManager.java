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
    	
    }


    public void addUser(User user) {
    	
    	try{
			FileWriter userWriter = new FileWriter(userFile);
			BufferedWriter userBuffer = new BufferedWriter(userWriter);
			
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
		
			GregorianCalendar rentDay = user.getRentAvailabilityDay();
			userBuffer.write(rentDay.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            rentDay.get(GregorianCalendar.MONTH) + "/" +
		                            rentDay.get(GregorianCalendar.YEAR));

			userBuffer.write(", ");
			
			if(user.toString() == "Student"){
				userBuffer.write(user.getSchoolId());
				userBuffer.write(", ");
				userBuffer.write(user.getAcademicDegree());
				userBuffer.write(", ");
			
			}else if(user.toString() == "Professor"){
				userBuffer.write(user.getResearcherID());
				userBuffer.write(", ");
			
			}else if(user.toString() == "CommunityMember"){
				userBuffer.write(user.getProfession());
				userBuffer.write(", ");
			}

			userBuffer.write(today.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
		                            today.get(GregorianCalendar.MONTH) + "/" +
		                            today.get(GregorianCalendar.YEAR));

			userBuffer.write("\n");
			
			userBuffer.close();
			
        } catch (IOException ex){
        	System.out.println("Failed at writing in file");
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
			
			bookBuffer.write(authors.size());
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
			FileWriter loanWriter = new FileWriter(loanFile);
			BufferedWriter loanBuffer = new BufferedWriter(loanWriter);
			
			loanBuffer.write(loan.getBook().getIsnb());
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
        } catch (IOException ex){
        	System.out.println("Failed at writing in file");
        }

	}

	public void readBook(){

		sss

	}

}
