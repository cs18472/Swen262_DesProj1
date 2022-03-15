package view.pages.PLSongSearchPages;

import model.searches.PLTitleSearch;
import view.ScannerCLI;
import view.commands.PLSongSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;

public class PLSongTitlePage extends Page{
    private final ScannerCLI scanner;

    public PLSongTitlePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the song's title that you wish to search for.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            PLSongSearchCommand search = new PLSongSearchCommand();
            PLTitleSearch songSearch = new PLTitleSearch();
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
