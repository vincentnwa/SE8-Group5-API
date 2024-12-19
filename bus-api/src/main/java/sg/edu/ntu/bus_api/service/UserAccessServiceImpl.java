package sg.edu.ntu.bus_api.service;

// import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sg.edu.ntu.bus_api.entity.UserAccess;
import sg.edu.ntu.bus_api.exception.UserAccessNotFoundException;
import sg.edu.ntu.bus_api.repository.UserAccessRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class UserAccessServiceImpl implements UserAccessService {

    private UserAccessRepository userAccessRepository;

    public UserAccessServiceImpl(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    public UserAccess createUserAccess(UserAccess userAccess) {
        userAccess.setCreated_At(LocalDateTime.now());
        return userAccessRepository.save(userAccess);
    }

    public UserAccess getUserAccessById(Long id) {
        return userAccessRepository.findById(id)
                .orElseThrow(() -> new UserAccessNotFoundException(id));
    }

    public List<UserAccess> getAllUserAccess() {
        return userAccessRepository.findAll();
    }

    public UserAccess updateUserAccess(Long id, UserAccess userAccess) {
        UserAccess existingUserAccess = getUserAccessById(id);
        existingUserAccess.setUsername(userAccess.getUsername());
        existingUserAccess.setPassword(userAccess.getPassword());
        existingUserAccess.setAccessLevel(userAccess.getAccessLevel());
        existingUserAccess.setUpdated_At(LocalDateTime.now());
        return userAccessRepository.save(existingUserAccess);
    }

    public void deleteUserAccess(Long id) {
        UserAccess existingUserAccess = getUserAccessById(id);
        userAccessRepository.delete(existingUserAccess);
    }
}
