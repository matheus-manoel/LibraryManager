package LM;

import java.util.*;
import java.util.ArrayList;
import java.text.*;

public class LibraryManager{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int option = -1;
        GregorianCalendar today;
        int day, month, year;
	    
        System.out.print("Insira o dia: ");
		day = in.nextInt();
		System.out.print("Insira o mês: ");
	    month = in.nextInt();
	    System.out.print("Insira o ano: ");
	    year = in.nextInt();
        today = new GregorianCalendar(year, month, day);
        Library library = new Library(today);
        
        library.start();
	}
	
}
