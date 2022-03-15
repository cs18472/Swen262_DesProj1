package view.pages.PLSongSearchPages;

import view.ScannerCLI;
import view.pages.LandingPage;
import view.pages.PLSearchDirectoryPage;
import view.pages.Page;

public class PLSongSearchPage extends Page{
    private final ScannerCLI scanner;

    public PLSongSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Press '1' to list all songs in your library alphabetically.");
        System.out.println("Press '2' to search for a song by its title.");
        System.out.println("Press '3' to search for a song by the artist's name.");
        System.out.println("Press '4' to search for a song by the artist's GUID.");
        System.out.println("Press '5' to search for a song by the release's title.");
        System.out.println("Press '6' to search for a song by the release's GUID.");
        System.out.println("Press '7' to search for a song by the duration less than.");
        System.out.println("Press '8' to search for a song by the duration greater than.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){

            if((str).equals("1")){
                scanner.setPage(new PLSongAlphaPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new PLSongTitlePage(scanner));
            }
            else if((str).equals("3")){
                scanner.setPage(new PLSongArtistNamePage(scanner));
            }
            else if((str).equals("4")){
                scanner.setPage(new PLSongArtistGUIDPage(scanner));
            }
            else if((str).equals("5")){
                scanner.setPage(new PLSongReleaseTitlePage(scanner));
            }
            else if((str).equals("6")){
                scanner.setPage(new PLSongReleaseGUIDPage(scanner));
            }
            else if((str).equals("7")){
                scanner.setPage(new PLSongDurationLessPage(scanner));
            }
            else if((str).equals("8")){
                scanner.setPage(new PLSongDurationGreaterPage(scanner));
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
        scanner.setPage(new PLSearchDirectoryPage(scanner));
    }
    
}
