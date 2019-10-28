import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reminder extends Alarm {


    public static final DateTimeFormatter DATE_FORMAT
            = DateTimeFormatter.ofPattern("uuuu; MM/dd");

    @Override
    public String toString() {
        return "Reminder{" +
                "date=" + date +
                '}';
    }

    private LocalDate date;

    @Override
    public void askInfo() {
        super.askInfo();
        System.out.print("date> ");
        String strDate = Main.scan.next();
        date = LocalDate.parse(strDate, DATE_FORMAT);
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
