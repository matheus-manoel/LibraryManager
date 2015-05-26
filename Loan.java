import java.util.*;

public class Loan {
	private User locator; 
	private GregorianCalendar initial_cal, finalCal; 
	private Book book;
	
	public Loan(User locator, Book book, GregorianCalendar current_cal){
		this.locator = locator;
		this.book = book;
		
		/* Aqui acontece algo iteressante: não podemos simplesmente declarar objetos
		 * do tipo GregorianCalendar e atribuir outro objeto do mesmo tipo a ele,
		 * pois ambos iriam ter uma referência a mesma data! Assim, se um objeto
		 * mudasse de data através do método add(), por exemplo, o outro também 
		 * mudaria. Por isso é necessário a criação de outro objeto, passando como
		 * argumento os valores do que queremos copiar.
		 */
		this.initial_cal = 
			new GregorianCalendar(current_cal.get(GregorianCalendar.YEAR),
								  current_cal.get(GregorianCalendar.MONTH),
				   				  current_cal.get(GregorianCalendar.DAY_OF_MONTH));
		
		this.finalCal = 
			new GregorianCalendar(current_cal.get(GregorianCalendar.YEAR),
								  current_cal.get(GregorianCalendar.MONTH),
				   				  current_cal.get(GregorianCalendar.DAY_OF_MONTH));
		
		//adicionando o número de dias máximo que o locator pode ficar com o livro
		this.finalCal.add(Calendar.DATE, this.locator.getMaxRentalDays());		
	}
    
    public boolean updateLocatorRentAvailability(GregorianCalendar today){
        Date todayDate, finalCalDate;
        long startTime, endTime, diffTime, diffDays;
        GregorianCalendar newLocatorRentAvailableDay = 
                                    new GregorianCalendar(today.get(GregorianCalendar.YEAR),
								                          today.get(GregorianCalendar.MONTH),
				   				                          today.get(GregorianCalendar.DAY_OF_MONTH));

        //checando se a data de entrega já passou
        if(today.after(this.finalCal)) {
            locator.setCanRent(false);
            
            
            startTime = finalCal.getTime();
            endTime = today.getTime();
            diffTime = endTime - startTime;
            diffDays = diffTime / (1000*60*60*24); 
            newLocatorRentAvailableDay.add(GregorianCalendar.DAY_OF_MONTH, (int)diffDays);

            locator.setRentAvailabilityDay(newLocatorRentAvailableDay);
            return true;
        }

        return false;

    }

}
