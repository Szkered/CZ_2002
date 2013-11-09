// package assignment2002;

import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class DataBase {

    ArrayList<Movie> movieDB;
    ArrayList<Cineplex> cineplexDB;
    ArrayList<Cinema> cinemaDB;
    ArrayList<Seat> seatDB;
    ArrayList<DoubleSeat> doubleSeatDB;
    ArrayList<Session> sessionDB;

    //main for testing purpose
    public static void main(String arg[]){
        DataBase db = new DataBase();

//        for testing purpose
//        for(int i =0; i < db.getMovieDB().size();i++)
//            db.getMovieDB().get(i).printMovieinfo();

//        for(Cineplex c:db.getCineplexDB())
//            c.printCineplexInfo();

//        for(Cineplex cine:db.getCineplexDB())
//            for(Cinema c: cine.getHall())
//                c.printSeats();
//        DataBaseMovie.saveMovie(db);
//        DataBaseCineplex.saveCineplex(db);

//        db.getCineplexDB().get(1).getHall()[0].getSeat()[0].assignSeat(1);
//        DataBaseCinema.saveCinema(db);
//        DataBaseSeat.saveSeat(db);
//        DataBaseDoubleSeat.saveDoubleSeat(db);
    }

    public DataBase(){
        movieDB = DataBaseMovie.loadMovie();
        cineplexDB = DataBaseCineplex.loadCineplex();
        cinemaDB = DataBaseCinema.loadCinema();
        seatDB = DataBaseSeat.loadSeat();
        doubleSeatDB = DataBaseDoubleSeat.loadDoubleSeat();

        DataBaseCinema.setDetail(cinemaDB,seatDB,doubleSeatDB,cineplexDB);
        DataBaseCineplex.setDetail(cineplexDB,cinemaDB);

    }

    public ArrayList<Movie> getMovieDB() {
        return movieDB;
    }

    public ArrayList<Cineplex> getCineplexDB(){
        return cineplexDB;
    }

    public ArrayList<Cinema> getCinemaDB() {
        return cinemaDB;
    }

    public ArrayList<Session> getSessionDB() {
        return sessionDB;
    }
}
