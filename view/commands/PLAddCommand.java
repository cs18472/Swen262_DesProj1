package view.commands;

import java.io.IOException;

import model.Library;

public class PLAddCommand {

    public static void execute(Library PL, String str){
        try {
            PL.add(str);
        } catch (IOException e) {}
    }
}
