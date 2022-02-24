package model;

import java.util.List;

/**
 * The ElementSearcher class will be the strategy for each searching algorithm.
 */
public interface DatabaseSorter {
    public void doSearch(List<LibraryElement> elements);
}
