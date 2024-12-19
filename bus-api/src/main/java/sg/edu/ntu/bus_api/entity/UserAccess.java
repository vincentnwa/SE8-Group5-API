package sg.edu.ntu.bus_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "user_access")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    @NotBlank(message = "Username should not be blank.")

    @Column(nullable = false)
    private String password;

    // Is the access level, such as "Admin, user .. etc)
    // Additional column do not need to be use it
    @Column(nullable = false)
    private String accessLevel;

    @Column(name = "created_At", nullable = false, updatable = false)
    private LocalDateTime created_At;

    @Column(name = "updated_At")
    private LocalDateTime updated_At;
}
