/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mengxingxu
 */
public class Ticket {
    private Session session;
    private double price;
    private Seat seat;
    
    public Ticket(){
    }
    
    public Ticket(Movie movie, double price, Customer customer,
                        int sessionID, int seatID){
        this.price = price;
    }
    
    public void printTicketInfo(){
        
    }
    
    public double getPrice(){
        return price;
    }
    
    public void calculatePrice(String customerType){
        
    }
}
