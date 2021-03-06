package view.pages.DBSongSearchPages;

import model.searches.DBTitleSearch;
import view.ScannerCLI;
import view.commands.DBSongSearchCommand;
import view.pages.DBOptionsPage;
import view.pages.LandingPage;
import view.pages.Page;

public class DBSongTitleSearchPage extends Page{
    private final ScannerCLI scanner;

    DBSongTitleSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the song title.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBTitleSearch titleSearch = new DBTitleSearch();
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
        scanner.setPage(new DBOptionsPage(scanner));
    }
}
