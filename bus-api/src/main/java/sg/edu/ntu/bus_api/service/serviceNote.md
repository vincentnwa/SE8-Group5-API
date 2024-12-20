All Service files to be in this folder

# Supply UserAccess Service
- This interface defines method for managing the CRUD operation

# Supply UserAccess Service Implementation
Key features:
- Uses the repository via constructor injection
- Automatically set Timestamps for created_at and updated_at
- Exception Handling
- Business logic for CRUD

Using the Spring Bean annotations - @Service

## On Exception Handling in ServiceImpl files

It is in ServiceImpl files where we have to throw exceptions, after configuring our exception handlers in the GlobalExceptionHandler.java

example 1:
```java
public BusStop getBusStop(Long id) {
    return busStopRepository.findById(id).orElseThrow(() -> new BusStopNotFoundException(id));
}
```
We are throwing new BusStopNotFoundException() here.

example 2:
```java
public BusStop createBusStop(BusStop busStop) {
        // Create a bus stop object to store the existing bus stop if it exists, elese this will be null
        BusStop existingBusStop = busStopRepository.findByBusStopCode(busStop.getBusStopCode());
        // Check if bus stop code already exists
        if (busStopRepository.existsByBusStopCode(busStop.getBusStopCode())) {
            // throw new IllegalArgumentException("Bus stop code already exists: " + existingBusStop.getBusStopCode());
            throw new BusStopDuplicateException(existingBusStop.getBusStopId(), existingBusStop.getBusStopCode());
        }
        BusStop newBusStop = busStopRepository.save(busStop);
        return newBusStop;
    }
```
We throw new BusStopDuplicateExceptio() here.