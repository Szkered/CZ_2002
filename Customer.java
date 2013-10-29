/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mengxingxu
 */
public class Customer {
    private String name;
    private int mobile;
    private String email;
    private Date dob;
    private BookingHistory bookingHistory;
    
    public Customer(String name, int mobile, String email, 
                Calendar dob, BookingHistory bookingHistory){
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.dob = dob;
        this.bookingHistory = bookingHistory;
    }
    
    public Customer(){
    }
    
    public String getType(){
        return;
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
    
    public void printBookingHistory(){
        
    }
            
}
