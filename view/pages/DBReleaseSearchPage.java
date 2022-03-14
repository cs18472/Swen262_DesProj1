package view.pages;

import view.ScannerCLI;

public class DBReleaseSearchPage extends Page{

    private final ScannerCLI scanner;

    DBReleaseSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to search for releases by artist GUID.");
        System.out.println("Enter '2' to search for releases by release date.");
        System.out.println("Enter '3' to search for releases by song GUID.");
        System.out.println("Enter '4' to search for releases by song NAME.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
           
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DBOptions(scanner));
    }
}
