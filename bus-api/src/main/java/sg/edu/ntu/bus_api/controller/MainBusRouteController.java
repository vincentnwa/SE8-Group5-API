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

import sg.edu.ntu.bus_api.entity.BusRoute;
import sg.edu.ntu.bus_api.service.MainBusRouteApiService;

@RestController
@RequestMapping("/app1")
public class MainBusRouteController {

    private MainBusRouteApiService mainBusRouteApiService;

    // Constructor injection
    public MainBusRouteController(MainBusRouteApiService mainBusRouteApiService) {
        this.mainBusRouteApiService = mainBusRouteApiService;
    }

    // Create a bus route. 
    // CAUTION: this method creates bus route in the local database and it is persists
    @PostMapping("/bus-routes")
    public ResponseEntity<BusRoute> createBusRoute(@RequestBody BusRoute busRoute) {
        BusRoute newBusRoute = mainBusRouteApiService.createBusRoute(busRoute);
        return new ResponseEntity<>(newBusRoute, HttpStatus.CREATED);
    }

    // Read - get all Bus Routes
    @GetMapping("/bus-routes-all")
    public ResponseEntity<List<BusRoute>> getAllBusRoute() {
        List<BusRoute> allBusRoutes = mainBusRouteApiService.getAllBusRoutes();
        return new ResponseEntity<>(allBusRoutes, HttpStatus.OK);
    }

    // Read - get one Bus Route
    @GetMapping("/bus-routes/{id}")
    public ResponseEntity<BusRoute> getBusRoute(@PathVariable Long id) {
        return new ResponseEntity<>(mainBusRouteApiService.getBusRoute(id), HttpStatus.OK);
    }

    // Update
    @PutMapping("/bus-routes/{id}")
    public ResponseEntity<BusRoute> updateBusRoute(@PathVariable Long id, @RequestBody BusRoute busRoute) {
        BusRoute updatedBusRoute = mainBusRouteApiService.updateBusRoute(id, busRoute);
        return new ResponseEntity<>(updatedBusRoute, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/bus-routes/{id}")
    public ResponseEntity<HttpStatus> deleteBusRoute(@PathVariable Long id) {
        mainBusRouteApiService.deleteBusRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
