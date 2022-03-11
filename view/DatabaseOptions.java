package view;

public class DatabaseOptions implements Page {

    private final ScannerCLI scanner;

    DatabaseOptions(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter '1' to search for a song.");
        System.out.println("Enter '2' to search for an artist.");
        System.out.println("Enter '3' to search for a release.");
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

    @Override
    public void interpretInput(String str) {
        if((str).equals("1")){
            System.out.println("Enter the song name.");
            //call again
            //databaseSearch(songName);
        }
        else if((str).equals("2")){
            
        }
        else if((str).equals("q")){
            quit();
        }
        
        else{
            System.out.println("------------------------------------------------");

            System.out.println("ERROR: Please enter a valid menu option.");

            System.out.println("------------------------------------------------");
        }
    }
    
}
