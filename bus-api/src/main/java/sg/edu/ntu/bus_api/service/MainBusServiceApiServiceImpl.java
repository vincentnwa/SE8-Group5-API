package sg.edu.ntu.bus_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.bus_api.entity.BusService;
import sg.edu.ntu.bus_api.exception.BusServiceNotFoundException;
import sg.edu.ntu.bus_api.repository.BusServiceRepository;

// @Service indicates that this class holds business logic, and is part of service layer
@Service
public class MainBusServiceApiServiceImpl implements MainBusServiceApiService {
    
    private BusServiceRepository busServiceRepository;

    //Constructor injection

    public MainBusServiceApiServiceImpl (BusServiceRepository busServiceRepository) {
        this.busServiceRepository = busServiceRepository;
    }

    public BusService createBusService(BusService busService){
        BusService newBusService = busServiceRepository.save(busService);
        return newBusService;
    }

    public BusService getBusService(Long id){
        return busServiceRepository.findById(id).orElseThrow(()-> new BusServiceNotFoundException(id));
    }

    public List<BusService> getAllBusServices(){
        List<BusService> allBusServices = busServiceRepository.findAll();
        return allBusServices;
    }

    public void deleteBusService(Long id) {
        busServiceRepository.deleteById(id);
    }

    public BusService updateBusService(Long id, BusService busService) {
        // Retrieve the bus service from database, throw exception if not found
        BusService busServiceToUpdate = busServiceRepository.findById(id).orElseThrow(()-> new BusServiceNotFoundException(id));

        // Update the bus service object that was retrieved
        busServiceToUpdate.setServiceNo(busService.getServiceNo());
        busServiceToUpdate.setOperator(busService.getOperator());
        busServiceToUpdate.setDirection(busService.getDirection());
        busServiceToUpdate.setCategory(busService.getCategory());
        busServiceToUpdate.setOriginCode(busService.getOriginCode());
        busServiceToUpdate.setDestinationCode(busService.getDestinationCode());
        busServiceToUpdate.setAM_Peak_Freq(busService.getAM_Peak_Freq());
        busServiceToUpdate.setAM_Offpeak_Freq(busService.getAM_Offpeak_Freq());
        busServiceToUpdate.setPM_Peak_Freq(busService.getPM_Peak_Freq());
        busServiceToUpdate.setPM_Offpeak_Freq(busService.getPM_Offpeak_Freq());
        busServiceToUpdate.setLoopDesc(busService.getLoopDesc());

        // Save updated bus service back to database
        return busServiceRepository.save(busServiceToUpdate);
    }
}
