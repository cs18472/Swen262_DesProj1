package view.commands;

import java.util.List;

import model.Database;
import model.DatabaseSearcher;
import model.LibraryElement;

public class DBSongSearchCommand implements SearchCommand {

    @Override
    public void execute(String input, DatabaseSearcher searcher){
        List<LibraryElement> searchResult = (Database.search(1, input, searcher));
        if(searchResult != null){
            System.out.println("\n");
            for (LibraryElement e : (Database.search(1, input, searcher))){
                    System.out.println(e.toString());
            }
        }
        else {
            System.out.println("\nNo songs found.\n");
        }
    }
}
