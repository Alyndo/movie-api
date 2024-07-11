package com.alwyn.techie.movieapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Size(max = 255, message = "Username should not exceed 255 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password should be atleast 8 characters")
    private String password;

    //@ElementCollection(fetch = FetchType.EAGER)
    //@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    //@Column(name = "role")
    @NotBlank(message = "Role is mandatory")
    private String role;
}
