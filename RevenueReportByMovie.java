public class RevenueReportByMovie implements report{
    private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
    private ArrayList<Movie> movieList = new ArrayList<movie>();

    public RevenueReportByCineplex(){
        //read from database to get all the tickets ---->ticketList[]
        //read from database to get all the movies  ---->movieList
    }

    public void printMovieDetail(){
        int ticketCount = ticketList.size();
        int movieCount = movieList.size();
        
        double[] movieSales = new double[movieCount];

        
        for (int list=0; list<movieCount; list+=1){
            movieSales[list] = 0;
    
            for (int j=0; j<ticketCount; j+=1){
                if (ticketList[j].getSession().getMovie().getname()==movieList[list].getName())
                     movieSales[list]+=ticketList[j].getPrice();
            }
                
            System.out.print(movieList[list].getName()+ ":");
            System.out.print(movieSales[list]);
            //cinema                
            //period
            System.out.println(""); 
        }
    }
        
}

