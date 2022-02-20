package model;

import java.util.List;

public class Artist implements LibraryElement{
    private List<Song> songs;
    private List<Release> releases;
    private String name;
    private String type;
    private int rating;

    public Artist(List<Song> songs, List<Release> releases, String name, String type) {
        this.songs = songs;
        this.releases = releases;
        this.name = name;
        this.type = type;
        this.rating = 0;
    }
    public String getName() {
        return name;
    }
    public int getRating() {
        return rating;
    }
    public List<Release> getReleases() {
        return releases;
    }
    public List<Song> getSongs() {
        return songs;
    }
    public String getType() {
        return type;
    }
}
