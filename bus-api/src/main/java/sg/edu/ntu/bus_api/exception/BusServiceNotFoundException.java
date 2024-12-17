package sg.edu.ntu.bus_api.exception;

public class BusServiceNotFoundException extends RuntimeException {
    public BusServiceNotFoundException (Long id){
        super("Could not find Bus Service with id: " + id + ".");
    }
}
