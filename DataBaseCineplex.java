// package assignment2002;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataBaseCineplex {

    //load Movies
    public static ArrayList<Cineplex> loadCineplex(){
        try{
            //temp movie arraylist to be returned
            ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();

            Scanner sc = new Scanner(new File("database_cineplex.txt"));
            String[] aCineplexInfo = new String[3];
            while(sc.hasNextLine()){
                StringTokenizer sep = new StringTokenizer(sc.nextLine(),"|");
                //store all info of a single movie
                for (int i = 0; i < 3; i ++)
                    aCineplexInfo[i] = sep.nextToken().trim();
                Cineplex c = new Cineplex(Integer.parseInt(aCineplexInfo[0]));
                c.setLocation(aCineplexInfo[1]);
                c.setHall(null);
                cineplexes.add(c);
            }
            return cineplexes;
        }catch(IOException e){
            System.out.println("Error >>>" +e.getMessage());
        }
        return null;
    }

    //set the cinemas of cineplex
    public static void setDetail(ArrayList<Cineplex> cineplexDataBase, ArrayList<Cinema> cinemaDataBase){
        try{
            Scanner sc = new Scanner(new File("database_cineplex.txt"));
            String[] aCineplexInfo = new String[3];
            int cineCount =0;
            int cinemaCount = 0;

            while(sc.hasNextLine()){
                StringTokenizer sep = new StringTokenizer(sc.nextLine(),"|");
                //store all info of a single movie
                for (int i=0; i < 3; i++)
                    aCineplexInfo[i] = sep.nextToken().trim();

                //get the number of cinemas, initialize cinema array and appoint the cinemas from database
                int numOfCinema = Integer.parseInt(aCineplexInfo[2]);
                Cinema[] cinemaArray = new Cinema[numOfCinema];
                for (int i=0; i<cinemaArray.length; i++){
                    cinemaArray[i] = cinemaDataBase.get(cinemaCount);
                    cinemaCount++;
                }

                cineplexDataBase.get(cineCount).setHall(cinemaArray);

                cineCount++;
            }
        }catch(IOException e){
            System.out.println("Error >>>" +e.getMessage());
        }
    }

    //save
    public static void saveCineplex(DataBase dataBase){
        BufferedWriter writer = null;
        try {
            //choose the file to be modified
            File targetFile = new File("database_cineplex.txt");

//             This will output the full path where the file will be written to...
//            System.out.println(targetFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(targetFile));
            for (int i =0; i<dataBase.getCineplexDB().size();i++){
                writer.write((i+1)+"|");
                writer.write(dataBase.getCineplexDB().get(i).getLocation()+"|");
                writer.write(dataBase.getCineplexDB().get(i).getHall().length+"|");

                writer.write("\n");
            }
            System.out.println("Cineplex Information Saved.");

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
