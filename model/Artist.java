package model;

import java.util.List;

public class Artist implements LibraryElement{
    private List<LibraryElement> songs;
    private List<LibraryElement> releases;
    private String name;
    private String type;
    private String guid;
    private int totDuration;

    public Artist(List<LibraryElement> songs, List<LibraryElement> releases, String guid, String name, String type) {
        this.songs = songs;
        this.releases = releases;
        this.guid = guid;
        this.name = name;
        this.type = type;

        for(LibraryElement song : songs){
            totDuration = song.getDuration() + totDuration;
        }
    }

    @Override
    public List<LibraryElement> search(int type, String input, Searcher searcher) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "Artist: " + name + " GUID: " + guid + "Type: " + type + "Total Duration: " + totDuration;
    }
    public String getGuid() {
        return guid;
    }
    public String getName() {
        return name;
    }
    public List<LibraryElement> getReleases() {
        return releases;
    }
    public List<LibraryElement> getSongs() {
        return songs;
    }
    public String getType() {
        return type;
    } 
    @Override
    public int getDuration() {
        return totDuration;
    }

    //Unused Methods
    @Override
    public String getArtistGuid() {return null;}
    @Override
    public void addName(String name) {}
    @Override
    public void addArtist(String name) {}
    @Override
    public String getTitle() {return null;}
    @Override
    public String getArtist() {return null;}
    @Override
    public String getIssueDate() {return null;}
    @Override
    public List<LibraryElement> getArtistWork(String guid) {return null;}
    @Override
    public List<LibraryElement> getArtists() {return null;}
}
