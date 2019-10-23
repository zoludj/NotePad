
import java.util.Scanner;

public class Note extends Record {

    private String text;

    @Override
    public void askInfo() {
        System.out.println("enter text> ");
        text = Main.scan.next();
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        if (text.contains(str)) {
            return true;
        }
        return false;
    }
}