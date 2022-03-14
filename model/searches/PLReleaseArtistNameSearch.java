package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This search strategy will find the releases with the artists name.
 */
public class PLReleaseArtistNameSearch implements Searcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String title;
        String lowered = input.toLowerCase();
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            title = element.getArtist().toLowerCase();
            if(title.contains(lowered)) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }   
}
