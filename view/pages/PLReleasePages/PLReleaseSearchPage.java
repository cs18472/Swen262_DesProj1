package view.pages.PLReleasePages;

import view.ScannerCLI;
import view.pages.LandingPage;
import view.pages.Page;
import view.pages.PersonalLibraryOptionsPage;

public class PLReleaseSearchPage extends Page{
    private final ScannerCLI scanner;

    public PLReleaseSearchPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Press '1' to list all releases in your library alphabetically.");
        System.out.println("Press '2' to search for releases by the name of their artist.");
        System.out.println("Press '3' to search for releases by the GUID of their artist.");
        System.out.println("Press '4' to search for releases by the name of a song.");
        System.out.println("Press '5' to search for releases by the GUID of a song.");
        System.out.println("Press '6' to search for releases by release date.");
        System.out.println("Press '7' to search by release songs minimum total duration.");
        System.out.println("Press '8' to search by release songs maximum total duration.");
        System.out.println("Press 'B' to return to the previous page.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){
            
            if((str).equals("1")){
                scanner.setPage(new PLReleaseAlphaSearchPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new PLReleaseArtistNameSearchPage(scanner));
            }
            else if((str).equals("3")){
                scanner.setPage(new PLReleaseArtistGUIDSearchPage(scanner));
            }
            else if((str).equals("4")){
                scanner.setPage(new PLReleaseSongNameSearchPage(scanner));
            }
            else if((str).equals("5")){
                scanner.setPage(new PLReleaseSongGUIDSearchPage(scanner));
            }
            else if((str).equals("6")){
                scanner.setPage(new PLReleaseDateSearchPage(scanner));
            }
            else if((str).equals("7")){
                scanner.setPage(new PLReleaseDurMinSearchPage(scanner));
            }
            else if((str).equals("8")){
                scanner.setPage(new PLReleaseDurMaxSearchPage(scanner));
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
        scanner.setPage(new PersonalLibraryOptionsPage(scanner));
    }
    
}
