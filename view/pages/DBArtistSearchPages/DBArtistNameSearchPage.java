package view.pages.DBArtistSearchPages;

import model.searches.DBArtistNameSearch;
import view.ScannerCLI;
import view.commands.DBArtistSearchCommand;
import view.pages.DBOptionsPage;
import view.pages.LandingPage;
import view.pages.Page;

public class DBArtistNameSearchPage extends Page {
    private final ScannerCLI scanner;

    public DBArtistNameSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the name of the artist you want to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBArtistSearchCommand search = new DBArtistSearchCommand();
            DBArtistNameSearch artistSearch = new DBArtistNameSearch();
            search.execute(str, artistSearch);
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
