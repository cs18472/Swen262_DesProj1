package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This is a search strategy for finding songs less than a given duration.
 */
public class DBSongLessSearch implements Searcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        int duration;
        int given = Integer.parseInt(input);
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            duration = element.getDuration();
            if(duration <= given) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }
    
}
