package view.pages.DBReleaseSearchPages;

import model.searches.DBTitleSearch;
import view.ScannerCLI;
import view.commands.DBReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class DBReleaseTitleSearchPage extends Page{
    private final ScannerCLI scanner;

    DBReleaseTitleSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the release title that you wish to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBTitleSearch releaseSearch = new DBTitleSearch();
            DBReleaseSearchCommand search = new DBReleaseSearchCommand();
            search.execute(str, releaseSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DBReleaseSearchPage(scanner));
    }
}

