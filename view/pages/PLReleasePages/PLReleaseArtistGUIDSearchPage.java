package view.pages.PLReleasePages;

import model.searches.PLReleaseArtistGUIDSearch;
import view.ScannerCLI;
import view.commands.PLReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLReleaseArtistGUIDSearchPage extends Page{
    private final ScannerCLI scanner;

    public PLReleaseArtistGUIDSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the GUID of the artist whos releases you are searching for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLReleaseSearchCommand search = new PLReleaseSearchCommand();
            PLReleaseArtistGUIDSearch artistSearch = new PLReleaseArtistGUIDSearch();
            search.execute(scanner.PL, str, artistSearch);
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

