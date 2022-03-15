package view.pages;

import view.ScannerCLI;


public class PLArtistExplorePage extends Page {
    private final ScannerCLI scanner;
    private final String artistGUID;

    public PLArtistExplorePage(ScannerCLI scanner, String str){
        this.scanner = scanner;
        this.artistGUID = str;
    }

    @Override
    public void menu() {
        scanner.PL.getArtistWork(artistGUID);
        System.out.println("------------------------------------------------");
        System.out.println("Please enter '1' to view the artist's songs and releases again.");
        System.out.println("If you wish to explore a release, enter the GUID of the release.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new PLArtistExplorePage(scanner, artistGUID));
            }
            else {
                scanner.setPage(new PLReleaseExplorePage(scanner, str, artistGUID));
            }
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PLBrowsePage(scanner));
    }
}