package view;

import java.util.Scanner;

public class ScannerCLI {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Muze Music Library System \nPlease Press Enter to continue");
        try{        System.in.read();}catch(Exception e){	e.printStackTrace();}
        System.out.println("Where would you like to go? Press the corresponding number key to choose your option.");
        System.out.println("1. View Personal Library\n 2.Edit Personal Libary \n ");


    }
}
