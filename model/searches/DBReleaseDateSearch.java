package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class DBReleaseDateSearch implements Searcher{

/**
 * This search strategy will find releases based on issue date
 */
    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> result = new ArrayList<>();
        for(LibraryElement element : elements){
            if(element.getIssueDate().contains(input)){
                result.add(element);
            }
        }
        if(result.size() == 0){
            return null;
        }
        return result;
    }
    
}
