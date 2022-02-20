package model;

import java.util.List;

/**
 * Component of the Composition pattern.
  */
public interface LibraryElement {
    public List<LibraryElement> search();
    public double getRating();
    public String getGuid();
    public String getArtistGuid();
    public void addName(String name);
    public void addArtist(String name);
}
