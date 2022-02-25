package view;


public class LandingPage implements Page {
    private final ScannerCLI scanner;

    LandingPage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public String interpretInput(String str) {
        if((str).equals("1")){
            scanner.setPage(new PersonalLibraryOptions(scanner));
        }
        
        else{
            System.out.println("------------------------------------------------");

            System.out.println("ERROR: Please enter a valid menu option.");

            System.out.println("------------------------------------------------");
        }
        return null;
    }

    @Override
    public String quit() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String back() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to The Muze Music Library System (MMLS)");
        System.out.println("Press '1' to view your Personal Library Options.");
        System.out.println("Press '2' to view the Database Options.");
        System.out.println("Press 'q' to Quit.");
        System.out.println("------------------------------------------------");
    }

}
