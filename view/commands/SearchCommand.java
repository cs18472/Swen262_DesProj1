package view.commands;

import model.Searcher;

//Command Interface for the database search commands
public interface SearchCommand {
    public void execute(String input, Searcher searcher);
}
