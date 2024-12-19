package sg.edu.ntu.bus_api.service;

import java.util.List;

import sg.edu.ntu.bus_api.entity.BusStop;

public interface MainBusStopApiService {
    BusStop createBusStop(BusStop busStop);
    BusStop getBusStop(Long id);
    List<BusStop> getAllBusStops();

    void deleteBusStop(Long id);
    BusStop updateBusStop(Long id, BusStop busStop);

}

// An interface is like contract, anything that implements this has to have the below methods
// it also acts like a middle-man device that when you switch to an improved CustomerServiceImpl code like switching App version, 
// you can continue to refer to CustomerService in the Controller.java, and Spring boot will detect and find the correct version 
// (but must set that improved CustomerServiceImpl.java as a bean and also @Primary if there are multiple versions implementing same interface, for Springboot to find the correct version to inject)
