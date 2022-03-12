package model;

import java.util.ArrayList;
import java.util.List;

import model.searches.DBGUIDSearch;


/**
 * Composition for creating personal librarys
 */
public class Library implements LibraryElement{
    
    private List<LibraryElement> collection;

    Library(){
        this.collection = new ArrayList<>();
    }

    public void add(String guid){
        List<LibraryElement> result;
        //Search songs
        result = Database.search(1, guid, new DBGUIDSearch());
        if(result != null){
            collection.add(result.get(0));
        }
        else{
            result = Database.search(2, guid, new DBGUIDSearch());
            if(result != null){
                collection.add(result.get(0));
            }
            else{
                System.out.println("No song or release found with that GUID.");
            }
        }

    }

    public void remove(String guid){
        
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

    @Override
    public List<LibraryElement> getSongs() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getArtist() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
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

    public static void main(String[] args){
        Library pb = new Library();
        try{
            Database.main(args);
        }
        catch(Exception E){

        }
        pb.add("477c33b8-fa6a-46bc-866b-64f8585be7fa");
    }
}
