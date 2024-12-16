package sg.edu.ntu.bus_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sg.edu.ntu.bus_api.entity.UserAccess;
import sg.edu.ntu.bus_api.exception.UserAccessNotFoundException;
import sg.edu.ntu.bus_api.repository.UserAccessRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class UserAccessServiceImp implements UserAccessService {

    private final UserAccessRepository userAccessRepository;

    public UserAccessServiceImp(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    @Override
    public UserAccess createUserAccess(UserAccess userAccess) {
        userAccess.setCreatedAt(LocalDateTime.now());
        return userAccessRepository.save(userAccess);
    }

    @Override
    public UserAccess getUserAccessById(Long id) {
        return userAccessRepository.findById(id)
                .orElseThrow(() -> new UserAccessNotFoundException(id));
    }

    @Override
    public List<UserAccess> getAllUserAccess() {
        return userAccessRepository.findAll();
    }

    @Override
    public UserAccess updateUserAccess(Long id, UserAccess userAccess) {
        UserAccess existingUserAccess = getUserAccessById(id);
        existingUserAccess.setUsername(userAccess.getUsername());
        existingUserAccess.setAccessLevel(userAccess.getAccessLevel());
        existingUserAccess.setUpdatedAt(LocalDateTime.now());
        return userAccessRepository.save(existingUserAccess);
    }

    @Override
    public void deleteUserAccess(Long id) {
        UserAccess existingUserAccess = getUserAccessById(id);
        userAccessRepository.delete(existingUserAccess);
    }
}
