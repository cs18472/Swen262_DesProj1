package view.pages;

import model.searches.DBSongGreaterSearch;
import view.ScannerCLI;
import view.commands.DBSongSearchCommand;

public class DBSongGLSearchPage extends Page{
    private final ScannerCLI scanner;

    DBSongGLSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the length that you wish to find songs longer than.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBSongGreaterSearch titleSearch = new DBSongGreaterSearch();
            DBSongSearchCommand search = new DBSongSearchCommand();
            search.execute(str, titleSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DBSongSearchPage(scanner));
    }
}