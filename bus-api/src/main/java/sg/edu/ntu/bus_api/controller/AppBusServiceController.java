package sg.edu.ntu.bus_api.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.bus_api.entity.BusService;
import sg.edu.ntu.bus_api.service.BusServiceApiService;

@RestController
public class AppBusServiceController {
  // autowire
  private BusServiceApiService busServiceApiService;
  // constructor
  public AppBusServiceController(BusServiceApiService busServiceApiService){
    this.busServiceApiService = busServiceApiService;
  }

  @GetMapping("/app/services")
  public ResponseEntity<?> findAll(){
    Map<String, Object> response = new LinkedHashMap<>();
    List<BusService> busServiceList = busServiceApiService.findAll();
    response.put("status", "Successful");
    response.put("data", busServiceList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  // find by bus service no
  @GetMapping("/app/services/{serviceNo}")
  public ResponseEntity<?> findByServiceNo(@PathVariable String serviceNo){
    Map<String, Object> response = new LinkedHashMap<>();
    List<BusService> busServiceList = busServiceApiService.findByBusServiceNo(serviceNo);
    response.put("status", "Successful");
    response.put("data", busServiceList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
