public class Book {
	private String name;
	private String publisher;
	private int numPages;
	private boolean available;

	Livro(String name, String publisher, int numPages) {
		this.name = name;
		this.publisher = publisher;
		this.numPages = numPages;
		this.available = false;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean getAvailable() {
		return this.available;
	}	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return this.publisher;
	}
}
