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

        

    }
        
}

