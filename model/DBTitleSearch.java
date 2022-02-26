package model;

import java.util.List;
import java.util.ArrayList;

/**
 * This concrete search strategy will find either song's or release's titles that contain a certain input.
 */
public class DBTitleSearch implements DatabaseSearcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        int n = elements.size();
        List<LibraryElement> result = new ArrayList<>();
        LibraryElement element;
        String title;
        String lowered = input.toLowerCase();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            element = elements.get(i);
            title = element.getTitle().toLowerCase();
            if(title.contains(lowered)) result.add(element);
        }
        if(result.size() == 0) return null;
        return result;
    }
    
}
