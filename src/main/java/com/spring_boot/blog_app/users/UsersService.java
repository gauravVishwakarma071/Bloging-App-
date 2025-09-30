package com.spring_boot.blog_app.users;

import com.spring_boot.blog_app.exception.InvalidCredentialsException;
import com.spring_boot.blog_app.users.dtos.CreateUserRequest;
import com.spring_boot.blog_app.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    // Creating new users
    public UserEntity createUser(CreateUserRequest request) {

        UserEntity newUser = modelMapper.map(request,UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));

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
                .orElseThrow(InvalidCredentialsException::new);

        var passMatch = passwordEncoder.matches(password, user.getPassword());
        if (!passMatch) {
            throw new InvalidCredentialsException();
        }

        return user;
    }

}
