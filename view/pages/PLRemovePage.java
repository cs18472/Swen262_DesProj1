package view.pages;

import view.ScannerCLI;
import view.commands.PLRemoveCommand;

public class PLRemovePage extends Page {
    private final ScannerCLI scanner;

    PLRemovePage(ScannerCLI scanner){
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------------------");
        System.out.println("Enter the GUID of the song or release that you wish to remove.");
        System.out.println("Enter 'B' to return to the previous page.");
        System.out.println("Enter 'Q' to return to the landing page.");
        System.out.println("------------------------------------------------");
        
    }

    @Override
    public void interpretInput(String str) {
        if (checkQuit(str)){
            PLRemoveCommand.execute(scanner.PL, str);
        }
    }

    @Override
    public void back() {
        scanner.setPage(new PLSearchDirectoryPage(scanner));
    }
}
