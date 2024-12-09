package sg.edu.ntu.bus_api.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

/* Load all the Datamall data into the database once. */

@Component
public class DataLoader {
  // autowired services
  BusStopApiService busStopApiService;
  BusServiceApiService busServiceApiService;
  BusRouteApiService busRouteApiService;
  // constructor
  public DataLoader(
    BusStopApiService busStopApiService,
    BusServiceApiService busServiceApiService,
    BusRouteApiService busRouteApiService 
  ){
    this.busStopApiService = busStopApiService;
    this.busServiceApiService = busServiceApiService;
    this.busRouteApiService = busRouteApiService;
  }
  // post construct to load the data
  @PostConstruct
  public void load(){
    busStopApiService.getBusStops();
    busServiceApiService.getBusServices();
    busRouteApiService.getBusRoutes();
  }

}
