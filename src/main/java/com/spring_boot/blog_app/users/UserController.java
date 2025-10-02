package com.spring_boot.blog_app.users;

import com.spring_boot.blog_app.common.dtos.ErrorResponse;
import com.spring_boot.blog_app.exception.InvalidCredentialsException;
import com.spring_boot.blog_app.exception.UserNotFoundException;
import com.spring_boot.blog_app.security.JWTService;
import com.spring_boot.blog_app.users.dtos.CreateUserRequest;
import com.spring_boot.blog_app.users.dtos.UserResponse;
import com.spring_boot.blog_app.users.dtos.LoginUserRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {


    private final UsersService usersService;
    private final ModelMapper modelMapper;
    private final JWTService jwtService;
//    @GetMapping("")
//    String getUsers(){
//        return "Users";
//    }

    //User Sign Up Function
    @PostMapping("/signup")
    ResponseEntity<UserResponse> signupUser(@RequestBody CreateUserRequest request){
        UserEntity newUser = usersService.createUser(request);
        URI newUserUri = URI.create("/users/" + newUser.getId());
        var userResponse = modelMapper.map(newUser, UserResponse.class);
        userResponse.setToken(
                jwtService.createJwt(newUser.getId())
        );

        return ResponseEntity.created(newUserUri)
                .body(userResponse);
    }

    //User Login Function
    @PostMapping("/login")
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserRequest request){
        UserEntity savedUser = usersService.loginUser(request.getUsername(), request.getPassword());
        var userResponse = modelMapper.map(savedUser, UserResponse.class);
        userResponse.setToken(
                jwtService.createJwt(savedUser.getId())

        );

        return ResponseEntity.ok(userResponse);
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            InvalidCredentialsException.class

    })
    ResponseEntity<ErrorResponse> handleUsersExceptions(Exception ex){
        String message;
        HttpStatus status;

        if(ex instanceof UserNotFoundException){
           message = ex.getMessage();
           status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof InvalidCredentialsException){
            message = ex.getMessage();
            status = HttpStatus.UNAUTHORIZED;
        }else{
            message = "Something went wrong";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ErrorResponse reponse = ErrorResponse.builder()
                .message(message)
                .build();

        return ResponseEntity.status(status).body(reponse);
    }
}
