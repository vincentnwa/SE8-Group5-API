package sg.edu.ntu.bus_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.edu.ntu.bus_api.entity.UserAccess;
import sg.edu.ntu.bus_api.service.UserAccessService;

import java.util.List;

@RestController
@RequestMapping("/api/user-access")
@RequiredArgsConstructor
public class UserAccessController {

    private final UserAccessService userAccessService;

    @PostMapping
    public ResponseEntity<UserAccess> createUserAccess(@RequestBody UserAccess userAccess) {
        UserAccess createdUserAccess = userAccessService.createUserAccess(userAccess);
        return ResponseEntity.ok(createdUserAccess);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccess> getUserAccessById(@PathVariable Long id) {
        UserAccess userAccess = userAccessService.getUserAccessById(id);
        return ResponseEntity.ok(userAccess);
    }

    @GetMapping
    public ResponseEntity<List<UserAccess>> getAllUserAccess() {
        List<UserAccess> userAccessList = userAccessService.getAllUserAccess();
        return ResponseEntity.ok(userAccessList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAccess> updateUserAccess(@PathVariable Long id, @RequestBody UserAccess userAccess) {
        UserAccess updatedUserAccess = userAccessService.updateUserAccess(id, userAccess);
        return ResponseEntity.ok(updatedUserAccess);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserAccess(@PathVariable Long id) {
        userAccessService.deleteUserAccess(id);
        return ResponseEntity.noContent().build();
    }
}