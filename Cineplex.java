public class Cineplex {
  private int cineplexID;
  private String cineplexName;
  private String address;
  private Cinema[] hall;

  public Cineplex(int cineplexID, String cineplexName, String address, Cinema[] cinemaList) {
    this.cineplexID = cineplexID;
    this.cineplexName = cineplexName;
    this.address = address;
    this.hall = cinemaList;
  }

  public final String getCineplexName() {
    return cineplexName;
  }

  public final void setCineplexName(final String cineplexName) {
    this.cineplexName = cineplexName;
  }
	
  public int getCineplexId() {
    return cineplexID;
  }
  public void setCineplexId(int cineplexID) {
    this.cineplexID = cineplexID;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  
  public Cinema[] getHall() {
    return hall;
  }
  
  public void setHall(Cinema[] hall) {
    this.hall = hall;
  }

  public void printCineplexAddress(Cineplex cineplex){
    System.out.println(cineplex.getCineplexName()+" is at "+ address);
  }

  public boolean containCinema(Cinema cinema){
    for(Cinema c : hall){
      if(c.getCinemaID() == cinema.getCinemaID()) return true;
    }
    return false;
  }
	
}

