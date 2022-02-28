package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a search strategy for finding songs greater than a given duration.
 */
public class DBSongGreaterSearch implements DatabaseSearcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        int duration;
        int given = Integer.parseInt(input);
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            duration = element.getDuration();
            if(duration >= given) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }
    
}
