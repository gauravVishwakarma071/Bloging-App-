package com.spring_boot.blog_app.users;

import com.spring_boot.blog_app.users.dtos.CreateUserRequest;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UserSeriveTest {

    @Autowired
    UsersService usersService;

    @Test
    void can_create_user(){
        var user = usersService.createUser(new CreateUserRequest(
           "gaurav",
           "23232",
           "gaurav@gmail.com"
        ));

        Assertions.assertNotNull(user);
        Assertions.assertEquals("gaurav", user.getUsername());
    }
}
