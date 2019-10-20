
import java.util.Scanner;

public class Note extends Record {

    private String text;

    public void askInfo() {
        System.out.println("text> ");
        text = Main.scan.next();
    }


    public String getText() { return text; }

    public void setText(String text) {this.text = text;}

    @Override
    public String toString() {
        return "Note{" +
                "text='" + text + '\'' +
                '}';
    }
}