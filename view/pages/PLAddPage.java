package view.pages;

import view.ScannerCLI;

public class PLAddPage extends Page {
    private final ScannerCLI scanner;

    PLAddPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to add a song.");
        System.out.println("Enter '2' to add an artist.");
        System.out.println("Enter '3' to add a release.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new DBSongSearchPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new DBArtistNameSearchPage(scanner));
            }
            else if ((str).equals("3")){
                scanner.setPage(new DBReleaseSearchPage(scanner));
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
        scanner.setPage(new PLSearchDirectory(scanner));
    }
}
