package sg.edu.ntu.bus_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.bus_api.entity.BusRoute;
import sg.edu.ntu.bus_api.exception.BusRouteNotFoundException;
import sg.edu.ntu.bus_api.repository.BusRouteRepository;

@Service
public class MainBusRouteApiServiceImpl implements MainBusRouteApiService {

    private BusRouteRepository busRouteRepository;

    // Constructor injection
    public MainBusRouteApiServiceImpl(BusRouteRepository busRouteRepository) {
        this.busRouteRepository = busRouteRepository;
    }

    public BusRoute createBusRoute(BusRoute busRoute) {
        BusRoute newBusRoute = busRouteRepository.save(busRoute);
        return newBusRoute;
    }

    public BusRoute getBusRoute(Long id) {
        return busRouteRepository.findById(id).orElseThrow(() -> new BusRouteNotFoundException(id));
    }

    public List<BusRoute> getAllBusRoutes() {
        List<BusRoute> allBusRoutes = busRouteRepository.findAll();
        return allBusRoutes;
    }

    public BusRoute updateBusRoute(Long id, BusRoute busRoute) {
        // Retrieve the bus route from database, throw exception if not found
        BusRoute busRouteToUpdate = busRouteRepository.findById(id)
                .orElseThrow(() -> new BusRouteNotFoundException(id));

        // Update the bus route object that was retrieved
        busRouteToUpdate.setServiceNo(busRoute.getServiceNo());
        busRouteToUpdate.setOperator(busRoute.getOperator());
        busRouteToUpdate.setDirection(busRoute.getDirection());
        busRouteToUpdate.setStopSequence(busRoute.getStopSequence());
        busRouteToUpdate.setBusStopCode(busRoute.getBusStopCode());
        busRouteToUpdate.setDistance(busRoute.getDistance());
        busRouteToUpdate.setWD_FirstBus(busRoute.getWD_FirstBus());
        busRouteToUpdate.setWD_LastBus(busRoute.getWD_LastBus());
        busRouteToUpdate.setSAT_FirstBus(busRoute.getSAT_FirstBus());
        busRouteToUpdate.setSAT_LastBus(busRoute.getSAT_LastBus());
        busRouteToUpdate.setSUN_FirstBus(busRoute.getSUN_FirstBus());
        busRouteToUpdate.setSUN_LastBus(busRoute.getSUN_LastBus());

        // Save updated bus route back to database
        return busRouteRepository.save(busRouteToUpdate);
    }

    public void deleteBusRoute(Long id) {
        busRouteRepository.deleteById(id);
    }
}
