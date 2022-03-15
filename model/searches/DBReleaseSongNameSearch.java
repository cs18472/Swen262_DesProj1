package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
This is a search pattern that provides releases based on name 
*/
public class DBReleaseSongNameSearch implements Searcher{
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String name;
        boolean found = false;
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            List<LibraryElement> songs = element.getSongs();
            for (LibraryElement song : songs) {
                name = song.getTitle();
                if(name.contains(input)){
                    found = true;
                }
            }
            if(found == true){
                 result.add(element);
            }
            found = false;
        }
        if(result.size() == 0) return null;
        return result;
    }

}
    

