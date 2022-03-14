package view.commands;

import java.util.List;

import model.Database;
import model.Searcher;
import model.LibraryElement;

public class DBArtistSearchCommand implements SearchCommand {

    @Override
    public void execute(String input, Searcher searcher) {
        List<LibraryElement> searchResult = (Database.search(3, input, searcher));
        if(searchResult != null){
            System.out.println("\n");
            for (LibraryElement e : (Database.search(3, input, searcher))){
                    System.out.println(e.toString());
            }
        }
        else {
            System.out.println("\nNo songs found.\n");
        }
        
    }
    
}
