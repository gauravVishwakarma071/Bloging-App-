package com.spring_boot.blog_app.users;

import com.spring_boot.blog_app.users.dtos.CreateUserRequest;
import com.spring_boot.blog_app.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    // Creating new users
    public UserEntity createUser(CreateUserRequest request) {

        UserEntity newUser = modelMapper.map(request,UserEntity.class);
       // TODO: save and encrypt password

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
