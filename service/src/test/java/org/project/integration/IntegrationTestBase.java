package org.project.integration;

import org.junit.jupiter.api.BeforeAll;
import org.project.annotation.IT;
import org.project.entity.Role;
import org.project.entity.UserEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.time.LocalDate;

@IT
public class IntegrationTestBase {
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:16.8")
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");

    @BeforeAll
    static void runContainer(){
        container.start();
    }

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
    }

    public UserEntity firstUser() {
        UserEntity userEntity1 = UserEntity.builder()
                .login("Kapucino")
                .firstName("Alex")
                .lastName("Kpucinov")
                .email("kpucino@gmail.com")
                .role(Role.ADMIN)
                .address("25, Vilnus")
                .password("12345")
                .birthday(LocalDate.of(2020,1,1))
                .build();
        return userEntity1;
    }

    public UserEntity secondUser() {
        UserEntity userEntity2 = UserEntity.builder()
                .login("Andreyka")
                .firstName("Andrey")
                .lastName("Kpucinov")
                .email("kpucino@gmail.com")
                .role(Role.ADMIN)
                .address("25, Vilnus")
                .password("12345")
                .birthday(LocalDate.of(2020,1,1))
                .build();
        return userEntity2;
    }
}
