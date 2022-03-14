package view.pages;

public abstract class Page{
    
    public void menu(){

    }
    public void quit(){
        
    }
    public void back(){

    }
    public void interpretInput(String str){

    }

    public boolean checkQuit(String str){
        if((str).equals("Q")|| (str).equals("q")){
            quit();
        }
        else if((str).equals("B")|| (str).equals("b")){
            back();
        }
        else {
            return (true);
        }
        return false;
    }

    public void error(){
        System.out.println("------------------------------------------------");

        System.out.println("ERROR: Please enter a valid menu option.");

        System.out.println("------------------------------------------------");
    }
}