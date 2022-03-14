package view.pages;

import view.ScannerCLI;

public class PLRemovePage extends Page {
    private final ScannerCLI scanner;

    PLRemovePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to remove a song.");
        System.out.println("Enter '2' to rempve an artist.");
        System.out.println("Enter '3' to remove a release.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new DatabaseSongSearchPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new DatabaseArtistSearchPage(scanner));
            }
            else if ((str).equals("3")){
                scanner.setPage(new DatabaseReleaseSearchPage(scanner));
            }        
            else{
                error();
            }
        }
    }

    @Override
    public void back() {
        scanner.setPage(new PLSearchDirectory(scanner));
    }
}