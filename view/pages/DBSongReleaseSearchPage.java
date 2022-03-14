package view.pages;

import model.searches.DBTitleSearch;
import view.ScannerCLI;
import view.commands.DBReleaseSearchCommand;
import view.commands.DBSongSearchCommand;

public class DBSongReleaseSearchPage extends Page {
    private final ScannerCLI scanner;

    public DBSongReleaseSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }
    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the title that you would like to search for.");
        System.out.println("Press 'B' to go back to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBTitleSearch songTitleSearch = new DBTitleSearch();
            DBSongSearchCommand search = new DBSongSearchCommand();
            search.execute(str, songTitleSearch);

            DBTitleSearch releaseTitleSearch = new DBTitleSearch();
            DBReleaseSearchCommand releaseSearch = new DBReleaseSearchCommand();
            releaseSearch.execute(str, releaseTitleSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DBOptions(scanner));
    }

}
