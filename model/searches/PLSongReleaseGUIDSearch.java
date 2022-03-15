package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
This is a search pattern that provides songs based on release GUID
*/
public class PLSongReleaseGUIDSearch implements Searcher{
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String guid;
        // One by one move boundary of unsorted subarray
        for (LibraryElement element : elements) {
            guid = element.getGuid();
            if(guid.contains(input)){
                List<LibraryElement> songs = element.getSongs();
                for (LibraryElement song : songs) {
                    result.add(song);
                }
            }
        }
        if(result.size() == 0) return null;
        return result;
    } 
}
