package view.pages.DBSongSearchPages;

import model.searches.DBSongLessSearch;
import view.ScannerCLI;
import view.commands.DBSongSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class DBSongLLSearchPage extends Page{
    private final ScannerCLI scanner;

    DBSongLLSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the length that you wish to find songs shorter than.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBSongLessSearch titleSearch = new DBSongLessSearch();
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
