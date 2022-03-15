package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
This is a search pattern that provides songs based on release title
*/
public class PLSongReleaseTitleSearch implements Searcher{
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String title;
        // One by one move boundary of unsorted subarray
        for (LibraryElement element : elements) {
            title = element.getTitle();
            if(title.contains(input)){
                List<LibraryElement> songs = element.getSongs();
                for (LibraryElement song : songs) {
                    result.add(song);
                }
            }
        }
        if(result.size() == 0) return null;
        return result;
    }   
}
