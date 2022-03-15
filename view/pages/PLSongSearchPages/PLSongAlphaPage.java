package view.pages.PLSongSearchPages;

import model.searches.PLSongAlphabeticalSearch;
import view.commands.PLSongSearchCommand;
import view.ScannerCLI;
import view.pages.LandingPage;
import view.pages.Page;

public class PLSongAlphaPage extends Page{
    private final ScannerCLI scanner;

    public PLSongAlphaPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter anything to see songs alphabetically.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLSongSearchCommand search = new PLSongSearchCommand();
            PLSongAlphabeticalSearch songSearch = new PLSongAlphabeticalSearch();
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
