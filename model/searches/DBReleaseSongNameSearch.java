package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
This is  asearch pattern that provides releases based on name 
*/
public class DBReleaseSongNameSearch implements Searcher{
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        String name;
        String find = input.toLowerCase();
        // One by one move boundary of unsorted subarray
        for (LibraryElement element: elements) {
            name = element.getTitle().toLowerCase();
            if(name.contains(find)){
                result.add(element);
            }
        }
        if(result.size() == 0) return null;
        return result;
    }

}
    

