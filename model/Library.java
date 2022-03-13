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
            LibraryElement element = result.get(0);
            if(!collection.contains(element)) {
                collection.add(element);
                System.out.println("Added song successfully.");
                //Artist
                String artistGuid = element.getArtistGuid();
                for(LibraryElement element2 : collection){
                    if(element2.getGuid().equals(artistGuid)){
                        return;
                    }
                }
                addArtist(artistGuid);
            }

        }
        else{
            //Search releases
            result = Database.search(2, guid, new DBGUIDSearch());
            if(result != null){
                LibraryElement element = result.get(0);
                if(!collection.contains(element)){
                    collection.add(element);
                    System.out.println("Added release successfully.");
                    //Artist
                    String artistGuid = element.getArtistGuid();
                    for(LibraryElement element2 : collection){
                        if(element2.getGuid().equals(artistGuid)){
                            return;
                        }
                    }
                    addArtist(artistGuid);
                }
            }
            else{
                System.out.println("No song or release found with that GUID that isn't in your library.");
            }
        }

    }

    public void remove(String guid){
        for(LibraryElement element : collection){
            if(element.getGuid().equals(guid)){
                collection.remove(element);
                System.out.println("Removed successfully.");
                return;
            }
        }
        System.out.println("No element with that ID within the collection.");
        return;
    }

    // Add artist to the collection.
    @Override
    public void addArtist(String guid) {
        List<LibraryElement> result = Database.search(3, guid, new DBGUIDSearch());
        if(result != null){
            collection.add(result.get(0));
        }
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
        pb.add("2bf203ad-32df-3073-a6ff-a9ce76879b61");
        pb.add("2bf203ad-32df-3073-a6ff-a9ce76879b6");
        pb.remove("477c33b8-fa6a-46bc-866b-64f8585be7fa");
        pb.remove("2bf203ad-32df-3073-a6ff-a9ce76879b6");
        pb.remove("2bf203ad-32df-3073-a6ff-a9ce76879b61");
    }
}
