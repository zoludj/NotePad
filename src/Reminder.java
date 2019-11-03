import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Alarm implements Expirable {
    private LocalDate date;
    private boolean dismissed = false;

    public static final DateTimeFormatter DATE_FORMAT
            = DateTimeFormatter.ofPattern("uuuu; MM/dd");

    @Override
    public boolean isExpired() {
        if (dismissed == true){
            return false;
        }
        var dt = LocalDateTime.of(date, getTime());

        return LocalDateTime.now().isAfter(dt);
    }

    @Override
    public void dismiss() {
        dismissed =true;


    }

    @Override
    public String toString() {
        return "Reminder{" +
                "date=" + date +
                '}';
    }


    @Override
    public void askInfo() {
        super.askInfo();
        date = Asker.askDate("date");

    }

    public boolean contains(String str) {
        return super.contains(str)
                || date.format(DATE_FORMAT).contains(str);

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
