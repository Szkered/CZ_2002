import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

public class Customer {
  
  private String name;//primary key
  private int mobile;
  private String email;
  private Calendar dob;

  // STATIC
  public static final int STUDENT_AGE = 24;
  public static final int SENIOR_AGE = 60;

  ////////////////////////////////////////////////////////////////////////////////
    
  public Customer(String name,
                  int mobile,
                  String email, 
                  Calendar dob){
    this.name = name;
    this.mobile = mobile;
    this.email = email;
    this.dob = dob;
  }
    
  public String getName(){
    return name;
  }
    
  public void setMobile(int mobile){
    this.mobile = mobile;
  }
    
  public void setEmail(String email){
    this.email = email;
  }
    
  public void printCustomerInfo(){
    System.out.println("name: "+name);
    System.out.println("mobile: "+mobile);
    System.out.println("email: "+email);
    System.out.println("date of birth: "+dob);
  }


  ////////////////////////////////////////////////////////////////////////////////
    
  public CustomerType getType(){

    Calendar now = new GregorianCalendar();
    int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        
    if(age < STUDENT_AGE){
      return CustomerType.STUDENT;
    }else if(age > SENIOR_AGE){
      return CustomerType.SENIOR;
    }else{
      return CustomerType.NORMAL;
    }
    
  }
            
}
