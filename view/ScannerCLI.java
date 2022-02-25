package view;

import java.util.Scanner;

public class ScannerCLI {
    public Page page = new LandingPage(this);
    public static boolean on = true;
    public static Scanner scanner = new Scanner(System.in);
    public static String input;

    ScannerCLI(){
        
    }

    public void setPage(Page newPage){
        newPage.menu();
        this.page = newPage;
    }

    public String interpretInput(String str){
        return this.page.interpretInput(str);
    }
    
    public void quit(){
        this.page.quit();
    }

    public void back(){
        this.page.back();
    }
    

    public void run(){
        this.setPage(new LandingPage(this));
        
        while(on){
            input = scanner.nextLine();
            interpretInput(input);
        }
    }

    public static void main(String[] args) {
        ScannerCLI newCli = new ScannerCLI();
        newCli.run();
    }
}
