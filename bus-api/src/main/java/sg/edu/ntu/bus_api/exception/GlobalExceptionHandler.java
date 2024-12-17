package sg.edu.ntu.bus_api.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    // Add exception handlers here
    // Look at @ExceptionHandler line to see name of handler

    @ExceptionHandler(BusStopNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBusStopNotFoundException (BusStopNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusServiceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBusStopNotFoundException (BusServiceNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusRouteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBusRouteNotFoundException (BusRouteNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Validation exception handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        List<ObjectError> validationErrors = e.getBindingResult().getAllErrors();

        StringBuilder sb = new StringBuilder();

        for (ObjectError error : validationErrors) {
            sb.append(error.getDefaultMessage() + ". ");
        }
        
        ErrorResponse errorResponse = new ErrorResponse(sb.toString(), LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // General Exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse("Something went wrong. This is from General Exception handler.", LocalDateTime.now());

        //you can call logger here
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

// A general exception handler can catch any exception (both checked and
// unchecked) that is not explicitly handled elsewhere