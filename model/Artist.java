package model;

import java.util.List;

public class Artist implements LibraryElement{
    private List<LibraryElement> songs;
    private List<LibraryElement> releases;
    private String name;
    private String type;
    private String guid;

    public Artist(List<LibraryElement> songs, List<LibraryElement> releases, String guid, String name, String type) {
        this.songs = songs;
        this.releases = releases;
        this.guid = guid;
        this.name = name;
        this.type = type;
    }

    @Override
    public List<LibraryElement> search(int type, String input, Searcher searcher) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "Artist: " + name + " GUID: " + guid;
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
    public String getArtistGuid() {
        return null;
    }
    @Override
    public void addName(String name) {}
    @Override
    public void addArtist(String name) {}

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getArtist() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDuration() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getIssueDate() {
        // TODO Auto-generated method stub
        return null;
    }
}
