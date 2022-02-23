package model;

import java.util.List;

public class Artist implements LibraryElement{
    private List<LibraryElement> songs;
    private List<LibraryElement> releases;
    private String name;
    private String type;
    private int rating;
    private String guid;

    public Artist(List<LibraryElement> songs, List<LibraryElement> releases, String guid, String name, String type) {
        this.songs = songs;
        this.releases = releases;
        this.guid = guid;
        this.name = name;
        this.type = type;
        this.rating = 0;
    }

    @Override
    public List<LibraryElement> search() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return name + " " + guid;
    }

    public String getGuid() {
        return guid;
    }
    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
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
    public String getArtistGuid() {
        return guid;
    }
    @Override
    public void addName(String name) {}
    @Override
    public void addArtist(String name) {}
}
