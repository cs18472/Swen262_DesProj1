package view.pages;

import view.ScannerCLI;


public class PLBrowsePage extends Page {
    private final ScannerCLI scanner;

    public PLBrowsePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        this.interpretInput("1");
        System.out.println("------------------------------------------------");
        System.out.println("Please enter '1' to explore an artist.");
        System.out.println("Please enter '2' to view your artists again.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new PLArtistExplorePage(scanner));
            }
            else if((str).equals("2")){
                //display all Artists
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