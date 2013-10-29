
public class Movie {
	private String name;
	private	String rating;
	private	String type;
	private	Boolean threeD;
	private	Boolean blockBuster;
	private	int length;
	private	String status;
	private	Session showTime[];
	public Movie (String name, String type,Boolean threeD, Boolean blockBuster,int length, String status, Session showTime[])
	{
		this.name = name;
		//can import from database
		//......
		//or for admin setting
		this.rating = rating;
		this.type = type;
		this.threeD = threeD;
		this.blockBuster = blockBuster;
		this.length = length;
		this.status = status;
		this.showTime = showTime;
	}
	public Movie ()
	{
		name = "";
		rating = "";
		type = "";
		threeD = false;
		blockBuster = false;
		length = 0;
		status = "";
		showTime = null;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getRating()
	{
		return rating;
	}
	public void setRating(String rating)
	{
		this.rating = rating;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public boolean getIs3D()
	{
		return threeD;
	}
	public void setIs3D(boolean is3D)
	{
		this.threeD = is3D;
	}
	public boolean getIsBlockBuster()
	{
		return blockBuster;
	}
	public void setBlockBuster(boolean isBlockBuster)
	{
		this.blockBuster = isBlockBuster;
	}
	public int getLength()
	{
		return length;
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public Session getShowTime()
	{
		//not sure what to do
		return showTime[];
	}
	public void setShowTime(int showTime[])
	{
		//not sure what to do
		this.showTime[] = showtime[];
	}
	public void printMovieinfo()
	{
		System.out.println("Name   Type   Length   3D   Blockbuster Status");
		System.out.println(name+"   "+type+"   "+length+"   "+threeD+"   "+blockBuster+"   "+status+"   ");
		System.out.println("===Show Time===");
		int j;
		for(j = 0; j < showTime.length; j++)
			showTime[j].printSession();
		System.out.println();
	}
}
