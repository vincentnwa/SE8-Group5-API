package sg.edu.ntu.bus_api.service;

import java.util.List;

import sg.edu.ntu.bus_api.entity.BusRoute;

public interface MainBusRouteApiService {
    BusRoute createBusRoute(BusRoute busRoute);

    BusRoute getBusRoute(Long id);
    List<BusRoute> getAllBusRoutes();

    void deleteBusRoute(Long id);
    BusRoute updateBusRoute(Long id, BusRoute busRoute);
    
}
