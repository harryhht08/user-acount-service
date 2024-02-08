package com.banking.useraccountservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "Username is required.")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    private String username;

    @Indexed(unique = true)
    @NotEmpty(message = "Email is required.")
    @Email(message = "Email should be valid.")
    private String email;

    @NotEmpty(message = "Password hash is required.")
    private String passwordHash;

    @NotEmpty(message = "First name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    private LocalDateTime createdAt;

    // Optional fields depending on your requirements
    private LocalDateTime lastLogin;
    private boolean isActive;
    private String phoneNumber;
    private String address;

    // Parameterized constructor
    public User(String username, String email, String passwordHash, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = LocalDateTime.now();
        this.isActive = true; // Default to active, can be changed with a setter if needed
    }
    // Additional constructors for convenience

    // Getters and setters for all fields
    // ...

    // You should also override toString(), equals(), and hashCode() methods.
    // Remember to never include sensitive fields like passwordHash in the toString() method.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(lastLogin, user.lastLogin) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, firstName, lastName, createdAt, lastLogin, isActive, phoneNumber, address);
    }

}
