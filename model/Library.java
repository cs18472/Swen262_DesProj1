package model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Library {

    private List<Song> songs;
    private List<Artist> artists;
    private List<Release> releases;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner songScanner = new Scanner(new File("data/songs.csv"));
        
        songScanner.useDelimiter(",");
        while(songScanner.hasNext()) {
            System.out.println(songScanner.next());
        }
    }
}
