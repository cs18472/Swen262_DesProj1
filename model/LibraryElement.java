package model;

import java.util.List;

/**
 * Component of the Composition pattern.
  */
public interface LibraryElement {
    public List<LibraryElement> search(int type, String input, Searcher searcher);
    public String getGuid();
    public String getArtistGuid();
    public String getIssueDate();
    public String getTitle();
    public void addName(String name);
    public void addArtist(String name);
    public List<LibraryElement> getSongs();
    public String getArtist();
    public String getName();
    public int getDuration();
}
