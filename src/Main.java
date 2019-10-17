import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);
    static ArrayList <Person> records = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Enter a command. Type 'help' for help");
        for (; ; ) {
            System.out.print("> ");
            String cmd = scan.next();
            switch (cmd) {
                case "exit":
                    System.out.println("Good bye");
                    return;
                case "help":
                    showHelp();
                    break;
                case "create":
                    createRecord();
                    break;


                case "list":
                        listRecords();
                        break;

                default:
                    System.out.println("Error: Unknown command");


            }
        }
    }

    private static void listRecords() {

        for (Record p  : records) {
            System.out.println(p);

        }
    }

    private static void createRecord() {

        System.out.print ("type> ");
        String type = scan.next();
        switch (type) {
            case "person":
                createPerson();
                break;
            default:
                System.out.println("Error: Unknown record type");
        }
    }

    private static void createPerson() {

        Person p = new Person();
        p.askInfo();
        records.add (p);

    }

    private static void showHelp() {
System.out.println("One day here will be a great manual.Eventually.");
    }
}
