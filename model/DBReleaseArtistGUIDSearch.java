package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This search strategy will find all releases with a given guid.
 */
public class DBReleaseArtistGUIDSearch implements DatabaseSearcher{

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