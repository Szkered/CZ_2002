
public class Cinema {
	private int cinemaId;
	private int capacity;
	private Seat seat[];
	private DoubleSeat doubleSeat[];
	private int seatsPerRow;
	private String cinemaType;
	
	public Cinema(int cinema_Id)
	{
		cinemaId = cinema_Id;
		//read from database to get all the attributed of the cinema
        //........
	}
	public Cinema()
	{
		cinemaId = 0;
		//read from database to get all the attributed of the cinema
        //........
	}
	public int getCinemaId()
	{
		return cinemaId;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public String getCinemaClass()
	{
		return cinemaType;
	}
	public int getSeatsPerRow()
	{
		return seatsPerRow;
	}
	public boolean isFull()
	{
		int i;
		for (i=0;i<seat.length;i++)
		{
			if (seat[i].isOccupied() == false)
				return false;
		}
		return true;
	}
	public void printSeats()
	{
		int i,j;
		System.out.println("-----Seats of Cinema "+ cinemaId+"------");
		System.out.print("  ");
		for(i = 0; i < seatsPerRow; i++)
			System.out.print(" col "+i);
		for (i = 0;i < seat.length/seatsPerRow + 1;i++)
		{
			System.out.print("row "+ (i+1));
			for(j = 0; j < seatsPerRow; j++)
				seat[i*seatsPerRow + j].printSeat();
			System.out.println();
		}
	}
	public void printEmptySeats()
	{
		int i,j;
		System.out.println("-----Seats of Cinema "+ cinemaId+"------");
		System.out.print("  ");
		for(i = 0; i < seatsPerRow; i++)
			System.out.print(" col "+i);
		for (i = 0;i < seat.length/seatsPerRow + 1;i++)
		{
			System.out.print("row "+ (i+1));
			for(j = 0; j < seatsPerRow; j++)
			{
				if(seat[i*seatsPerRow + j].isOccupied()==true)
					System.out.print("   ");
				else
					seat[i*seatsPerRow + j].printSeat();
			}
			System.out.println();
		}
	}
}
