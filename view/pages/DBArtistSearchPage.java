package view.pages;

import view.ScannerCLI;


public class DBArtistSearchPage extends Page {
    private final ScannerCLI scanner;

    DBArtistSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please press '1' to search by name.");
        System.out.println("Please press '2' to search by GUID.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){

            if((str).equals("1")){

                scanner.setPage(new DBArtistNameSearchPage(scanner));
            }
            else if((str).equals("2")){

                scanner.setPage(new DBArtistGUIDSearchPage(scanner));
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
        scanner.setPage(new DBOptions(scanner));
    }
}
