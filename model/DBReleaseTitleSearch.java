package model;

import java.util.List;

public class DBReleaseTitleSearch implements DatabaseSearcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        int n = elements.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            
        }
        return null;
    }
    
}
