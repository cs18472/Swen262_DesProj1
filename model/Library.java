package model;

import java.util.ArrayList;
import java.util.List;

import model.searches.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

/**
 * Composition for creating personal librarys
 */
public class Library implements LibraryElement{

    public static final int GUID_LENGTH = 36;
    public static final String LIBRARY_PATH = "model/Library.txt";

    private List<LibraryElement> songs = new ArrayList<>();
    private List<LibraryElement> releases = new ArrayList<>();
    private List<LibraryElement> artists = new ArrayList<>();
    private File librarytxt = new File(LIBRARY_PATH);

    public Library(){
        this.songs = new ArrayList<>();
        this.releases = new ArrayList<>();
        this.artists = new ArrayList<>();
    }

    public void initalize() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(librarytxt));
        String line;
        while((line = reader.readLine()) != null) {
            add(line);
        }
        reader.close();
    }

    public void add(String guid) throws IOException{
        List<LibraryElement> result;
        boolean added = false;
        LibraryElement found = null;
        //Search songs
        result = Database.search(1, guid, new DBGUIDSearch());
        if(result != null){
            LibraryElement element = result.get(0);
            if(!songs.contains(element)) {
                songs.add(element);
                added = true;
                found = element;
            }

        }
        else{
            //Search releases
            result = Database.search(2, guid, new DBGUIDSearch());
            if(result != null){
                LibraryElement element = result.get(0);
                if(!releases.contains(element)){
                    releases.add(element);
                    added = true;
                    found = element;
                }
            }
        }
        if(added == true){
            FileWriter writer = new FileWriter(librarytxt, true);
            writer.append(guid + "\n");
            writer.flush();
            writer.close();

            System.out.println("Added successfully.");
            //Artist
            String artistGuid = found.getArtistGuid();
            for(LibraryElement element2 : artists){
                if(element2.getGuid().equals(artistGuid)){
                    return;
                }
            }
            addArtist(artistGuid);
        }
        else{
            System.out.println("No song or release found with that GUID that isn't in your library.");
        }
    }

    public void remove(String guid) throws IOException{
        boolean found = false;
        String artistGuid = "";
        //Search songs
        for(LibraryElement element : songs){
            if(element.getGuid().equals(guid)){
                artistGuid = element.getArtistGuid();
                songs.remove(element);
                found = true;
                break;
            }
        }
        //Search releases
        if(found == false){
            for(LibraryElement element : releases){
                if(element.getGuid().equals(guid)){
                    artistGuid = element.getArtistGuid();
                    releases.remove(element);
                    found = true;
                    break;
                }
            }
        }
        if(found == true){
            System.out.println("Removed successfully.");
            FileReader reader = new FileReader(librarytxt);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> library = new ArrayList<>();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                if(!line.equals(guid)) library.add(line);
            }

            PrintWriter pWriter = new PrintWriter(librarytxt);
            pWriter.print("");
            pWriter.flush();
            pWriter.close();

            String libraryStr = "";
            for(String s : library) {
                libraryStr += s + "\n";
            }

            BufferedWriter bWriter = new BufferedWriter(new FileWriter(librarytxt));
            bWriter.write(libraryStr);
            bWriter.close();
            bufferedReader.close();
            
            //Search if any other songs are from the same artist
            for(LibraryElement song : songs){
                if(song.getArtistGuid() != null && song.getArtistGuid().equals(artistGuid)){
                    return;
                }
            }
            //Search if any other releases are from the same artist
            for(LibraryElement release : releases){
                if(release.getArtistGuid() != null && release.getArtistGuid().equals(artistGuid)){
                    return;
                }
            }
            //Since no other element was made by the same artist, remove the artist
            for(LibraryElement element3 : artists){
                if(element3.getGuid().equals(artistGuid)){
                    artists.remove(element3);

                    reader = new FileReader(librarytxt);
                    bufferedReader = new BufferedReader(reader);
                    library = new ArrayList<>();
                    line = "";
                    while((line = bufferedReader.readLine()) != null) {
                        if(!line.equals(artistGuid)) library.add(line);
                    }

                    pWriter = new PrintWriter(librarytxt);
                    pWriter.print("");
                    pWriter.flush();
                    pWriter.close();

                    libraryStr = "";
                    for(String s : library) {
                        libraryStr += s + "\n";
                    }

                    bWriter = new BufferedWriter(new FileWriter(librarytxt));
                    bWriter.write(libraryStr);
                    bWriter.close();
                    bufferedReader.close();
                    return;
                }
            }
        }
        else{
            System.out.println("No element with that ID within the collection.");
            return;
        }
    }

    // Add artist to the collection.
    @Override
    public void addArtist(String guid) {
        List<LibraryElement> result = Database.search(3, guid, new DBGUIDSearch());
        if(result != null){
            artists.add(result.get(0));

            
            try {
                FileWriter writer = new FileWriter(librarytxt, true);
                writer.append(guid + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("error adding artist");
            }
           
        }
    }

    @Override
    public List<LibraryElement> search(int type, String input, Searcher searcher) {
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

    //Gets all the work from an artist based on their GUID
    @Override
    public List<LibraryElement> getArtistWork(String guid){
        List<LibraryElement> found = new ArrayList<>();
        List<LibraryElement> songResult = this.search(1, guid, new PLSongArtistGUIDSearch());
        if(songResult != null){
            for(LibraryElement song : this.search(1, guid, new PLSongArtistGUIDSearch())){
                found.add(song);
            }
        }
        List<LibraryElement> releaseResult = this.search(2, guid, new PLReleaseArtistGUIDSearch());
        if(releaseResult != null){
            for(LibraryElement release : releaseResult){
                found.add(release);
            }
        }
        if(found.size() == 0) return null;
        return found;
    }

    @Override
    public List<LibraryElement> getArtists() {
        return artists;
    }

    //Unused Methods
    @Override
    public String getGuid() {return null;}
    @Override
    public String getArtistGuid() {return null;}
    @Override
    public void addName(String name) {}
    @Override
    public String getTitle() {return null;}
    @Override
    public List<LibraryElement> getSongs() {return null;}
    @Override
    public String getArtist() {return null;}
    @Override
    public String getName() {return null;}
    @Override
    public int getDuration() {return 0;}
    @Override
    public String getIssueDate() {return null;}
    @Override
    public String getType() {return null;}

    public static void main(String[] args){
        Library pb = new Library();
        try{
            Database.main(args);

            System.out.println("\nAdd Test:");
            pb.add("477c33b8-fa6a-46bc-866b-64f8585be7fa"); //Valid song
            pb.add("2bf203ad-32df-3073-a6ff-a9ce76879b61"); //Valid release
            pb.add("2bf203ad-32df-3073-a6ff-a9ce76879b6"); //Invalid GUID
            pb.add("6d3f3086-dedd-4d3b-a791-99a4a3f4f141"); //Valid Song
            pb.add("a6c6897a-7415-4f8d-b5a5-3a5e05f3be67"); //Invalid because it's an artist
            for(LibraryElement element : pb.songs){
                System.out.println(element);
            }
            for(LibraryElement element : pb.releases){
                System.out.println(element);
            }
            for(LibraryElement element : pb.artists){
                System.out.println(element);
            }

            System.out.println("\nAlphabetize Test:");
            List<LibraryElement> result = pb.search(1, "YOOOO", new PLSongAlphabeticalSearch());
            for(LibraryElement element : result){
                System.out.println(element);
            }
            
            System.out.println("\nRemove Test:");
            pb.remove("477c33b8-fa6a-46bc-866b-64f8585be7fa"); //Valid song
            pb.remove("2bf203ad-32df-3073-a6ff-a9ce76879b6"); //Invalid GUID
            pb.remove("2bf203ad-32df-3073-a6ff-a9ce76879b61"); //Valid release
            pb.remove("925c7673-0e85-410f-b7e4-d9705a7aa619"); //Invalid because it is an artist
            pb.remove("721427f0-5ff4-4ba7-a976-e3c21b05a586"); //Invalid because song isn't in library
            for(LibraryElement element : pb.songs){
                System.out.println(element);
            }
            for(LibraryElement element : pb.releases){
                System.out.println(element);
            }
            for(LibraryElement element : pb.artists){
                System.out.println(element);
            }
            System.out.println("Reached");
            System.out.println(pb.getArtistWork("925c7673-0e85-410f-b7e4-d9705a7aa619"));
            
        }
        catch(Exception E){

        }
    }
}
