import java.util.List;

public class Book {
	//todo: getter
	private List<String> authors = new List<String>(); 
	//todo: getter e setter
	private int edition;
	private String title;
	//todo: getter e setter
	private String subtitle;
	//todo: getter e setter
	private int year;
	//todo: getter e setter
	private int isnb; //International Standard Book Number
	private String publisher;
	private int numPages;
	private boolean available;

	public Book(String title, String subTitle, int edition, int year, String publisher, int numPages) {
		this.title = title;
		this.subTitle = subTitle;
		this.edition = edition;
		this.year = year;
		this.publisher = publisher;
		this.numPages = numPages;
		this.available = false;

		//todo: something with isnb and author
	}
	
	public void addAuthor(String author) {
		this.authors.add(author);
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean getAvailable() {
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
}
