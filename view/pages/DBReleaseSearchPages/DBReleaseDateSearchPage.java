package view.pages.DBReleaseSearchPages;

import model.searches.DBReleaseDateSearch;
import view.ScannerCLI;
import view.commands.DBReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class DBReleaseDateSearchPage extends Page{
    private final ScannerCLI scanner;

    public DBReleaseDateSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the release date that you wish to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBReleaseDateSearch releaseSearch = new DBReleaseDateSearch();
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

