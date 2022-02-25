package view;

public interface Page{
    public void menu();
    public String quit();
    public String back();
    public String interpretInput(String str);
}