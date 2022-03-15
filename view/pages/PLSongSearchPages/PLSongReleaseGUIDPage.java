package view.pages.PLSongSearchPages;

import model.searches.PLSongReleaseGUIDSearch;
import view.ScannerCLI;
import view.commands.PLReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLSongReleaseGUIDPage extends Page{
    private final ScannerCLI scanner;

    public PLSongReleaseGUIDPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the release guid that you wish to find songs for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLReleaseSearchCommand search = new PLReleaseSearchCommand();
            PLSongReleaseGUIDSearch songSearch = new PLSongReleaseGUIDSearch();
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
