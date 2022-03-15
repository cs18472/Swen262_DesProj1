package view.pages.BrowsePages;

import model.searches.PLSongReleaseGUIDSearch;
import view.ScannerCLI;
import view.commands.PLReleaseSearchCommand;
import view.pages.LandingPage;
import view.pages.Page;


public class PLReleaseExplorePage extends Page {
    private final ScannerCLI scanner;
    private final String releaseGUID;
    private final String artistGUID;

    public PLReleaseExplorePage(ScannerCLI scanner, String releaseGUID, String artistGUID){
        this.scanner = scanner;
        this.releaseGUID = releaseGUID;
        this.artistGUID = artistGUID;
    }

    @Override
    public void menu() {
        this.getSongsInRelease(releaseGUID);
        System.out.println("------------------------------------------------");
        System.out.println("Please enter '1' to view the releases' songs again.");
        System.out.println("Enter 'B' to return to the artist's page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new PLReleaseExplorePage(scanner, releaseGUID, artistGUID));
            }
            else{
                error();
            }
        }
    }

    private void getSongsInRelease(String str){
        PLReleaseSearchCommand search = new PLReleaseSearchCommand();
        PLSongReleaseGUIDSearch songSearch = new PLSongReleaseGUIDSearch();
        search.execute(scanner.PL, str, songSearch);
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PLArtistExplorePage(scanner, artistGUID));
    }
}