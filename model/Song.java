package model;

public class Song {
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
    public int getRating() {
        return rating;
    }
    public String getTitle() {
        return title;
    }

    protected void addName(String s) {
        this.artist = s;
    }
}