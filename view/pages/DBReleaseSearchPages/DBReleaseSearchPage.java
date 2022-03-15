package view.pages.DBReleaseSearchPages;

import view.ScannerCLI;
import view.pages.DBOptions;
import view.pages.LandingPage;
import view.pages.Page;

public class DBReleaseSearchPage extends Page{

    private final ScannerCLI scanner;

    public DBReleaseSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to search for releases by title.");
        System.out.println("Enter '2' to search for releases by artist GUID.");
        System.out.println("Enter '3' to search for releases by release date.");
        System.out.println("Enter '4' to search for releases by song GUID.");
        System.out.println("Enter '5' to search for releases by song NAME.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            if((str.equals("1"))){
                scanner.setPage(new DBReleaseTitleSearchPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new DBReleaseArtistGUIDSearchPage(scanner));
            }
            else if((str).equals("3")){
                scanner.setPage(new DBReleaseDateSearchPage(scanner));
            }
            else if((str).equals("4")){
                scanner.setPage(new DBReleaseSongGUIDSearchPage(scanner));
            }
            else if((str).equals("5")){
                scanner.setPage(new DBReleaseSongNameSearchPage(scanner));
            }
            else {
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
