package model;

import java.util.List;
import java.util.ArrayList;

/**
 * This concrete search strategy will find either song's or release's titles that contain a certain input.
 */
public class DBTitleSearch implements DatabaseSearcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String title;
        String lowered = input.toLowerCase();
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {;
            title = element.getTitle().toLowerCase();
            if(title.contains(lowered)) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }
    
}
