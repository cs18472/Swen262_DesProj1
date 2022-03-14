package model.searches;

import java.util.List;
import java.util.ArrayList;
import model.*;

/**
 * This is a search strategy that finds songs based on artist guid.
 */
public class PLSongArtistGUIDSearch implements Searcher{
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String artistGuid;
        for (LibraryElement element: elements) {
            artistGuid = element.getArtistGuid();
            if(artistGuid.equals(input)){
                result.add(element);
            }
        }
        if(result.size() == 0) return null;
        return result;
    }
}
