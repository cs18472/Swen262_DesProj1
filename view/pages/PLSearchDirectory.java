package view.pages;

import view.ScannerCLI;

public class PLSearchDirectory extends Page {
    private final ScannerCLI scanner;

    PLSearchDirectory(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to search for a song.");
        System.out.println("Enter '2' to search for an artist.");
        System.out.println("Enter '3' to search for a release.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new PLSongSearchPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new PLArtistSearchPage(scanner));
            }
            else if ((str).equals("3")){
                scanner.setPage(new PLReleaseSearchPage(scanner));
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
        scanner.setPage(new LandingPage(scanner));
    }
}
