package view.commands;

import model.Searcher;

//Command Interface for the PrivateLibraryCommands
public interface SearchCommand {
    public void execute(String input, Searcher searcher);
}
