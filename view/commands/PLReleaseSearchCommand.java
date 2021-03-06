package view.commands;

import java.util.List;

import model.Library;
import model.LibraryElement;
import model.Searcher;

public class PLReleaseSearchCommand implements PLSearchCommand {
    
    @Override
    public void execute(Library PL, String input, Searcher searcher) {
        List<LibraryElement> searchResult = (PL.search(2, input, searcher));
        if(searchResult != null){
            System.out.println("\n");
            for (LibraryElement e : (PL.search(2, input, searcher))){
                    System.out.println(e.toString());
            }
        }
        else {
            System.out.println("\nNo songs found.\n");
        }
        
    }
}
