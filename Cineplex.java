
public class Cineplex {
	private int cineplexId;
	private String location;
	private Cinema[] hall;
	public Cineplex(int cineplexId) {
		this.cineplexId = cineplexId;
	}
	public Cineplex() {}
	
	public int getCineplexId() {
		return cineplexId;
	}
	public void setCineplexId(int cineplexId) {
		this.cineplexId = cineplexId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Cinema[] getHall() {
		return hall;
	}
	public void setHall(Cinema[] hall) {
		this.hall = hall;
	}
	
	
	public void printCineplexInfo(){
		System.out.println("The NO."+cineplexId+" is at "+location);
	}
	
	public void printAllMovive(Session[] sessionList){
		
	}
	
	public void printOnShowingMoive(){
		
	}
	
	public void printComingSoomMoive(){
		
	}

	
	
	
	
	
	
	
}

