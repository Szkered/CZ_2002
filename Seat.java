
public class Seat {
	protected int seatId;
	protected boolean occupied = false;
	protected int custumerId;
	public Seat(int seat_id)
	{
		seatId = seat_id;
		occupied = false;
		custumerId = 0;
	}
	public Seat()
	{
		seatId = 0;
		occupied = false;
		custumerId = 0;
	}
	public int getSeatId()
	{
		return seatId;
	}
	public int getRow(int seatsPerRow)
	{
		return seatId/seatsPerRow;
	}
	public int getNumber(int seatsPerRow)
	{
		return seatId%seatsPerRow;
	}
	public int getCustumerId()
	{
		return custumerId;
	}
	public boolean isOccupied()
	{
		return occupied;
	}
	public void assignSeat(int cust_id)
	{
		custumerId = cust_id;
		occupied = true;
	}
	public void unAssignSeat()
	{
		seatId = 0;
		occupied = false;
		custumerId = 0;
	}
	public void printSeat()
	{
		if (occupied = false)
			System.out.print(" O ");
		else
			System.out.print(" X ");
	}
}
