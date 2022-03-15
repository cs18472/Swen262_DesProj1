package view.pages.PLReleasePages;

import model.searches.PLArtistAlphabeticalSearch;
import view.ScannerCLI;
import view.commands.PLArtistSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLReleaseAlphaSearchPage extends Page{
    private final ScannerCLI scanner;

    public PLReleaseAlphaSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter anything to see artists alphabetically.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLArtistSearchCommand search = new PLArtistSearchCommand();
            PLArtistAlphabeticalSearch releaseSearch = new PLArtistAlphabeticalSearch();
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

