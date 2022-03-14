package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This is a search strategy that finds releases based on song guid.
 */
public class PLReleaseSongGUIDSearch implements Searcher{
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String guid;
        boolean found = false;
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            List<LibraryElement> songs = element.getSongs();
            for (LibraryElement song : songs) {
                guid = song.getGuid();
                if(guid.contains(input)){
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
