package sg.edu.ntu.bus_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.edu.ntu.bus_api.entity.BusService;
import java.util.List;


@Repository
public interface BusServiceRepository extends JpaRepository<BusService, Long>{
  List<BusService> findByServiceNoIgnoreCase(String serviceNo);
} 
