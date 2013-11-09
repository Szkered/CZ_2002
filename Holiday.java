import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

public class Holiday{

  private ArrayList<Calendar> holidays = new ArrayList<Calendar>();

  public Holiday(){
    GregorianCalendar newYear = new GregorianCalendar(2000, 1, 1);
    holiday.set(Calendar.MONTH, 1);
    holiday.set(Calendar.DATE, 1);
    holidays.add(holiday);
  }

  public boolean todayIsHoliday(){
    Calendar today = new GregorianCalendar();
    for(Calendar h : holidays){
      if(today.get(Calendar.MONTH) == h.get(Calendar.MONTH) &&
         today.get(Calendar.DATE) == h.get(Calendar.DATE)){
        return true;
      }else{
        return false;
      }
    }
  }
  
}
