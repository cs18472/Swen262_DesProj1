package view.pages;

import java.util.List;

import model.LibraryElement;
import view.ScannerCLI;
import view.pages.BrowsePages.PLArtistExplorePage;


public class PLBrowsePage extends Page {
    private final ScannerCLI scanner;

    public PLBrowsePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        displayArtists();
        System.out.println("------------------------------------------------");
        System.out.println("Please enter '1' to view your artists again.");
        System.out.println("If you wish to explore a certain artist, please enter the GUID of the artist.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new PLBrowsePage(scanner));
            }
            else{
                scanner.setPage(new PLArtistExplorePage(scanner, str));
            }
        }
    }

    private void displayArtists(){
        List<LibraryElement> artistList = this.scanner.PL.getArtists();
        if(artistList!= null){
            System.out.println("\n");
            for (LibraryElement e : (artistList)){
                System.out.println(e.toString());
            }
        }
    }
    @Override
    public void quit() {
        scanner.setPage(new LandingPage(scanner));
    }

    @Override
    public void back() {
        scanner.setPage(new PersonalLibraryOptions(scanner));
    }
}