package sg.edu.ntu.bus_api.exception;

public class BusStopNotFoundException extends RuntimeException {
    public BusStopNotFoundException (Long id) {
        super("Could not find Bus Stop with id: " + id + ".");
    }
}
