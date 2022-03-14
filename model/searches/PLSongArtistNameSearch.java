package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This is a search strategy for finding songs by artists names.
 */
public class PLSongArtistNameSearch implements Searcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String name;
        String lowered = input.toLowerCase();
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            name = element.getArtist().toLowerCase();
            if(name.contains(lowered)) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }  
}
