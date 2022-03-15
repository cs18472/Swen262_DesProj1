package model.searches;

import java.util.List;
import model.*;

/**
 * This is a search strategy that sorts the releases by max total song duration.
 */
public class PLReleaseDurMaxSearch implements Searcher{

    @Override
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
        int n = elements.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++){
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                int compare =  elements.get(j).getDuration() - elements.get(min_idx).getDuration();
                if (compare > 0){
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first element
            LibraryElement temp = elements.get(min_idx);
            elements.set(min_idx, elements.get(i));
            elements.set(i, temp);
        }
        return elements;
    }
}
