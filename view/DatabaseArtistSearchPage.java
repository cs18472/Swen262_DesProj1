package view;

public class DatabaseArtistSearchPage extends Page {
    private final ScannerCLI scanner;

    DatabaseArtistSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Please enter the name of the artist you want to search for.");
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
