package view.pages.PLArtistSearchPages;

import model.searches.PLArtistTypeSearch;
import view.ScannerCLI;
import view.commands.PLArtistSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLArtistTypePage extends Page{
    private final ScannerCLI scanner;

    public PLArtistTypePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the genre or type of artist that you wish to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLArtistSearchCommand search = new PLArtistSearchCommand();
            PLArtistTypeSearch artistSearch = new PLArtistTypeSearch();
            search.execute(scanner.PL, str, artistSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PLArtistSearchPage(scanner));
    }
    
}
