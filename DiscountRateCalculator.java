import java.util.Calendar;
import java.util.GregorianCalendar;

public class DiscountRateCalculator{
  private Session session;
  private CustomerType customerType;
  
  private double customerTypeIndex=1;
  private double threeDIndex=1;
  private double blockBusterIndex=1;
  private double holidayIndex=1;
  private double cinemaClassIndex=1;
  
  public DiscountRateCalculator(Session session, CustomerType customerType) {
    this.session = session;
    this.customerType= customerType;
    
    setCustomerTypeIndex();
    setThreeDIndex();
    setBlockBusterIndex();
    setHolidayIndex();
    setCinemaClassIndex();
  }
	
  public double getCustomerTypeIndex() {
    return customerTypeIndex;
  }
  public void setCustomerTypeIndex() {
    if(customerType==CustomerType.SENIOR){
      this.customerTypeIndex=0.8;
    }
    if(customerType==CustomerType.STUDENT){
      this.customerTypeIndex=0.9;
    }
		
  }

  public double getThreeDIndex() {
    return threeDIndex;
  }
  public void setThreeDIndex() {
    if(session.getMovie().getIs3D()==true){
      this.threeDIndex=2;
    }
  }
	
	
  public double getBlockBusterIndex() {
    return blockBusterIndex;
  }
  public void setBlockBusterIndex() {
    if(session.getMovie().getIsBlockBuster()==true){
      this.blockBusterIndex=2;
    }
  }
	
  public double getHolidayIndex() {
    return holidayIndex;
  }
  
  public void setHolidayIndex() {
    Holiday h = new Holiday();
    if(h.todayIsHoliday()){
      this.holidayIndex=0.6;      
    }
  }
	
  public double getCinemaClassIndex() {
    return cinemaClassIndex;
  }
  public void setCinemaClassIndex() {
    if(session.getCinema().getCinemaType()=="1"){
      this.cinemaClassIndex=2;
    }
    if(session.getCinema().getCinemaType()=="2"){
      this.cinemaClassIndex=1.5;
    }
  }

  public double getDiscountRate(){
    return customerTypeIndex * threeDIndex * blockBusterIndex
        * holidayIndex  *cinemaClassIndex;
  }

}
