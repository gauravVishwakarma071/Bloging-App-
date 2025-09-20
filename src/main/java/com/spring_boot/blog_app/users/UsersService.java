package com.spring_boot.blog_app.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository  usersRepository;


    //Creating new users
    public UserEntity createUser(String username, String password, String email){
        var newUser = UserEntity.builder()
                .username(username)
//                .password(password)// TODO: encrypt password and save it
                .email(email)
                .build();

        return usersRepository.save(newUser);
    }

    //Find user by its username
    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username);
    }

    //Login user
    public UserEntity loginuser(String username, String password){
        var user = usersRepository.findByUsername(username);
        if(user == null){
            throw new UserNotFoundException(username);
        }

        //TODO match password
        return user;
    }

    //Exception class for user not found
    static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(String username){
            super("user" + username + " not found");
        }
    }
}
