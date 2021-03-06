import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

public class Payment {
  
  private ArrayList<Ticket> tickets;
  private double totalPrice;
  private Calendar purchaseDate;
  private Customer customer;

  public Payment(ArrayList<Ticket> tickets, Customer customer){
    this.tickets = tickets;
    this.totalPrice = calculateTotalPrice();
    purchaseDate = new GregorianCalendar();
    this.customer = customer;
  }

  public final Customer getCustomer() {
    return customer;
  }

  public final void setCustomer(final Customer customer) {
    this.customer = customer;
  }
  
  public void printInVoice(){
    System.out.println("===============Payment===============");

    int numHeader = 0;
    for(Ticket t : tickets){
      System.out.println("---------------Ticket["+ ++numHeader +"]---------------");      
      System.out.println(t);
      System.out.println("------------------------------------");
    }

    System.out.println("Total Price: " + totalPrice);
    System.out.println("================Date================");
    printPurchaseDate();
  }

  public void printPurchaseDate(){
    SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
    System.out.println(dateFormatter.format(purchaseDate));
  }

  public double calculateTotalPrice(){
    int totalPrice = 0;
    
    for(Ticket t : tickets){
      totalPrice += t.getPrice();
    }

    return totalPrice;
  }
    
  public double getTotalPrice(){
    return totalPrice;
  }
    
}
