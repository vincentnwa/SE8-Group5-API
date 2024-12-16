package sg.edu.ntu.bus_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.bus_api.entity.UserAccess;

public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    List<UserAccessRepository> findByUsernameIgnoreCase(String username);

}
