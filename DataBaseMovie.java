// package assignment2002;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataBaseMovie {

    //load Movies
    public static ArrayList<Movie> loadMovie(){
        try{
            //temp movie arraylist to be returned
            ArrayList<Movie> movies = new ArrayList<Movie>();

            Scanner sc = new Scanner(new File("database_movie.txt"));
            String[] aMovieInfo = new String[7];
            while(sc.hasNextLine()){
                StringTokenizer sep = new StringTokenizer(sc.nextLine(),"|");
                //store all info of a single movie
                for (int i = 0; i < 7; i ++)
                    aMovieInfo[i] = sep.nextToken().trim();
                Movie m = new Movie(aMovieInfo[0],aMovieInfo[1],aMovieInfo[2],Boolean.parseBoolean(aMovieInfo[3]),Boolean.parseBoolean(aMovieInfo[4]),Integer.parseInt(aMovieInfo[5]),aMovieInfo[6]);
                movies.add(m);
            }
            return movies;

        }catch(IOException e){
            System.out.println("Error >>>" +e.getMessage());
        }
        return null;
    }

    //save
    public static void saveMovie(DataBase dataBase){
        BufferedWriter writer = null;
        try {
            //choose the file to be modified
            File targetFile = new File("database_movie.txt");

            // This will output the full path where the file will be written to...
//            System.out.println(targetFile.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(targetFile));
            for (int i =0; i<dataBase.getMovieDB().size();i++){
                writer.write(dataBase.getMovieDB().get(i).getName()+"|");
                writer.write(dataBase.getMovieDB().get(i).getRating()+"|");
                writer.write(dataBase.getMovieDB().get(i).getType()+"|");
                writer.write(dataBase.getMovieDB().get(i).getIs3D()+"|");
                writer.write(dataBase.getMovieDB().get(i).getIsBlockBuster()+"|");
                writer.write(dataBase.getMovieDB().get(i).getLength()+"|");
                writer.write(dataBase.getMovieDB().get(i).getStatus());
                writer.write("\n");
            }
            System.out.println("Movie Information Saved.");

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
