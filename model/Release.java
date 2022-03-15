package model;

import java.util.List;

/**
 * Composition of an artists songs.
 */
public class Release implements LibraryElement{
    private String guid;
    private String title;
    private String artistGuid;
    private String artist;
    private String issueDate;
    private String medium;
    private List<LibraryElement> songs;

    public Release (String guid, String title, String artistGuid, String artist, String issueDate, String medium, List<LibraryElement> songs) {
        this.guid = guid;
        this.title = title;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.issueDate = issueDate;
        this.medium = medium;
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Release: " + title + " GUID: " + guid + " Artist: " + artist;
    }

    public void addArtist(String name) {
        this.artist = name;
    }

    @Override
    public String getGuid() {
        return guid;
    }
    public String getMedium() {
        return medium;
    }
    public String getIssueDate() {
        return issueDate;
    }
    @Override
    public String getArtist() {
        return artist;
    }
    @Override
    public String getArtistGuid() {
        return artistGuid;
    }
    @Override
    public List<LibraryElement> getSongs() {
        return songs;
    }
    @Override
    public String getTitle() {
        return title;
    }

    //Unused Methods
    @Override
    public void addName(String name) {}
    @Override
    public String getName() {return null;}
    @Override
    public int getDuration() {return 0;}
    @Override
    public String getType() {return null;}
    @Override
    public List<LibraryElement> search(int type, String input, Searcher searcher) {return null;}
    @Override
    public List<LibraryElement> getArtistWork(String guid) {return null;}
    @Override
    public List<LibraryElement> getArtists() {return null;}
}
