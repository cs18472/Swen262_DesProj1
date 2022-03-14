package view.pages;

import view.ScannerCLI;

public class DatabaseReleaseSearchPage extends Page{

    private final ScannerCLI scanner;

    DatabaseReleaseSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }


    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the title of the release.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            //do the search
        }
    }

    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new DatabaseOptions(scanner));
    }
}