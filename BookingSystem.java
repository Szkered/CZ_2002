import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BookingSystem{
  
  private static DataBase db = new DataBase();
  private static boolean notLoggedIn = true;
  private static Customer customer;
  private static ArrayList<Ticket> cart = new ArrayList<Ticket>();
  private static Movie currentMovie;

  public static void mainMenu(){
    boolean continueFlag = true;

    while(continueFlag){
      System.out.println("Booking System:");
      System.out.println("1. Select movie from a Cineplex");
      System.out.println("2. Show all on showing movies");
      System.out.println("3. Check booking history");
      System.out.println("4. Go to my cart");
      System.out.println("5. Back to main meun");

      switch(App.selectionHandle("Enter a number", 5)){
        case 1:              
          printThenSelectMovieFromCineplex();
          break;
        case 2:              
          printThenSelectFromAllMovie();
          break;
        case 3:
          checkBookingHistory();
          break;
        case 4:
          cart();
          break;
        case 5:
          continueFlag = false;
          break;
      }
    }
  }

  public static Movie printThenSelectMovieFromCineplex(){
    int currentLevel = 4;
    int choice;
    Cineplex cineplex;

    System.out.println("Choose Cineplex:");
    int numHeader = 0;
    for(Cineplex c : db.getCineplexDB()){
      System.out.println(++numHeader + ". " + c.getCineplexName());
    }

    System.out.println("Choices:");
    System.out.println("1. Choose Movie");
    System.out.println("2. Go back..");

    if(App.selectionHandle("Action:", 2) == 1){
      choice = App.selectionHandle("Enter a number:", db.getCineplexDB().size());
      cineplex = db.getCineplexDB().get(choice-1);
    }else{
      navigation(currentLevel);
    }

    System.out.println("Movies on show in cineplex " + cineplex.getCineplexName());
    ArrayList<Movie> movieList = new ArrayList<Movie>();
    numHeader = 0;
    for(Session s : db.getSessionDB()){
      if(cineplex.containCinema(s.getCinema())){
        System.out.println(++numHeader + ". " + s.getMovie().getName());
        movieList.add(s.getMovie());
      }
    }

    System.out.println("Choices:");
    System.out.println("1. Choose Movie");
    System.out.println("2. Go back..");

    if(App.selectionHandle("Action:", 2) == 1){
      choice = App.selectionHandle("Choss a movie:", movieList.size());
      currentMovie = movieList.get(choice-1);
      printThenSelectSession(currentMovie);      
    }else{
      navigation(currentLevel);
    }
  }

  public static void printThenSelectFromAllMovie(){
    int currentLevel = 4;
    
    System.out.println("Choose Movie:");
    int numHeader = 0;
    for(Movie m : db.getMovieDB()){
      System.out.println(++numHeader + ". " + m);
    }

    System.out.println("Choices:");
    System.out.println("1. Select movie:");
    System.out.println("2. Go back..");
    
    if(App.selectionHandle("Action:", 2) == 1){
      int choice = App.selectionHandle("Select a movie:", db.getMovieDB().size());
      currentMovie = db.getMovieDB().get(choice-1);
      printThenSelectSession(currentMovie);      
    }else{
      navigation(currentLevel);
    }

  }

  public static void printThenSelectSession(Movie movie){
    int currentLevel = 2;

    ArrayList<Session> sessionList = new ArrayList<Session>();

    for(Session s : db.getSessionDB()){
      if(s.getMovie() == movie) sessionList.add(s);
    }

    System.out.println("====================MOVIE====================");
    System.out.println(movie);
    System.out.println("====================SESSION=====================");
    int numHeader = 0;
    for(Session s : sessionList)
      System.out.println(++numHeader + ". " + s);
    System.out.println(numHeader + ". Go back..");

    int choice = App.selectionHandle("Choose a session or go back:", sessionList.size());

    if(choice == numHeader){
      navigation(currentLevel);
    }else{
      printSeatLayoutThenSelectSeat(sessionList.get(choice-1));      
    }

  }
  
  public static void printSeatLayoutThenSelectSeat(Session session){
    int currentLevel = 1;
    Seat seatOfChoice;

    ArrayList<Seat> seatList = new ArrayList<Seat>();
    
    for(Seat s : db.getSeatDB())
      seatList.add(s);

    // Layout printing under construction

    System.out.println("Action:");
    System.out.println("1. Select Seat from this session");
    System.out.println("2. Go back..");

    if(App.selectionHandle("Enter a number:", 2) == 1){
      int seatsPerRow = session.getCinema().getSeatsPerRow();
      int row = App.selectionHandle("Enter row number:", seatsPerRow);
      int col = App.selectionHandle("Enter column number:", session.getCinema().getNumOfColumn());

      for(Seat s : seatList)
        if(s.getRow(seatsPerRow) == row && s.getCol(seatsPerRow) == col)
          seatOfChoice = s;

      Ticket ticket = new Ticket(seatOfChoice, customer.getType());
      System.out.println(ticket);

      System.out.println("Action:");
      System.out.println("1. Add this ticket to cart");
      System.out.println("2. Add to cart then check out");
      System.out.println("3. Go back..");
        
      switch(App.selectionHandle("Enter a number", 2)){
        case 1:
          cart.add(ticket);
          System.out.println("The ticket has been added to your cart\n");
          break;
        case 2:
          cart.add(ticket);
          System.out.println("The ticket has been added to your cart\n");
          cart();
          break;
        case 3:
          navigation(currentLevel);
          break;
      }
    }else{
      navigation(currentLevel);
    }
  }

  public static void customerLogin(){
    int currentLevel = 1;

    System.out.println("Choices");
    System.out.println("1. Login with your name");
    System.out.println("2. Go back..");

    if(App.selectionHandle("Action:", 2) == 1){
      // need to add validation for all the input
    
      Scanner sc = new Scanner(System.in);
      boolean customerDoesNotExist = false;


      System.out.println("====================LOGIN====================");    
      System.out.println("Please enter your full name:");
      String customerName = sc.nextLine();

      for(Customer c : db.getCustomerDB()){
        if(c.getName() == customerName){
          customerDoesNotExist = false;
          customer = c;
          System.out.println("Welcome back, " + customerName);
          break;
        }
      }

      if(customerDoesNotExist){
        System.out.println("Account not found");
        System.out.println("Choices");
        System.out.println("1. Create a new account");
        System.out.println("2. Re-enter your name");
      
        if(App.selectionHandle("Action:", 2) == 1){
          System.out.println("Congragulation on your first purchase at Cineplex!");
          System.out.println("For us to serve you better, we would like to create an account for you now\n");
      
          System.out.println("======================Account Registration=========================");
          System.out.println("Name: " + customerName + "\n");

      
          System.out.println("Please enter your mobile number:");
          int mobile = sc.nextInt();
      
          System.out.println("Plase enter your email:");
          String email = sc.next();
      
          // add email validation here
      
          System.out.println("Please enter your date of birth (in numerial form)");
          System.out.println("Year:");
          int year = sc.nextInt();
          System.out.println("Month:");
          int month = sc.nextInt();
          System.out.println("Day");
          int day = sc.nextInt();
          Calendar dob = new GregorianCalendar(year, month, day);

          customer = new Customer(customerName, mobile, email, dob);
        }else{
          customerLogin();
        }
      }
    }else{
      navigation(currentLevel);
    }
  }

  public static void navigation(int currentLevel){

    int numHeader;
    System.out.println("====================NAVIGATION====================");
    for(int i = currentLevel; i <= 5; i++){
      numHeader = i - currentLevel + 1;
      if(i==1) System.out.println(numHeader+". Go back to select another time for this movie");
      if(i==2) System.out.println(numHeader+". Go back to all movie list");
      if(i==3) System.out.println(numHeader+". Go back to select movie from cineplex");
      if(i==4) System.out.println(numHeader+". Go back to main menu");
      if(i==5) System.out.println(numHeader+". Go to my cart");
    }

    switch(App.selectionHandle("Enter a number", 6-currentLevel)){
      case 1:
        printThenSelectSession(currentMovie);
        break;
      case 2:
        printThenSelectFromAllMovie();
        break;
      case 3:
        printThenSelectMovieFromCineplex();
        break;
      case 4:
        mainMenu();
        break;
      case 5:
        cart();
        break;
    }

  }

  public static void cart(){
    int choice, numHeader;
    boolean continueFlag = true;

    while(continueFlag){
      System.out.println("====================MY CART====================\n");
      numHeader = 0;
      for(Ticket t : cart)
        System.out.println("----------"+ ++numHeader + "----------\n" + t);
      
      System.out.println("Choicses:");
      System.out.println("1. Check out");
      System.out.println("2. Delect a ticket");
      System.out.println("3. Exit");

      switch(App.selectionHandle("Action:", 3)){
        case 1:
          checkOut();
          continueFlag = false;
          break;
        case 2:
          choice = App.selectionHandle("Choose a ticket:", cart.size());
          cart.remove(choice-1);
          System.out.println("Ticket removed");
          break;
        case 3:
          continueFlag = false;
          break;
      }
    }
  }

  public static void checkOut(){
    int currentLevel = 2;
    Scanner sc = new Scanner(System.in);
    
    if(notLoggedIn) customerLogin();

    Payment payment = new Payment(cart, customer);

    payment.printInVoice();

    System.out.println("Choices:");
    System.out.println("1. Pay now");
    System.out.println("2. Go back..");

    if(App.selectionHandle("Action:", 2) == 1){
      System.out.println("Please enter your credit card number");
      int creditCard = sc.nextInt(); // add validation here
      System.out.println("Purchase is sucessful");
    }else{
      navigation(currentLevel);
    }
  }

  public static void checkBookingHistory(){
    int currentLevel = 4, numHeader;
    
    if(notLoggedIn) customerLogin();

    ArrayList<Payment> paymentList = new ArrayList<Payment>();

    for(Payment p : db.getPaymentDB())
      if(p.getCustomer().getName() == customer.getName())
        paymentList.add(p);

    numHeader = 0;
    for(Payment p : paymentList){
      System.out.println("++++++++++++++++++++No."+ ++numHeader + "++++++++++++++++++++");
      p.printInVoice();
      System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
    }
    
  }

}
