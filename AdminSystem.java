import java.util.InputMismatchException;
import java.util.Scanner;
public class AdminSystem {
  private static String password="admin";
  private static Cineplex[] cineplex = new Cineplex[3];
  private static DataBase db  = new DataBase();
  private static Report report  = new Report();
  public static Scanner in;
  public static void main(String[] args) {
    in= new Scanner(System.in);
    int counter=0;
    int valid=0;
    String passwordinput="";
		
    System.out.println("Please input the password to login: ");
    do{
      passwordinput=in.nextLine();
      valid=login(passwordinput);
      if(valid==0){
        counter++;
        System.out.println("Invalid Password!!");
        System.out.println("Please input the password again: (You still have" + (3-counter)+" times.");
      }
      else
        break;
    }while(counter<3);
    if(valid==0){
      System.out.println("Invalid Password!!");
      System.out.println("Back to main menu.");
      return;
    } 
    /*continue to run the normal functions*/
    int choice;
    do{
      Scanner sc = new Scanner(System.in);
      System.out.println("What do you want:");
      System.out.println("1. See all movie list");
      System.out.println("2. Add Movie");
      System.out.println("3. Delete Movie");
      System.out.println("4. Change Movie Information");
      System.out.println("5. Get Report");
      System.out.println("6. ......");
      System.out.println("7. ......");
      System.out.println("8. ......");
      choice = sc.nextInt();
      switch(choice)
      {
        case 1:{
          for (int i = 0; i <= cineplex.length;i++)
          {
            cineplex[i].printCineplexInfo();
            cineplex[i].printAllMovie(db.getSessionList());
          }
          break;
        }
        case 2:{
          db.addMovie();
          break;
        }
        case 3:{
          db.removeMovie();
          break;
        }
        case 4:{
          db.changeMovieInfo();
          break;
        }
        case 5:{
          report.printReport();
          break;
        }
        case 6:{
          break;
        }
        case 7:{
          break;
        }
        case 8:{
          break;
        }
      }
    }while(choice<9);

  }
	
  public static int login(String passwordinput){
    if(passwordinput==password){
      return 1;
    }
    else return 0;
  }

}
