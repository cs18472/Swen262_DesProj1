package view.pages.PLReleasePages;

import model.searches.PLReleaseDurMaxSearch;
import view.ScannerCLI;
import view.commands.PLReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLReleaseDurMaxSearchPage extends Page{
    private final ScannerCLI scanner;

    public PLReleaseDurMaxSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter anything to see releases sorted by maximum total song duration.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLReleaseSearchCommand search = new PLReleaseSearchCommand();
            PLReleaseDurMaxSearch releaseSearch = new PLReleaseDurMaxSearch();
            search.execute(scanner.PL, str, releaseSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PLReleaseSearchPage(scanner));
    }   
}
