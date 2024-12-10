# SE8-Group5-API

## Endpoints

Endpoints in **controllerNote.md**.

Note that there are two types of API calls here.

- One is our calls to Datamall.
- Another is our own endpoints for the front-end app.


## Load data
  
**IMPORTANT**: Do this only one time. After that comment out the lines, as we do not want to load the database again.

```
  // post construct to load the data
  // IMPORTANT: Do this only one time.
  // After that comment out the lines, as we do not want to 
  // load the database again.
  @PostConstruct
  public void load(){
    busStopApiService.getBusStops();
    busServiceApiService.getBusServices();
    busRouteApiService.getBusRoutes();
  }

```

All Controller files to be in this folder

# Endpoints

## Supply to front-end

Supply to front-end, the route is prefixed by **/app**.

- Bus services
  - /app/services
- Bus stops
  - /app/stops
- Bus routes
  - /app/routes
- Bus arrival
  - /app/arrival

## From datamall

This is for initial testing to get the data one by one. Now, the data can be loaded once post construct in **service/DataLoader**.

Getting from Datamall, the route is prefixed by **/datamall**.

- Bus services
  - /datamall/services
- Bus stops
  - /datamall/stops
- Bus routes
  - /datamall/routes

