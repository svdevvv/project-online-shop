package org.project.integration.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.project.entity.UserEntity;
import org.project.integration.IntegrationTestBase;
import org.project.repository.UserRepository;
import org.springframework.test.context.TestConstructor;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UserRepositoryTest extends IntegrationTestBase {

    private final UserRepository userRepository;

    @Test
    void saveUser() {
        UserEntity user = firstUser();

        userRepository.save(user);

        assertThat(userRepository.findById(user.getId())).isPresent();
        log.info("User saved with id {}", user.getId());
    }

    @Test
    void findAll() {
        UserEntity user = firstUser();
        UserEntity user2 = secondUser();
        userRepository.save(user);
        userRepository.save(user2);

        List<UserEntity> result = userRepository.findAll();

        assertThat(result).isNotEmpty();
        log.info("Users found with findAll");
    }

    @Test
    void findById() {
        UserEntity user = firstUser();
        UserEntity user2 = secondUser();
        userRepository.save(user);
        userRepository.save(user2);

        Optional<UserEntity> result = userRepository.findById(1L);

        assertEquals(user.getId(), result.map(UserEntity::getId).orElse(null));
        log.info("Users found with findById");
    }

    @Test
    void updateUser() {
        UserEntity user = firstUser();
        userRepository.save(firstUser());

        user.setFirstName("Misha");
        userRepository.save(user);

        assertEquals("Misha", user.getFirstName());
        log.info("Users updated with update");
    }
}