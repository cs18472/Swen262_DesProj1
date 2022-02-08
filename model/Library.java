package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Library {

    protected static List<Song> songs = new ArrayList<>();
    protected static List<Artist> artists = new ArrayList<>();
    protected static List<Release> releases = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException{
        File songFile = new File("./model/src/songs.csv");
        FileReader fr = new FileReader(songFile);
    }
}
