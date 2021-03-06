package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Composition which holds all of the songs, artists, and releases
 */
public final class Database{
  
    /**
     * Database class serves to hold the collection
     * of songs, artists, and releases in a block
     */

    protected static List<LibraryElement> songs = new ArrayList<>();
    protected static List<LibraryElement> releases = new ArrayList<>();
    protected static List<LibraryElement> artists = new ArrayList<>();


    //Type 1 = Songs, type 2 = Releases, type 3 = Artists
    public static List<LibraryElement> search(int type, String input, Searcher searcher) {
        if (type == 1){
            return searcher.doSearch(songs, input);
        }
        else if(type == 2){
            return searcher.doSearch(releases, input);
        }
        else if (type== 3){
            return searcher.doSearch(artists, input);
        }
        else{
            System.out.println("Error: Incorrect type specified");
            return null;
        }
    }
    
    /**
     * Main method collects data
     * from csv docs and organizes them into
     * a static Database block with buffered readers
     */
    public static void main(String[] args) throws IOException{
        //Songs
        File songFile = new File("./model/src/songs.csv");
        FileReader fr = new FileReader(songFile);
        BufferedReader brSongs = new BufferedReader(fr);

        String line;
        while((line = brSongs.readLine()) != null) {
            String[] strArr = line.split(",");
            
            
            String guid = strArr[0];
            String artistGuid = strArr[1];
            int duration = Integer.parseInt(strArr[2]);
            String title = "";
            for(int i = 3; i < strArr.length; i++) title += strArr[i];

            songs.add(new Song(title, guid, artistGuid, "", duration));
            
        }
        brSongs.close();

        //releases
        File releaseFile = new File("./model/src/releases.csv");
        fr = new FileReader(releaseFile);
        BufferedReader brReleases = new BufferedReader(fr);

        while((line = brReleases.readLine()) != null) {
            String[] strArr = line.split(",");
            
            int i = 0;
            String guid = strArr[i];
            i++;
            String artistGuid = strArr[i];
            i++;
            String title;
            if(strArr[i].contains("\"")) {
                title = strArr[i] + "," + strArr[i+1];
                i+=2;
            } else {
                title = strArr[i];
                i++;
            }

            String medium = strArr[i];
            i++;
            String issueDate = strArr[i];
            i++;
            List<LibraryElement> releaseSongs = new ArrayList<>();
            for(; i < strArr.length; i++) {
                for(LibraryElement s : songs){
                    if(s.getGuid().equals(strArr[i])) releaseSongs.add(s);
                }
            }

            releases.add(new Release(guid, title, artistGuid, "", issueDate, medium, releaseSongs));
            i = 0;
        }
        
        brReleases.close();

        //Artists
        File artistFile = new File("./model/src/artists.csv");
        fr = new FileReader(artistFile);
        BufferedReader brArtist = new BufferedReader(fr);

        while((line = brArtist.readLine()) != null) {
            String[] strArr = line.split(",");
            
            String guid = strArr[0];
            String name = strArr[1];
            String type;
            if(strArr.length > 2) type = strArr[2];
            else type = "";

            List<LibraryElement> artistSongs = new ArrayList<>();
            List<LibraryElement> artistReleases = new ArrayList<>();

            for(LibraryElement song : songs) if(song.getArtistGuid().equals(guid)) {
                song.addName(name);
                artistSongs.add(song);
            }
            for(LibraryElement release : releases) if(release.getArtistGuid().equals(guid)) {
                release.addArtist(name);
                artistReleases.add(release);
            }

            artists.add(new Artist(artistSongs, artistReleases, guid, name, type));
            
        }
        brSongs.close();
    }
}
