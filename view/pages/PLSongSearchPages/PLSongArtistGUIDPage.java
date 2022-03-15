package view.pages.PLSongSearchPages;

import model.searches.PLSongArtistGUIDSearch;
import view.ScannerCLI;
import view.commands.PLSongSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLSongArtistGUIDPage extends Page{
    private final ScannerCLI scanner;

    public PLSongArtistGUIDPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the song artist's GUID that you wish to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLSongSearchCommand search = new PLSongSearchCommand();
            PLSongArtistGUIDSearch songSearch = new PLSongArtistGUIDSearch();
            search.execute(scanner.PL, str, songSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PLSongSearchPage(scanner));
    }
}
