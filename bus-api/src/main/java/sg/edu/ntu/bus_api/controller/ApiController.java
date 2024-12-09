package sg.edu.ntu.bus_api.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.bus_api.service.BusRouteApiService;
import sg.edu.ntu.bus_api.service.BusServiceApiService;
import sg.edu.ntu.bus_api.service.BusStopApiService;

@RestController
@RequestMapping(value="/datamall")
public class ApiController {
  // autowired
  private BusStopApiService busStopApiService;
  private BusServiceApiService busServiceApiService;
  private BusRouteApiService busRouteApiService;
  // constructor 
  public ApiController(
    BusStopApiService busStopApiService,
    BusServiceApiService busServiceApiService,
    BusRouteApiService busRouteApiService
  )  {
    this.busStopApiService = busStopApiService;
    this.busServiceApiService = busServiceApiService;
    this.busRouteApiService = busRouteApiService;
  }
  // GET Bus Stops
  @GetMapping("/stops")
  public ResponseEntity<?> getBusStops(){
    // return the status that Datamall return to me.
    HttpStatusCode statusCode = busStopApiService.getBusStops();
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("status_code", statusCode);
    // return the response
    return new ResponseEntity<>(response, statusCode);
  }

  // GET Bus Services
  @GetMapping("/services")
  public ResponseEntity<?> getBusServices(){
    // return the status that Datamall return to me.
    HttpStatusCode statusCode = busServiceApiService.getBusServices();
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("status_code", statusCode);
    // return the response
    return new ResponseEntity<>(response, statusCode);
  }
  // GET Bus Routes
  @GetMapping("/routes")
  public ResponseEntity<?> getBusRoutes(){
    // return the status that Datamall return to me.
    HttpStatusCode statusCode = busRouteApiService.getBusRoutes();
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("status_code", statusCode);
    // return the response
    return new ResponseEntity<>(response, statusCode);
  }

}
