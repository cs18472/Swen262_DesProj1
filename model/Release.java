package model;

import java.util.List;

public class Release {
    private String title;
    private String artistGuid;
    private String artist;
    private List<Song> songs;
    private int rating;

    public Release (String title, String artistGuid, String artist, List<Song> songs) {
        this.title = title;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.songs = songs;
        
        int totalNum = 0;
        int totalRating = 0;
        for(Song s : songs) {
            totalNum++;
            totalRating += s.getRating();
        }

        this.rating = totalNum/totalRating;

    }
    public String getArtist() {
        return artist;
    }
    public String getArtistGuid() {
        return artistGuid;
    }
    public int getRating() {
        return rating;
    }
    public List<Song> getSongs() {
        return songs;
    }
    public String getTitle() {
        return title;
    }
}
