package model;

import java.util.List;

public class Release {
    private String guid;
    private String title;
    private String artistGuid;
    private String artist;
    private String issueDate;
    private String medium;
    private List<Song> songs;
    private int rating;

    public Release (String guid,String title, String artistGuid, String artist,String issueDate, String medium, List<Song> songs) {
        this.title = title;
        this.artistGuid = artistGuid;
        this.artist = artist;
        this.issueDate = issueDate;
        this.medium = medium;
        this.songs = songs;
        
        int totalNum = 0;
        int totalRating = 0;
        for(Song s : songs) {
            totalNum++;
            totalRating += s.getRating();
        }

        if(totalNum == 0 || totalRating == 0) this.rating = 0;
        else this.rating = totalRating/totalNum;

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
