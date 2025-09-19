package com.spring_boot.blog_app.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Test
    void can_create_users(){
        var user = UserEntity.builder()
                .username("gaurav")
                .email("gaurav@gmail.com")
                .bio("Learing Spring API building")
                .build();

        usersRepository.save(user);
    }
}
