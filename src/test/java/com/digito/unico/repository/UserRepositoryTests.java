package com.digito.unico.repository;

import com.digito.unico.domain.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void AsaveTest() {
        User user = new User(null, "Yago Maia", "yagogmaia@gmail.com", null);
        User createdUser = userRepository.save(user);

        assertThat(createdUser.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest() {
        User user = new User(1L, "Yago Guimaraes", "yagogmaia@gmail.com", null);
        User updatedUser = userRepository.save(user);

        assertThat(updatedUser.getName()).isEqualTo("Yago Guimaraes");
    }

    @Test
    public void getByIdTest() {
        User user = userRepository.findById(1L).get();

        assertThat(user.getEmail()).isEqualTo("yagogmaia@gmail.com");
    }

    @Test
    public void listTest() {
        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
    }
}
