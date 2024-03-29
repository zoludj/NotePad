import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    static ArrayList<Record> records = new ArrayList<>();


    public static void main(String[] args) {


        System.out.println("Enter a command. Type 'help' for help");
        for (; ; ) {

            String cmd = Asker.askString("cmd");
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
                case "expired":
                    listExpiredRecords();
                    break;
                case "dismiss":
                    dismissExpirable();
                    break;
                case "delete all":
                    deleteAll();
                    break;

                default:
                    System.out.println("Error: Unknown command");


            }
        }
    }

    private static void deleteAll() {
        String substr = Asker.askString("substring");
        Iterator<Record> iterator = records.iterator();
        while (iterator.hasNext()) {
            Record r = iterator.next();
            if (r.contains(substr)) {
                iterator.remove();
            }
        }
    }

    private static void dismissExpirable() {
        int id = Asker.askInt("id");
        for (Record r : records) {
            if (r instanceof Expirable && r.getId() == id) {
                Expirable e = (Expirable) r;
                if (r.getId() == id)
                    e.dismiss();

            }
        }
    }

    private static void listExpiredRecords() {
        for (Record r : records) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (e.isExpired()) {
                    System.out.println(r);
                }
            }
        }
    }


    private static void deleteRecord() {

        int id = Asker.askInt("id");
        int size = records.size();
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);

            if (r.getId() == id) {
                records.remove(i);
                break;
            }

        }

    }

    private static void findRecord() {

        String str = Asker.askString("Substring");
        for (Record r : records) {
            if (r.contains(str)) {
                System.out.print(r);
            }
        }
    }

    private static void listRecords() {

        for (Record p : records) {
            System.out.println(p);

        }
    }

    private static void createRecord() {


        String type = Asker.askString("type");
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
            case "reminder":
                createRecord(new Reminder());
                break;
            default:
                System.out.println("Error: Unknown record type");


        }
    }

    private static void createRecord(Record r) {
        r.askInfo();
        records.add(r);
    }

    private static void showHelp() {
        System.out.println("One day here will be a great manual.Eventually.");
    }
}

