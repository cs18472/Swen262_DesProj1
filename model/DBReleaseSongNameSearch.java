package model;

import java.util.ArrayList;
import java.util.List;

/**
 * DOESN'T WORK, PRINTS ALL RELEASES FOR SOME REASEON
 */
public class DBReleaseSongNameSearch implements DatabaseSearcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String name;
        String find = input.toLowerCase();
        boolean found = false;
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            List<LibraryElement> songs = element.getSongs();
            for (LibraryElement song : songs) {
                name = song.getTitle().toLowerCase();
                if(name.contains(find)) found = true;
            }
            if(found == true) result.add(element);
            found = false;
        }
        if(result.size() == 0) return null;
        return result;
    }
    
}
