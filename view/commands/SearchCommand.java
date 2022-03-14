package view.commands;

import model.DatabaseSearcher;

//Command Interface for the PrivateLibraryCommands
public interface SearchCommand {
    public void execute(String input, DatabaseSearcher searcher);
}
