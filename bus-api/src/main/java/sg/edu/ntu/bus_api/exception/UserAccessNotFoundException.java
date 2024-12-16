package sg.edu.ntu.bus_api.exception;

public class UserAccessNotFoundException extends RuntimeException {
    public UserAccessNotFoundException(Long id) {
        super("Could not find user with id: " + id);
    }

}
