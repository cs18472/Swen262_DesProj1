package view.pages.PLArtistSearchPages;

import model.searches.PLArtistAlphabeticalSearch;
import view.ScannerCLI;
import view.commands.PLArtistAlphaSearchCommand;
import view.pages.LandingPage;
import view.pages.PLSearchDirectoryPage;
import view.pages.Page;

public class PLArtistGUIDPage extends Page{
    private final ScannerCLI scanner;

    public PLArtistGUIDPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the artist GUID that you wish to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLArtistAlphaSearchCommand search = new PLArtistAlphaSearchCommand();
            PLArtistAlphabeticalSearch artistSearch = new PLArtistAlphabeticalSearch();
            search.execute(scanner.PL, str, artistSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PLSearchDirectoryPage(scanner));
    }
    
}
