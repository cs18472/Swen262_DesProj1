package view.pages.PLSongSearchPages;

import model.searches.PLSongReleaseTitleSearch;
import view.ScannerCLI;
import view.commands.PLReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLSongReleaseTitlePage extends Page{
    private final ScannerCLI scanner;

    public PLSongReleaseTitlePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the release title that you wish to find songs for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLReleaseSearchCommand search = new PLReleaseSearchCommand();
            PLSongReleaseTitleSearch songSearch = new PLSongReleaseTitleSearch();
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
