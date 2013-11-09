public class Ticket {
  
  private double price;
  private Seat seat;

  ////////////////////////////////////////////////////////////////////////////////

  public Ticket(Seat seat, CustomerType customerType){
    DiscountRateCalculator calculator = new DiscountRateCalculator(seat.getSession(), customerType);
    double basicPrice = seat.getSession().getMovie().getBasicPrice();
    this.seat = seat;
    this.price = basicPrice * calculator.getDiscountRate();
  }
  
  public double getPrice(){
    return this.price;
  }

  public Seat getSeat(){
    return this.seat;
  }

  ////////////////////////////////////////////////////////////////////////////////


  public String toString(){
    return seat.getSession() + "\n====================SEAT=====================\n" + seat
        + "\n====================PRICE=====================\n" + price;
  }
}
