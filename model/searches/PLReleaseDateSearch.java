package model.searches;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * This search strategy will find releases based on issue date
 */
public class PLReleaseDateSearch implements Searcher{

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
