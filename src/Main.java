import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);
    static ArrayList<Record> records = new ArrayList<>();



    public static void main(String[] args) {

        scan.useDelimiter("\n");
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

                case "find":
                    findRecord();
                    break;
                case "delete":
                    deleteRecord();
                    break;

                default:
                    System.out.println("Error: Unknown command");


            }
        }
    }



    private static void deleteRecord() {
        System.out.print("id> ");
        int id = scan.nextInt();
        int size = records.size();
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);

            if (r.getId()== id) {
                records.remove(i);
                break;
            }

        }

    }

    private static void findRecord() {
        System.out.print("substring> ");
        String str = scan.next();
        for (Record r : records){
            if(r.contains(str)){
                System.out.print(r);
            }
        }
    }

    private static void listRecords() {

        for (Record p : records){
            System.out.println(p);

        }
    }

    private static void createRecord() {

        System.out.print("type> ");
        String type = scan.next();
        switch (type) {
            case "person":
                createRecord(new Person());
                break;
            case "note":
                createRecord(new Note());
                break;
            case "alarm":
                createRecord(new Alarm());
                break;
            case "date":
                createRecord(new Reminder());
                break;
            default:
                System.out.println("Error: Unknown record type");


        }
    }


    private static void createRecord(Record r){
        r.askInfo();
        records.add(r);
    }

        private static void showHelp () {
            System.out.println("One day here will be a great manual.Eventually.");
        }
    }

