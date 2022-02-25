package view;


public class PersonalLibraryOptions implements Page {

    private final ScannerCLI scanner;

    PersonalLibraryOptions(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void interpretInput(String str) {
        // TODO Auto-generated method stub
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to enter the Personal Library Search.");
        System.out.println("Enter '2' to enter the Personal Library Search.");
        System.out.println("Enter '3' to remove from your Personal Library.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void quit() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void back() {
        // TODO Auto-generated method stub
        
    }
    
}
