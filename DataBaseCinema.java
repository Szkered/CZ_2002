// package assignment2002;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataBaseCinema {

    //cinema txt explaination: cinemaid | capacity | number of seats | number of double seats | seats per row | cinema class | cineplex

    //load Cinemas
    public static ArrayList<Cinema> loadCinema(){
        try{
            //temp cinema arraylist to be returned
            ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

            Scanner sc = new Scanner(new File("database_cinema.txt"));
            String[] aCinemaInfo = new String[6];
            while(sc.hasNextLine()){
                StringTokenizer sep = new StringTokenizer(sc.nextLine(),"|");
                //store all info of a single movie
                for (int i = 0; i < 6; i ++)
                    aCinemaInfo[i] = sep.nextToken().trim();
                Cinema c = new Cinema(Integer.parseInt(aCinemaInfo[0]));
                c.setCapacity(Integer.parseInt(aCinemaInfo[1]));
                c.setSeat(null);
                c.setDoubleSeat(null);
                c.setSeatsPerRow(Integer.parseInt(aCinemaInfo[4]));
                c.setCinemaType(aCinemaInfo[5]);
                c.setCineplex(null);
                cinemas.add(c);
            }
            return cinemas;
        }catch(IOException e){
            System.out.println("Error >>>" +e.getMessage());
        }
        return null;
    }

    //set seats/double seats and cineplex
    public static void setDetail(ArrayList<Cinema> cinemaDataBase, ArrayList<Seat> seatDataBase, ArrayList<DoubleSeat> doubleSeatDataBase, ArrayList<Cineplex> cineplexDataBase){
        try{
            Scanner sc = new Scanner(new File("database_cinema.txt"));
            String[] aCinemaInfo = new String[7];
            int cinemaCount = 0;

            int seatCount =0;
            int doubleSeatCount = 0;

            while(sc.hasNextLine()){
                StringTokenizer sep = new StringTokenizer(sc.nextLine(),"|");
                //store all info of a single movie
                for (int i = 0; i < 7; i ++)
                    aCinemaInfo[i] = sep.nextToken().trim();

                //get the number of cinemas, initialize cinema array and appoint the cinemas from database
                int numOfSeats = Integer.parseInt(aCinemaInfo[2]);
                int numOfDoubleSeats = Integer.parseInt(aCinemaInfo[3]);
                Seat[] seatArray = new Seat[numOfSeats];
                DoubleSeat[] doubleSeatArray = new DoubleSeat[numOfDoubleSeats];
                for (int i=0; i<numOfSeats; i++){
                    seatArray[i] = seatDataBase.get(seatCount);
                    seatCount++;
                }
                for (int i=0; i<numOfDoubleSeats; i++){
                    doubleSeatArray[i] = doubleSeatDataBase.get(doubleSeatCount);
                    doubleSeatCount++;
                }
                //set seat, double seat and cineplex
                cinemaDataBase.get(cinemaCount).setSeat(seatArray);
                cinemaDataBase.get(cinemaCount).setDoubleSeat(doubleSeatArray);
                cinemaDataBase.get(cinemaCount).setCineplex(cineplexDataBase.get(Integer.parseInt(aCinemaInfo[6])-1));

                cinemaCount++;
            }
        }catch(IOException e){
            System.out.println("Error >>>" +e.getMessage());
        }
    }


    //save
    public static void saveCinema(DataBase dataBase){
        BufferedWriter writer = null;
        try {
            //choose the file to be modified
            File targetFile = new File("database_cinema.txt");

            writer = new BufferedWriter(new FileWriter(targetFile));
            for (int i =0; i<dataBase.getCinemaDB().size();i++){
                writer.write(dataBase.getCinemaDB().get(i).getCinemaId()+"|");
                writer.write(dataBase.getCinemaDB().get(i).getCapacity()+"|");
                writer.write(dataBase.getCinemaDB().get(i).getSeat().length+"|");
                writer.write(dataBase.getCinemaDB().get(i).getDoubleSeat().length+"|");
                writer.write(dataBase.getCinemaDB().get(i).getSeatsPerRow()+"|");
                writer.write(dataBase.getCinemaDB().get(i).getCinemaType()+"|");
                writer.write(dataBase.getCinemaDB().get(i).getCineplex().getCineplexId()+"|");
                writer.write("\n");
            }
            System.out.println("Cinema Information Saved.");

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
