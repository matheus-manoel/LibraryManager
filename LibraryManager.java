//package

import java.util.*;
import java.util.ArrayList;
import java.text.*;

public class LibraryManager{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int option = -1;
        int day, month, year;
	    
        System.out.println("Insira a data: ");
		day = in.nextInt();
	    month = in.nextInt();
	    year = in.nextInt();
        Library library = new Library(day, month, year);
        
        library.start();
	}
	
}
