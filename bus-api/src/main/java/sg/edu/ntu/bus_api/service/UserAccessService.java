package sg.edu.ntu.bus_api.service;

import sg.edu.ntu.bus_api.entity.UserAccess;

import java.util.List;

public interface UserAccessService {
    UserAccess createUserAccess(UserAccess userAccess);

    UserAccess getUserAccessById(Long id);

    List<UserAccess> getAllUserAccess();

    UserAccess updateUserAccess(Long id, UserAccess userAccess);

    void deleteUserAccess(Long id);
}