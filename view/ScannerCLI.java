package view;

import java.util.Scanner;

public class ScannerCLI {
    public Page page = new LandingPage(this);
    public boolean on = true;
    private Scanner scanner = new Scanner(System.in);
    ScannerCLI(){
        
    }

    public void interpretInput(){
        this.page.interpretInput();
    }
    
    public void quit(){
        this.page.quit();
    }

    public void back(){
        this.page.back();
    }
    
}
