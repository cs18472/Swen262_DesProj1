package model;

import java.util.List;

/**
 * The DBArtistNameSort is a ConcreteStrategy to sort the names 
 */
public class DBSongTitleSort implements DatabaseSorter{

    @Override
    public void doSort(List<LibraryElement> elements) {
        int n = elements.size();
  
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                int compare = elements.get(j).getTitle().compareTo(elements.get(min_idx).getTitle());
                if (compare < 0){
                    min_idx = j;
                }
            }
  
            // Swap the found minimum element with the first element
            LibraryElement temp = elements.get(min_idx);
            elements.set(min_idx, elements.get(i));
            elements.set(i, temp);
        }  
    }
}
