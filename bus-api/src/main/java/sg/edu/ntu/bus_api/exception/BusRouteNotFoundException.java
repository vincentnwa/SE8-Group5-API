package sg.edu.ntu.bus_api.exception;

public class BusRouteNotFoundException extends RuntimeException {
    public BusRouteNotFoundException (Long id){
        super("Could not find Bus Route with id: " + id + ".");
    }
}
