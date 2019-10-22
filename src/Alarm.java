public class Alarm extends Note {


    private String time;

    @Override
    public void askInfo() {
        super.askInfo();
        System.out.println("time> ");
        time = Main.scan.next();

    }



    @Override
    public String toString() {
        return "Alarm{" +
                "id='" + getId() + '\'' +
                ", time='" + time + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

    public boolean contains(String str) {
        return super.contains(str)
                ||time.contains(str));
            }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}




