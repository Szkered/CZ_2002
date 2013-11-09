public class Seat {

  private Session session;
  protected int seatID;
  protected boolean occupied = false;
  protected boolean Double;
  
  public Seat(int seatID,boolean Double,Session session)
  {
    this.seatID = seatID;
    this.session = session;
    occupied = false;
    Double=false;
  }


  public final Session getSession() {
    return session;
  }


  public final void setSession(final Session session) {
    this.session = session;
  }
  
  public int getSeatID(){
    return seatID;
  }

  public int getRow(int seatsPerRow){
    return seatID/session.getCinema().getSeatsPerRow();
  }

  public int getCol(int seatsPerRow){
    return seatID%session.getCinema().getSeatsPerRow();
  }

  public boolean isOccupied(){
    return occupied;
  }
  
  public boolean isDouble(){
	    return Double;
  }
  
  public void assignSeat(){
    occupied = true;
  }

  public void unAssignSeat(){
    occupied = false;
  }

  public void printSeatLayout(){
    if (occupied == false)
      System.out.print(" O ");
    else
      System.out.print(" X ");
  }

  public String toString(){
    return "Row: " + getRow(seatID) + "Number: " + getCol(seatID);
  }
  
}
