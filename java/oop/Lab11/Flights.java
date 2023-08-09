public class Flights {
    private String code;
    private City source;
    private City destination;
    private DayOfWeek day;
    private Time departTime;

    public Flights(String code, City source, City destination, DayOfWeek day, Time departTime) {
        this.code = code;
        this.source = source;
        this.destination = destination;
        this.day = day;
        this.departTime = departTime;
    }

    public String getCode() {
        return code;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public Time getDepartTime() {
        return departTime;
    }
}
