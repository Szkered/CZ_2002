
public class Movie {
  
  private String name;
  private String rating;
  private String type;
  private Boolean is3D;
  private Boolean isBlockBuster;
  private int length;
  private String status;
  private double basicPrice;
  

  public Movie (String name, String rating, String type,Boolean is3D, Boolean isBlockBuster,int length, String status)
  {
    this.name = name;
    this.rating = rating;
    this.type = type;
    this.is3D = is3D;
    this.isBlockBuster = isBlockBuster;
    this.length = length;
    this.status = status;
  }
  
  public final double getBasicPrice() {
    return basicPrice;
  }

  public final void setBasicPrice(final double basicPrice) {
    this.basicPrice = basicPrice;
  }
  
  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getStatus(){
    return status;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public String getRating(){
    return rating;
  }

  public void setRating(String rating){
    this.rating = rating;
  }

  public String getType(){
    return type;
  }

  public void setType(String type){
    this.type = type;
  }

  public boolean getIs3D(){
    return is3D;
  }

  public void setIs3D(boolean is3D){
    this.is3D = is3D;
  }

  public boolean getIsBlockBuster(){
    return isBlockBuster;
  }

  public void setBlockBuster(boolean isBlockBuster){
    this.isBlockBuster = isBlockBuster;
  }

  public int getLength(){
    return length;
  }

  public void setLength(int length){
    this.length = length;
  }

  ////////////////////////////////////////////////////////////////////////////////
  
  public String toString(){
    return "\nName   Rating   Type   Length   3D   Blockbuster Status\n"
        +name+"   "+rating+"   "+type+"   "+length+"   "
        +is3D+"   "+isBlockBuster+"   "+status+"   ";
  }
}
