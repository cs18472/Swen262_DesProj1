package model;

import java.util.List;

/**
 * Composition for creating personal librarys
 */
public class Library implements LibraryElement{
    
    private List<LibraryElement> collection;

    public void add(LibraryElement element){

    }

    public void remove(LibraryElement element){
        
    }

    @Override
    public List<LibraryElement> search() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getRating() {
        double rating = 0.0;
        for(LibraryElement e: collection){
            rating += e.getRating();
        }
        return (rating/collection.size());
    }
    
    @Override
    public String getGuid() {
        return null;
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
}
