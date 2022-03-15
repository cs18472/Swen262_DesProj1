package view.pages.PLArtistSearchPages;

import model.searches.PLArtistAlphabeticalSearch;
import view.ScannerCLI;
import view.commands.PLArtistSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLArtistAlphaPage extends Page{
    private final ScannerCLI scanner;

    public PLArtistAlphaPage(ScannerCLI scanner){
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
        scanner.setPage(new PLArtistSearchPage(scanner));
    }
    
}
