package model;

import java.util.List;

/**
 * Leaf that represents a song.
 */
public class Song implements LibraryElement{
    private String title;
    private String guid;
    private String artistGuid;
    private String artist;
    private int duration;
    private int rating;

    public Song(String title, String guid, String artistGuid, String artist, int duration) {
        this.title = title;
        this.guid = guid;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.duration = duration;
        this.rating = 0;
    }

    @Override
    public List<LibraryElement> search() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return title + " " + guid;
    }

    public String getArtist() {
        return artist;
    }
    public String getArtistGuid() {
        return artistGuid;
    }
    public int getDuration() {
        return duration;
    }
    public String getGuid() {
        return guid;
    }
    public double getRating() {
        return rating;
    }
    @Override
    public String getTitle() {
        return title;
    }

    public void addName(String s) {
        this.artist = s;
    }
    @Override
    public void addArtist(String name) {}
}