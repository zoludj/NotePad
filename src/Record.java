public abstract class Record {

    private static int counter = 0;
    private int id;

    public Record() {
        counter++;
        id = counter;
    }

    public abstract void askInfo();


    public  boolean contains (String str) {

        String strID = Integer.toString(id);
        return strID.contains(str);
    }
    public int getId() { return id; }


}


