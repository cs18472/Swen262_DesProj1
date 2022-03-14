package view.pages;

import model.searches.DBArtistNameSearch;
import model.searches.DBTitleSearch;
import view.ScannerCLI;
import view.commands.DBSongSearchCommand;

public class DBSongSearchPage extends Page {
    private final ScannerCLI scanner;

    DBSongSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please press '1' to search by Title.");
        System.out.println("Please press '2' to search by Artist.");
        System.out.println("Please press '3' to search by GUID.");
        System.out.println("Please press '4' to search by length greater than input.");
        System.err.println("Please press '5' to search by length less than input.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){

            if((str).equals("1")){

                DBTitleSearch titleSearch = new DBTitleSearch();
                DBSongSearchCommand search = new DBSongSearchCommand();
                search.execute(str, titleSearch);
            }
            else if((str).equals("2")){

                DBArtistNameSearch artistSearch = new DBArtistNameSearch();
                DBSongSearchCommand search = new DBSongSearchCommand();
                search.execute(str, artistSearch);
            }
            else if((str).equals("3")){

                DBTitleSearch titleSearch = new DBTitleSearch();
                DBSongSearchCommand search = new DBSongSearchCommand();
                search.execute(str, titleSearch);
            }
            else{
                error();
            }
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DBOptions(scanner));
    }
}