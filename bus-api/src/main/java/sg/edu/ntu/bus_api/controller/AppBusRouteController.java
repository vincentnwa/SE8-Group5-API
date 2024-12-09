package sg.edu.ntu.bus_api.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.bus_api.entity.BusRoute;
import sg.edu.ntu.bus_api.service.BusRouteApiService;

@RestController
public class AppBusRouteController {
  // autowire
  private BusRouteApiService busRouteApiService;
  // constructor
  public AppBusRouteController(BusRouteApiService busServiceApiService){
    this.busRouteApiService = busServiceApiService;
  }

  @GetMapping("/app/routes")
  public ResponseEntity<?> findAll(){
    Map<String, Object> response = new LinkedHashMap<>();
    List<BusRoute> busRouteList = busRouteApiService.findAll();
    response.put("status", "Successful");
    response.put("data", busRouteList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
