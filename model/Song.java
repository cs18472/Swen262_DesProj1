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

    public Song(String title, String guid, String artistGuid, String artist, int duration) {
        this.title = title;
        this.guid = guid;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.duration = duration;
    }

    @Override
    public List<LibraryElement> search(int type, String input, Searcher searcher) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "Song: " + title + " GUID: " + guid;
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
    @Override
    public String getTitle() {
        return title;
    }

    public void addName(String s) {
        this.artist = s;
    }
    @Override
    public void addArtist(String name) {}

    @Override
    public List<LibraryElement> getSongs() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getIssueDate() {
        // TODO Auto-generated method stub
        return null;
    }
}