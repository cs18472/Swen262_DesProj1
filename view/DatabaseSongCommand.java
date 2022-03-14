package view;

import model.Database;
import model.DatabaseSearcher;

public class DatabaseSongCommand implements SearchCommand{

    @Override
    public void execute(String input, DatabaseSearcher searcher){
        System.out.println((Database.search(1, input, searcher)).toString());
    }
    
}
