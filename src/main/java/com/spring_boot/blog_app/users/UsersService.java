package com.spring_boot.blog_app.users;

import com.spring_boot.blog_app.users.dtos.CreateUserRequest;
import com.spring_boot.blog_app.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    // Creating new users
    public UserEntity createUser(CreateUserRequest u) {
        var newUser = UserEntity.builder()
                .username(u.getUsername())
                .email(u.getEmail())
                .build();

        return usersRepository.save(newUser);
    }

    // Get all users
    public Iterable<UserEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    // Get user by id
    public UserEntity getUserById(Long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    // Get user by username
    public UserEntity getUserByUsername(String username) {
        return usersRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    // Login user
    public UserEntity loginUser(String username, String password) {
        var user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(username + " not found"));
        // TODO: match password
        return user;
    }
}
