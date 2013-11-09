import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class App{

  public static void main(String arg[]){

    boolean continueFlag = true;

    while(continueFlag){
      System.out.println("Welcome to Cineplex App:");
      System.out.println("1. Booking System");
      System.out.println("2. Admin System");
      System.out.println("3. Quit");

      switch(selectionHandle("Action:", 3)){
        case 1:
          BookingSystem.mainMenu();
          break;
        case 2:
          adminSystem();
          break;
        case 3:
          continueFlag = false;
          break;
      }
    }
  }

  ////////////////////////////////////////////////////////////////////////////////

  public static int selectionHandle(String prompt, int numOfChoice){
    Scanner sc = new Scanner(System.in);
    try{
      System.out.println(prompt);
      int choice = sc.nextInt();
      if(choice > numOfChoice || choice < 1)
        throw new Exception("Error >> Invalid Choice");
      return choice;
    }catch(InputMismatchException e){
      System.out.println("Error >>> Input value is not integer");
      selectionHandle(prompt, numOfChoice);
    }catch(Exception e){
      System.out.println(e.getMessage());
      selectionHandle(prompt, numOfChoice);
    }
  }
  
}
