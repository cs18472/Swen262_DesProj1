package model;

import java.util.ArrayList;
import java.util.List;

public class DBArtistSearch implements DatabaseSearcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        List<LibraryElement> Searched = new ArrayList<>();
        for(LibraryElement element : elements){
            if(((Artist) element).getName().contains(input)){
                Searched.add(element);
            }
        }

        return Searched;                
        
    }
    
}
