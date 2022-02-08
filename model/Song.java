package model;

public class Song {
    private String title;
    private int guid;
    private int artistGuid;
    private String artist;
    private int duration;
    private int rating;

    public Song(String title, int guid, int artistGuid, String artist, int duration) {
        this.title = title;
        this.guid = guid;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.duration = duration;
        this.rating = 0;
    }

    public String getArtist() {
        return artist;
    }
    public int getArtistGuid() {
        return artistGuid;
    }
    public int getDuration() {
        return duration;
    }
    public int getGuid() {
        return guid;
    }
    public int getRating() {
        return rating;
    }
    public String getTitle() {
        return title;
    }

}