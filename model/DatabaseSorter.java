package model;

import java.util.List;

/**
 * The ElementSearcher class will be the strategy for each sorting algorithm.
 */
public interface DatabaseSorter {
    public void doSort(List<LibraryElement> elements);
}
