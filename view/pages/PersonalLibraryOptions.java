package view.pages;

import view.ScannerCLI;

public class PersonalLibraryOptions extends Page {

    private final ScannerCLI scanner;
    
    public PersonalLibraryOptions(ScannerCLI scanner){
        this.scanner = scanner;
    }

    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to enter the Personal Library Search.");
        System.out.println("Enter '2' to add to your Personal Library.");
        System.out.println("Enter '3' to remove from your Personal Library.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            if((str).equals("1")){
                scanner.setPage(new PLSearchDirectoryPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new PLAddPage(scanner));
            }
            else if ((str).equals("3")){
                scanner.setPage(new PLRemovePage(scanner));
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
        scanner.setPage(new LandingPage(scanner));
    }
    
}
