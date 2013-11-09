public class Cinema {
  private int cinemaID;
  private int cinemaNumber;
  private int capacity;
  private int seatsPerRow;
  private String cinemaType;
  
  public Cinema(int cinema_ID,
                int cinemaNumber,
                int capacity,
                int seatsPerRow,
                String cinemaType){
    this.cinemaID = cinema_ID;
    this.cinemaNumber = cinemaNumber;
    this.capacity = capacity;
    this.seatsPerRow = seatsPerRow;
    this.cinemaType = cinemaType;
  }
  
  public final int getCinemaNumber() {
    return cinemaNumber;
  }

  public final void setCinemaNumber(final int cinemaNumber) {
    this.cinemaNumber = cinemaNumber;
  }

  public int getCinemaID(){
    return cinemaID;
  }

  public int getCapacity(){
    return capacity;
  }

  public String getCinemaType(){
    return cinemaType;
  }

  public int getSeatsPerRow(){
    return seatsPerRow;
  }

  public void setCinemaID(int cinemaID) {
    this.cinemaID = cinemaID;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public void setSeatsPerRow(int seatsPerRow) {
    this.seatsPerRow = seatsPerRow;
  }

  public void setCinemaType(String cinemaType) {
    this.cinemaType = cinemaType;
  }

  public int getNumOfColumn(){
    return this.capacity / this.seatsPerRow;
  }
}
