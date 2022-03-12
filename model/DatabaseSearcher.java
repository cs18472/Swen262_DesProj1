package model;

import java.util.List;

/**
 * The ElementSearcher class will be the strategy for each sorting algorithm.
 */
public interface DatabaseSearcher {
    public List<LibraryElement> doSearch(List<LibraryElement> elements, String input);
}
