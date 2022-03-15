package view.pages.DBArtistSearchPages;

import model.searches.DBGUIDSearch;
import view.ScannerCLI;
import view.commands.DBArtistSearchCommand;
import view.pages.DBOptionsPage;
import view.pages.LandingPage;
import view.pages.Page;

public class DBArtistGUIDSearchPage extends Page {
    private final ScannerCLI scanner;

    DBArtistGUIDSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the GUID of the artist you want to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBArtistSearchCommand search = new DBArtistSearchCommand();
            DBGUIDSearch artistSearch = new DBGUIDSearch();
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
