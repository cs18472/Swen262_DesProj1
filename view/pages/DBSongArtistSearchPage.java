package view.pages;

import model.searches.DBSongArtistNameSearch;
import view.ScannerCLI;
import view.commands.DBSongSearchCommand;

public class DBSongArtistSearchPage extends Page{
    private final ScannerCLI scanner;

    DBSongArtistSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the artist name.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            DBSongArtistNameSearch artistSearch = new DBSongArtistNameSearch();
            DBSongSearchCommand search = new DBSongSearchCommand();
            search.execute(str, artistSearch);
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DBSongSearchPage(scanner));
    }
}

