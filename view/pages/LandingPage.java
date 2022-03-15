package view.pages;

import view.ScannerCLI;

public class LandingPage extends Page {
    private final ScannerCLI scanner;

    public LandingPage(ScannerCLI scanner){
        this.scanner = scanner;
    }
    
    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to The Muze Music Library System (MMLS)");
        System.out.println("Press '1' to view your Personal Library Options.");
        System.out.println("Press '2' to view the Database Options.");
        System.out.println("Press 'Q' to Quit.");
        System.out.println("------------------------------------------------");
    }

    @Override
    public void interpretInput(String str) {

        if (checkQuit(str)){

            if((str).equals("1")){
                scanner.setPage(new PersonalLibraryOptionsPage(scanner));
            }
            else if((str).equals("2")){
                scanner.setPage(new DBOptionsPage(scanner));
            }
            else{
                error();
            }
        }
    }

    @Override
    public void quit() {
        scanner.turnOff();
    }

    @Override
    public void back() {
        scanner.turnOff();
    }

}
