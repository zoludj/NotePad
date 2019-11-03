import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note {

public static final DateTimeFormatter TIME_FORMAT
        = DateTimeFormatter.ofPattern("HH:mm");



    private LocalTime time;

    @Override
    public void askInfo() {
        super.askInfo();
        time = Asker.askTime("time");
    }



    @Override
    public String toString() {
        return "Alarm{" +
                "id='" + getId() + '\'' +
                ", time='" + getText() + '\'' +
                ", text='" + time.format(TIME_FORMAT) + '\'' +
                '}';
    }

    public boolean contains(String str) {
        return super.contains(str)
                ||time.format(TIME_FORMAT).contains(str);
            }
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {this.time = time; }

}




