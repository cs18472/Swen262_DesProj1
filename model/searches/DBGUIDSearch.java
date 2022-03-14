package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This is a search strategy for finding elements by GUID.
 */
public class DBGUIDSearch implements Searcher{
    
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String guid;
        for (LibraryElement element: elements) {
            guid = element.getGuid();
            if(guid.equals(input)){
                result.add(element);
                return result;
            }
            
        }
        return null;
    }
}
