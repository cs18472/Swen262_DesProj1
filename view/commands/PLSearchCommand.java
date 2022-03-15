package view.commands;

import model.Library;
import model.Searcher;

public interface PLSearchCommand {
    public void execute(Library PL,String input, Searcher searcher);
}
