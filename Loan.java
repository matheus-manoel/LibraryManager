import java.util.*;

public class Loan {
	private User locator; 
	private GregorianCalendar initial_cal, deliveryCal; 
	private Book book;
	
	public Loan(User locator, Book book, GregorianCalendar today){
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
			new GregorianCalendar(today.get(GregorianCalendar.YEAR),
								  today.get(GregorianCalendar.MONTH),
				   				  today.get(GregorianCalendar.DAY_OF_MONTH));
		
		this.deliveryCal = 
			new GregorianCalendar(today.get(GregorianCalendar.YEAR),
								  today.get(GregorianCalendar.MONTH),
				   				  today.get(GregorianCalendar.DAY_OF_MONTH));
		
		//adicionando o número de dias máximo que o locator pode ficar com o livro
		this.deliveryCal.add(Calendar.DATE, this.locator.getMaxRentalDays());		

        System.out.println("delivery date: " + deliveryCal.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                            deliveryCal.get(GregorianCalendar.MONTH) + "/" +
                            deliveryCal.get(GregorianCalendar.YEAR));
    }
    
    public boolean updateLocatorRentAvailability(GregorianCalendar today){
        Date todayDate, deliveryCalDate;
        Date startDate, endDate;
        long startTime, endTime, diffTime, diffDays;
        GregorianCalendar newLocatorRentAvailableDay = 
                                    new GregorianCalendar(today.get(GregorianCalendar.YEAR),
								                          today.get(GregorianCalendar.MONTH),
				   				                          today.get(GregorianCalendar.DAY_OF_MONTH));

        //checando se a data de entrega já passou
        if(today.after(this.deliveryCal)) {
            locator.setCanRent(false);
            
            startDate = deliveryCal.getTime();
            endDate = today.getTime();
            startTime = startDate.getTime();
            endTime = endDate.getTime();
            diffTime = endTime - startTime;
            diffDays = diffTime / (1000*60*60*24); 
            newLocatorRentAvailableDay.add(GregorianCalendar.DAY_OF_MONTH, (int)diffDays);

            locator.setRentAvailabilityDay(newLocatorRentAvailableDay);


            System.out.println("pode alugar de novo: " + newLocatorRentAvailableDay.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                                newLocatorRentAvailableDay.get(GregorianCalendar.MONTH) + "/" +
                                newLocatorRentAvailableDay.get(GregorianCalendar.YEAR));

            return true;
        }

        return false;

    }
    
    public User getLocator(){
    	return this.locator;
    }
	
	public Book getBook(){
		return this.book;
    }
}
