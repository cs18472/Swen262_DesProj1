package model;

import java.util.ArrayList;
import java.util.List;

import model.searches.DBGUIDSearch;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Composition for creating personal librarys
 */
public class Library implements LibraryElement{

    public static final int GUID_LENGTH = 36;
    public static final String LIBRARY_PATH = "model/Library.txt";

    private List<LibraryElement> collection;
    private File librarytxt = new File(LIBRARY_PATH);

    Library(){
        this.collection = new ArrayList<>();
    }

    public void add(String guid) throws IOException{
        List<LibraryElement> result;
        //Search songs
        result = Database.search(1, guid, new DBGUIDSearch());
        if(result != null){
            collection.add(result.get(0));

            FileWriter writer = new FileWriter(librarytxt);
            writer.append(guid + "\n");
            writer.close();

            System.out.println("Added song successfully.");
        }
        else{
            //Search releases
            result = Database.search(2, guid, new DBGUIDSearch());
            if(result != null){
                collection.add(result.get(0));

                FileReader reader = new FileReader(librarytxt);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String library = "";
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    library += line + "\n";
                }
                library.replaceAll(guid, "");
                bufferedReader.close();
                reader.close();

                System.out.println("Added release successfully.");
            }
            else{
                System.out.println("No song or release found with that GUID.");
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
        pb.add("2bf203ad-32df-3073-a6ff-a9ce76879b61");
        pb.add("2bf203ad-32df-3073-a6ff-a9ce76879b6");
        pb.remove("477c33b8-fa6a-46bc-866b-64f8585be7fa");
        pb.remove("2bf203ad-32df-3073-a6ff-a9ce76879b6");
        pb.remove("2bf203ad-32df-3073-a6ff-a9ce76879b61");
    }
}
