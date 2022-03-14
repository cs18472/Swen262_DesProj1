package view;

import java.util.Scanner;

import model.Database;
import view.pages.LandingPage;
import view.pages.Page;

import java.io.File;
import java.io.IOException;

public class ScannerCLI {
    public Page page = new LandingPage(this);
    public static boolean on = true;
    public static Scanner scanner = new Scanner(System.in);
    public static String input;

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

    public void run(){
        this.setPage(new LandingPage(this));
        
        while(on){
            input = scanner.nextLine();
            interpretInput(input);
        }
    }

    public static void main(String[] args) throws IOException{
        
        File librarytxt = new File("./model/Library.txt");
        boolean exists = librarytxt.exists();
        if(!exists) librarytxt.createNewFile();
        if(exists) System.out.println("library imported");
        Database.main(args);

        ScannerCLI newCli = new ScannerCLI();
        newCli.run();
    }
}
