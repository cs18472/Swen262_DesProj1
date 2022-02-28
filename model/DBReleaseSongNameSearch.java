package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

/**
 * DOESN'T WORK, PRINTS ALL RELEASES FOR SOME REASEON
 */
public class DBReleaseSongNameSearch implements DatabaseSearcher{
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
            // List<LibraryElement> songs = element.getSongs();
            // for (LibraryElement song : songs) {
            //     name = song.getTitle().toLowerCase();
            //     if(name.contains(find)){
            //         found = true;
            //         break;
            //     } 
            // }
            // if(found == true){
            //     result.add(element);
            // } 
        }
        if(result.size() == 0) return null;
        return result;
    }

    // @Override
    // public List<LibraryElement> doSearch(List<LibraryElement> elements, String input) {
    //        // Set<LibraryElement> result = new HashSet<LibraryElement>();
    //        List<LibraryElement> result = new ArrayList<>();
    //         String name;
    //         String find = input.toLowerCase();
    //         boolean found = false;
    //         // One by one move boundary of unsorted subarray
    //         for (LibraryElement element: elements) {
    //             List<LibraryElement> songs = element.getSongs();
    //             for (LibraryElement song : songs) {
    //                 name = song.getTitle().toLowerCase();
    //                 if(name.contains(find)){
    //                     result.add(element);
    //                 }
    //         }
    //     }
    //         if(result.size() == 0) return null;
    //         return result;
    // }
}
    

