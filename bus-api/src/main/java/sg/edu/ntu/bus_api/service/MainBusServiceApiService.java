package sg.edu.ntu.bus_api.service;

import java.util.List;

import sg.edu.ntu.bus_api.entity.BusService;

public interface MainBusServiceApiService {
    BusService createBusService(BusService busService);
    
    BusService getBusService(Long id);
    List<BusService> getAllBusServices();

    void deleteBusService(Long id);
    BusService updateBusService(Long id, BusService busService);

}
