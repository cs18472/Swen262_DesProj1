package view.pages.DBSongSearchPages;

import view.ScannerCLI;
import view.pages.DBOptionsPage;
import view.pages.LandingPage;
import view.pages.Page;

public class DBSongSearchPage extends Page {
    private final ScannerCLI scanner;

    public DBSongSearchPage(ScannerCLI scanner){
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

                scanner.setPage(new DBSongTitleSearchPage(scanner));

            }
            else if((str).equals("2")){

                scanner.setPage(new DBSongArtistSearchPage(scanner));
            }
            else if((str).equals("3")){

                scanner.setPage(new DBSongGUIDSearchPage(scanner));
            }
            else if((str).equals("4")){

                scanner.setPage(new DBSongGLSearchPage(scanner));
            }
            else if((str).equals("5")){

                scanner.setPage(new DBSongLLSearchPage(scanner));
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
        scanner.setPage(new DBOptionsPage(scanner));
    }
}
