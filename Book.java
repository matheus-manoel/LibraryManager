import java.util.*;

public class Book {
	private ArrayList<String> authors; 
	private int edition;
	private String title;
	private String subtitle;
	private int year;
	private int isnb; //International Standard Book Number
	private String publisher;
	private int numPages;
	private boolean available;
	private boolean availableForCommunityMember;

	public Book(String title, String subtitle, int edition, int year, 
				String publisher, int numPages, boolean availableForCommunityMember, int isnb, ArrayList<String> authors) {
		this.title = title;
		this.subtitle = subtitle;
		this.edition = edition;
		this.year = year;
		this.publisher = publisher;
		this.numPages = numPages;
		this.available = true;
		this.availableForCommunityMember = availableForCommunityMember;
        this.isnb = isnb;
	    this.authors = authors;
    }
    
    public String getSubtitle() {
        return this.subtitle;
    }

    public int getEdition() {
        return this.edition;
    }

    public int getYear() {
        return this.year;
    }
    
    public int getNumPages() {
        return this.numPages;
    }

	public void addAuthor(String author) {
		this.authors.add(author);
	}

	public ArrayList<String> getAuthors() {
        return this.authors;
    }
    
    public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean isAvailable() {
		return this.available;
	}	
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public boolean isAvailableForCommunityMember() {
		return this.availableForCommunityMember;
	}

    public int getIsnb() {
        return this.isnb;
    }
}
