package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This search strategy will find all releases with a given guid.
 */
public class PLReleaseArtistGUIDSearch implements Searcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String title;
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            title = element.getArtistGuid();
            if(title.contains(input)) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }  
}
