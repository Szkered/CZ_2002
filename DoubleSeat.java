
public class DoubleSeat extends Seat{

	public DoubleSeat(int seat_id)
	{
		super(seat_id);
	}
	public DoubleSeat()
	{
		super();
	}
	public int getRow(int seatsPerRow)
	{
		return seatId/(2*seatsPerRow);
	}
	public int getNumber(int seatsPerRow)
	{
		return seatId%(2*seatsPerRow);
	}
}
