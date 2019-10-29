import java.time.LocalDate;
import java.time.LocalTime;

public class Alarm extends Note implements Expirable {


    private LocalTime time;
    private LocalDate dismissedAt;

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
                ", text='" + time.format(Asker.TIME_FORMAT) + '\'' +
                '}';
    }

    public boolean contains(String str) {
        return super.contains(str)
                || time.format(Asker.TIME_FORMAT).contains(str);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean isExpired() {
        if (LocalDate.now().equals(dismissedAt)){
            return false;
        }
        return LocalTime.now().isAfter(time);
    }

    @Override
    public void dismiss() {
        dismissedAt = LocalDate.now();

    }
}




