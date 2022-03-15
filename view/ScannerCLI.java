package view;

import java.util.Scanner;

import model.Library;
import view.pages.LandingPage;
import view.pages.Page;
import java.io.IOException;

public class ScannerCLI {
    public Page page = new LandingPage(this);
    public static boolean on = true;
    public static Scanner scanner = new Scanner(System.in);
    public static String input;
    public Library PL = new Library();

    ScannerCLI(){
        
    }
    
    public void turnOff(){
        on = false;
    }

    public void setPage(Page newPage){
        newPage.menu();
        this.page = newPage;
    }

    public void interpretInput(String str){
        this.page.interpretInput(str);
    }

    public void run() throws IOException{
        this.setPage(new LandingPage(this));
        PL.initalize();

        while(on){
            input = scanner.nextLine();
            interpretInput(input);
        }
    }
}
