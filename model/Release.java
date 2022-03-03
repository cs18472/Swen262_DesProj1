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
    private int rating;

    public Release (String guid, String title, String artistGuid, String artist, String issueDate, String medium, List<LibraryElement> songs) {
        this.guid = guid;
        this.title = title;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.issueDate = issueDate;
        this.medium = medium;
        this.songs = songs;
        
        int totalNum = 0;
        int totalRating = 0;
        for(LibraryElement s : songs) {
            totalNum++;
            totalRating += s.getRating();
        }

        if(totalNum == 0 || totalRating == 0) this.rating = 0;
        else this.rating = totalRating/totalNum;
    }

    @Override
    public List<LibraryElement> search() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return title + " " + guid + " Artist: " + artist;
    }

    public void addArtist(String name) {
        this.artist = name;
    }

    public String getGuid() {
        return guid;
    }
    public String getMedium() {
        return medium;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public String getArtist() {
        return artist;
    }
    public String getArtistGuid() {
        return artistGuid;
    }
    public double getRating() {
        return rating;
    }
    public List<LibraryElement> getSongs() {
        return songs;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public void addName(String name) {}

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDuration() {
        // TODO Auto-generated method stub
        return 0;
    }
}
