package view.commands;

import java.io.IOException;

import model.Library;

public class PLRemoveCommand {

    public static void execute(Library PL, String str){
        try {
            PL.remove(str);
        } catch (IOException e) {}
    }
}
