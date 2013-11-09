import java.util.GregorianCalendar;
import java.util.Calendar;

public class Session{

  private Calendar startTime;
  private Calendar endTime;
  private Movie movie;
  private Cinema cinema;

  ////////////////////////////////////////////////////////////////////////////////
  // Constructor & Get Set
  ////////////////////////////////////////////////////////////////////////////////

  public Session(int hour, int minute, int dayOfWeek, Cinema cinema, Movie movie){
    startTime = new GregorianCalendar();
    startTime.set(Calendar.HOUR, hour);
    startTime.set(Calendar.MINUTE, minute);
    startTime.set(Calendar.DAY_OF_WEEK, dayOfWeek);
    
    int lengthHour = movie.getLength() / 60;
    int lengthMinute = movie.getLength() % 60;
    
    endTime = (Calendar)startTime.clone();
    endTime.add(Calendar.HOUR, lengthHour);
    endTime.add(Calendar.MINUTE, lengthMinute);
    
    this.cinema = cinema;
    this.movie = movie;
  }

  public final Cinema getCinema() {
    return cinema;
  }

  public final void setCinema(final Cinema cinema){
    this.cinema = cinema;
  }
  
  public final Movie getMovie() {
    return movie;
  }

  public final void setMovie(final Movie movie) {
    this.movie = movie;
  }

  ////////////////////////////////////////////////////////////////////////////////
  // Time
  ////////////////////////////////////////////////////////////////////////////////

  
  public final Calendar getStartTime() {
    return startTime;
  }
  
  public final int getStartHour() {
    return startTime.get(Calendar.HOUR);
  }
  
  public final int getStartMinute() {
    return startTime.get(Calendar.MINUTE);
  }

  public final void setStartTime(int hour, int minute) {
    startTime.set(Calendar.HOUR, hour);
    startTime.set(Calendar.MINUTE, minute);
  }

  public final Calendar getEndTime() {
    return endTime;
  }
  public final int getEndHour() {
    return endTime.get(Calendar.HOUR);
  }
  
  public final int getEndMinute() {
    return endTime.get(Calendar.MINUTE);
  }

  public final int getDayOfWeek(){
    return startTime.get(Calendar.DAY_OF_WEEK);
  }

  ////////////////////////////////////////////////////////////////////////////////
  // Print
  ////////////////////////////////////////////////////////////////////////////////
  
  public String toString(){
    return "Showtime: " + getStartHour() + ":" + getStartMinute() + "@ Cinema" + cinema.getCinemaNumber();
  }

}
