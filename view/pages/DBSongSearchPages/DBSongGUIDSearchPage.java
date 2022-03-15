package view.pages.DBSongSearchPages;

import model.searches.DBGUIDSearch;
import view.ScannerCLI;
import view.commands.DBSongSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class DBSongGUIDSearchPage extends Page{
    private final ScannerCLI scanner;

    DBSongGUIDSearchPage(ScannerCLI scanner){
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
            DBGUIDSearch GUIDSearch = new DBGUIDSearch();
            DBSongSearchCommand search = new DBSongSearchCommand();
            search.execute(str, GUIDSearch);
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