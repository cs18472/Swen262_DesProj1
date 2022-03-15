package view.pages.PLArtistSearchPages;


import view.ScannerCLI;
import view.pages.LandingPage;
import view.pages.PLSearchDirectoryPage;
import view.pages.Page;

public class PLArtistSearchPage extends Page{
    private final ScannerCLI scanner;

    public PLArtistSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Press '1' to list all artists in your library alphabetically.");
        System.out.println("Press '2' to search for an artist by their name.");
        System.out.println("Press '3' to search for an artist genre or type.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){

            if((str).equals("1")){
                scanner.setPage(new PLArtistAlphaPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new PLArtistNamePage(scanner));
            }
            else if((str).equals("3")){
                scanner.setPage(new PLArtistTypePage(scanner));
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
