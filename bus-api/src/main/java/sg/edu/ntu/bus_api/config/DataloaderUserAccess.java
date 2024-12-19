package sg.edu.ntu.bus_api.config;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import sg.edu.ntu.bus_api.entity.UserAccess;
import sg.edu.ntu.bus_api.repository.UserAccessRepository;

@Component
public class DataloaderUserAccess {
        private UserAccessRepository userAccessRepository;

        // @PersistenceContext
        // private EntityManager entityManager;

        public DataloaderUserAccess(UserAccessRepository userAccessRepository) {
                this.userAccessRepository = userAccessRepository;
        }

        @PostConstruct
        public void loadUserAccessData() {

                // Delete the exisiting data
                userAccessRepository.deleteAll();
                // entityManager.createNativeQuery("DBCC CHECKIDENT ('user_access', RESEED,
                // 0)").executeUpdate();

                userAccessRepository.save(UserAccess.builder().username("TestUser1").password("TestUser123")
                                .accessLevel("Admin").created_At(LocalDateTime.now()).updated_At(null).build());
                userAccessRepository
                                .save(UserAccess.builder().username("TestUser2").password("TestUser222")
                                                .accessLevel("User")
                                                .created_At(LocalDateTime.now()).updated_At(null).build());
                userAccessRepository
                                .save(UserAccess.builder().username("TestUser3").password("TestUser333")
                                                .accessLevel("Editor")
                                                .created_At(LocalDateTime.now()).updated_At(null).build());

        }
}
