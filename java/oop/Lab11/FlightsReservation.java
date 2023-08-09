public class FlightsReservation {
    private Flights flights;
    private PlaneSeating seating;

    public FlightsReservation(Flights flights) {
        this.flights = flights;
        this.seating = new Plane22Seating("xx_xx,xx_x^,^x_xx,x^_xx,xx_^x");
    }
    public void showSeating(){
        System.out.printf("Flight [%s,%s to %s, %s, Time=%s]\n",flights.getCode(),flights.getSource(),flights.getDestination(),flights.getDay(),flights.getDepartTime());
        seating.showSeating();
    }
    public boolean reserveSeat(int row, int col){

        return seating.reserveSeat(row, col);
    }
}
