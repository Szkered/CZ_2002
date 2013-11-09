// package assignment2002;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataBaseSeat {

    //database txt explaination: seatid|isOccupied|customerid that occupies this seat

    //load Seats
    public static ArrayList<Seat> loadSeat(){
        try{
            //temp seat arraylist to be returned
            ArrayList<Seat> seats = new ArrayList<Seat>();

            Scanner sc = new Scanner(new File("database_seat.txt"));
            String[] aSeatInfo = new String[3];
            while(sc.hasNextLine()){
                StringTokenizer sep = new StringTokenizer(sc.nextLine(),"|");
                //store all info of a single movie
                for (int i = 0; i < 3; i ++)
                    aSeatInfo[i] = sep.nextToken().trim();
                Seat s = new Seat(Integer.parseInt(aSeatInfo[0]));

                //read in seat status
                if (aSeatInfo[1].equals("false"))
                    s.unAssignSeat();
                else
                    s.assignSeat(Integer.parseInt(aSeatInfo[2]));

                seats.add(s);
            }
            return seats;
        }catch(IOException e){
            System.out.println("Error >>>" +e.getMessage());
        }
        return null;
    }


    //save
    public static void saveSeat(DataBase dataBase){
        BufferedWriter writer = null;
        try {
            //choose the file to be modified
            File targetFile = new File("database_seat.txt");

            writer = new BufferedWriter(new FileWriter(targetFile));
            for (int i =0; i<dataBase.getCinemaDB().size();i++){
                for (int j=0; j<dataBase.getCinemaDB().get(i).getSeat().length; j++){
                    writer.write(dataBase.getCinemaDB().get(i).getSeat()[j].getSeatId()+"|");
                    writer.write(dataBase.getCinemaDB().get(i).getSeat()[j].isOccupied()+"|");
                    writer.write(dataBase.getCinemaDB().get(i).getSeat()[j].getCustumerId()+"|");
                    writer.write("\n");
                }
            }
            System.out.println("Seat Information Saved.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





}
