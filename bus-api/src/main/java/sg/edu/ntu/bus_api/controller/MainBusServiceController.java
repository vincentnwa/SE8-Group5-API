package sg.edu.ntu.bus_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.bus_api.entity.BusService;
import sg.edu.ntu.bus_api.service.MainBusServiceApiService;

@RestController
@RequestMapping("/app1")
public class MainBusServiceController {
    
    private MainBusServiceApiService mainBusServiceApiService;

    // Constructor injection
    public MainBusServiceController(MainBusServiceApiService mainBusServiceApiService) {
        this.mainBusServiceApiService = mainBusServiceApiService;
    }

    // Read - get all Bus Services
    @GetMapping("/bus-services-all")
    public ResponseEntity<List<BusService>> getAllBusServices() {
        List<BusService> allBusServices = mainBusServiceApiService.getAllBusServices();
        return new ResponseEntity<>(allBusServices, HttpStatus.OK);
    }

    // Read - get one Bus Service
    @GetMapping("/bus-services/{id}")
    public ResponseEntity<BusService> getBusService(@PathVariable Long id){
        return new ResponseEntity<>(mainBusServiceApiService.getBusService(id), HttpStatus.OK);
    }

    // Create a bus service. CAUTION: this method creates bus service in the local database and it is persists
    @PostMapping("/bus-services")
    public ResponseEntity<BusService> createBusService(@RequestBody BusService busService){
        BusService newBusService = mainBusServiceApiService.createBusService(busService);
        return new ResponseEntity<>(newBusService, HttpStatus.CREATED);
    }

    // Delete
    @DeleteMapping("/bus-services/{id}")
    public ResponseEntity<HttpStatus> deleteBusService(@PathVariable Long id) {
        mainBusServiceApiService.deleteBusService(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Update
    @PutMapping("/bus-services/{id}")
    public ResponseEntity<BusService> updateBusService(@PathVariable Long id, @RequestBody BusService busService) {
        BusService updatedBusService = mainBusServiceApiService.updateBusService(id, busService);
        return new ResponseEntity<>(updatedBusService, HttpStatus.OK);
    }
}
